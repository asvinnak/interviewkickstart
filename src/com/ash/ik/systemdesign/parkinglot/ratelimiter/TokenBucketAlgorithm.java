package com.ash.ik.systemdesign.parkinglot.ratelimiter;

public class TokenBucketAlgorithm {

    private final long maxBucketSize;
    private final long rateFillRate;
    private double currentBucketSize;
    private long lastRefillTimestamp;

    public TokenBucketAlgorithm(long maxBucketSize, long rateFillRate) {
        this.maxBucketSize = maxBucketSize;
        this.rateFillRate = rateFillRate;

        this.currentBucketSize = maxBucketSize;
        this.lastRefillTimestamp = System.nanoTime();
    }

    public synchronized boolean allowRequest(int tokens) {
        refill();

        if(currentBucketSize > tokens) {
            currentBucketSize -= tokens;
            return true;
        }

        return false;
    }

    private void refill() {
        long now = System.nanoTime();

        double tokensToAdd = (now - lastRefillTimestamp) * rateFillRate / 1e9;
        currentBucketSize = Math.min(currentBucketSize + tokensToAdd, maxBucketSize);
        lastRefillTimestamp = now;
    }


}
