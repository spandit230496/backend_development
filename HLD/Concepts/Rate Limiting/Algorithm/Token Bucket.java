class TokenBucket {
    private final int capacity;
    private final double refillRate; // tokens per second
    private double tokens;
    private long lastRefillTime;

    public TokenBucket(int capacity, double refillRate) {
        this.capacity = capacity;
        this.refillRate = refillRate;
        this.tokens = capacity;
        this.lastRefillTime = System.nanoTime();
    }

    public synchronized boolean allowRequest() {
        long now = System.nanoTime();
        double elapsedSeconds = (now - lastRefillTime) / 1_000_000_000.0;

        // Refill tokens
        tokens = Math.min(capacity, tokens + elapsedSeconds * refillRate);
        lastRefillTime = now;

        if (tokens >= 1) {
            tokens -= 1;
            return true;
        }
        return false;
    }
}