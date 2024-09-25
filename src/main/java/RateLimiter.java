import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
// Good one using scheduler
//Rate limiting is a technique used to control the rate of requests sent or processed by a service. There are several algorithms for rate limiting, such as:
//
//Token Bucket
//Leaky Bucket
//Fixed Window Counter
//Sliding Window Log
//Sliding Window Counter
//Here, we'll discuss the Token Bucket algorithm, which is one of the most common approaches for rate limiting.
//
//Token Bucket Algorithm in Java:
//In the Token Bucket algorithm:
//
//A bucket holds a fixed number of tokens.
//Tokens are added to the bucket at regular intervals (representing time).
//For each request, a token is removed from the bucket.
//If the bucket has no tokens, the request is denied.

//Explanation:
//maxTokens: The maximum number of tokens that can be in the bucket (maximum requests allowed).
//refillRate: The number of tokens added per second (how often requests can be made).
//availableTokens: The current number of tokens available to handle requests.
//        Steps:
//The RateLimiter is initialized with a maximum number of tokens and a refill rate.
//        Every second, tokens are refilled according to the refill rate.
//tryAcquire() checks if a token is available. If yes, it removes a token and allows the request. Otherwise, it denies the request.

// SEE the OUTPUT
// check this video for understanding only https://www.youtube.com/watch?v=PJ-c0QI-QCk
public class RateLimiter {
    private final long maxTokens;      // Maximum number of tokens the bucket can hold
    private final long refillRate;     // Number of tokens added per second
    private long availableTokens;      // Current number of available tokens
    private final ScheduledExecutorService scheduler;

    public RateLimiter(long maxTokens, long refillRate) {
        this.maxTokens = maxTokens;
        this.refillRate = refillRate;
        this.availableTokens = maxTokens; // Initially, bucket is full
        this.scheduler = Executors.newScheduledThreadPool(1);
        // Java provides Executors to create thread pools:A thread pool is a collection of pre-initialized worker
        // threads that execute tasks. Instead of creating new threads for every task, tasks are submitted to the thread pool, which assigns them to available threads.

        // Schedule the token refilling task
        scheduler.scheduleAtFixedRate(this::refillTokens, 1, 1, TimeUnit.SECONDS);
    }

    // Method to try acquiring a token
    public synchronized boolean tryAcquire() {
        if (availableTokens > 0) {
            availableTokens--;
            return true;  // Request allowed
        }
        return false;      // Request denied
    }

    // Refill tokens at the specified rate
    private synchronized void refillTokens() {
        availableTokens = Math.min(maxTokens, availableTokens + refillRate);
        System.out.println("Tokens refilled. Available tokens: " + availableTokens);
    }

    // Shutdown the scheduler when no longer needed
    public void shutdown() {
        scheduler.shutdown();
    }

    public static void main(String[] args) throws InterruptedException {
        // Example: A bucket that holds max 5 tokens and refills 2 tokens per second
        RateLimiter rateLimiter = new RateLimiter(5, 2);

        // Simulate 10 requests
        for (int i = 0; i < 10; i++) {
            if (rateLimiter.tryAcquire()) {
                System.out.println("Request " + (i + 1) + " allowed.");
            } else {
                System.out.println("Request " + (i + 1) + " denied.");
            }
            Thread.sleep(500); // Simulating request interval
        }

        // Shutdown rate limiter scheduler
        rateLimiter.shutdown();
    }
}

//Request 1 allowed.
//        Request 2 allowed.
//        Request 3 allowed.
//        Request 4 allowed.
//        Request 5 allowed.
//        Request 6 denied.
//Tokens refilled. Available tokens: 2
//Request 7 allowed.
//        Request 8 allowed.
//        Request 9 denied.
//Tokens refilled. Available tokens: 1
//Request 10 allowed.

