import java.util.*;

class SlidingWindowLog {
    private final int limit;
    private final long windowSizeMillis;
    private final Deque<Long> logs;

    public SlidingWindowLog(int limit, long windowSizeMillis) {
        this.limit = limit;
        this.windowSizeMillis = windowSizeMillis;
        this.logs = new ArrayDeque<>();
    }

    public synchronized boolean allowRequest() {
        long now = System.currentTimeMillis();

        while (!logs.isEmpty() && now - logs.peekFirst() > windowSizeMillis) {
            logs.pollFirst();
        }

        if (logs.size() < limit) {
            logs.addLast(now);
            return true;
        }
        return false;
    }
}