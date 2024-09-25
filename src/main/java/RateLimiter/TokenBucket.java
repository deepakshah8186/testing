package RateLimiter;

public class TokenBucket {

    public static int numberOfRequest =  10;

    public static int windowSizeForRateLimitInMilliSeconds = 1 * 1000;

    public static int maxBucketSize = 10;

    private int numberOfTokenAvailable;
    private int numberOfRequests;
    private long lastRefillTime;
    private long nextRefillTime;


    public TokenBucket(int maxBucketSize, int numberOfRequests, int windowSizeForRateLimitInMilliSeconds) {
        this.maxBucketSize = maxBucketSize;
        this.numberOfRequests = numberOfRequests;
        this.windowSizeForRateLimitInMilliSeconds = windowSizeForRateLimitInMilliSeconds;
        this.refill();
    }

    public boolean tryConsume(){
        refill();
        if(this.numberOfTokenAvailable > 0){
            this.numberOfTokenAvailable --;
            return true;
        }
        return false;
    }

    private void refill(){
        if(System.currentTimeMillis() < this.nextRefillTime){
            return;
        }
        this.lastRefillTime = System.currentTimeMillis();
        this.nextRefillTime = this.lastRefillTime + this.windowSizeForRateLimitInMilliSeconds;
        this.numberOfTokenAvailable = Math.min(this.maxBucketSize, this.numberOfTokenAvailable + this.numberOfRequests);
    }

    public static void main(String[] args) {
        TokenBucket tokenBucket = new TokenBucket(maxBucketSize,
                numberOfRequest,
                windowSizeForRateLimitInMilliSeconds);

        int numberOfConsumed = 0;
        long startTime = System.currentTimeMillis();

        int totalTime =  2*1000;
        while ((System.currentTimeMillis() - startTime) < totalTime){
            boolean consumeSuccess = tokenBucket.tryConsume();
            System.out.println("try consume = "+ consumeSuccess);
            if(consumeSuccess){
                numberOfConsumed++;
            }
        }

        System.out.println("no of consumed request = "+  numberOfConsumed);
        System.out.println("time taken = "+ totalTime);
        System.out.println("no of request per window =" +  (numberOfConsumed* windowSizeForRateLimitInMilliSeconds/totalTime));
        System.out.println("no of request per window expected = "+ numberOfRequest);

    }
}