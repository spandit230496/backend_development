class FixedWindowRateLimiter {
    private final int limit;
    private final long windowSizeMillis;
    private int counter;
    private long windowStart;

    public FixedWindowRateLimiter(int limit, long windowSizeMillis) {
        this.limit = limit;
        this.windowSizeMillis = windowSizeMillis;
        this.counter = 0;
        this.windowStart = System.currentTimeMillis();
    }

    public synchronized boolean allowRequest() {
        long now = System.currentTimeMillis();

        if (now - windowStart > windowSizeMillis) {
            counter = 0;
            windowStart = now;
        }

        if (counter < limit) {
            counter++;
            return true;
        }
        return false;
    }
}