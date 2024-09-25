import java.util.concurrent.TimeUnit;

public class TokenBucket {
    private final long maxTokens;
    private long currentTokens;
    private final long refillRate;
    private long lastRefillTimestamp;

    public TokenBucket(long maxTokens, long refillRate) {
        this.maxTokens = maxTokens;
        this.currentTokens = maxTokens;
        this.refillRate = refillRate;
        this.lastRefillTimestamp = System.nanoTime();
    }

    public synchronized boolean allowRequest() {
        refill();

        if (currentTokens > 0) {
            currentTokens--;
            return true;
        }
        return false;
    }

    private void refill() {
        long now = System.nanoTime();
        long timeSinceLastRefill = now - lastRefillTimestamp;
        long tokensToAdd = (timeSinceLastRefill / TimeUnit.SECONDS.toNanos(1)) * refillRate;

        if (tokensToAdd > 0) {
            currentTokens = Math.min(maxTokens, currentTokens + tokensToAdd);
            lastRefillTimestamp = now;
        }
    }

    public static class Main {
        public static void main(String[] args) throws InterruptedException {
            TokenBucket bucket = new TokenBucket(10, 2); // 10 tokens max, refills 2 tokens per second

            for (int i = 0; i < 15; i++) {
                if (bucket.allowRequest()) {
                    System.out.println("Request allowed");
                } else {
                    System.out.println("Request denied");
                }
                Thread.sleep(300); // Simulating a request every 300ms
            }
        }
    }
}