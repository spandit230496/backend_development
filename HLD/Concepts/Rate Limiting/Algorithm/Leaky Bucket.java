import java.util.*;

class LeakyBucket {
    private final int capacity;
    private final double leakRate; // requests per second
    private final Queue<Long> queue;
    private long lastLeakTime;

    public LeakyBucket(int capacity, double leakRate) {
        this.capacity = capacity;
        this.leakRate = leakRate;
        this.queue = new LinkedList<>();
        this.lastLeakTime = System.nanoTime();
    }

    public synchronized boolean allowRequest() {
        long now = System.nanoTime();
        double elapsedSeconds = (now - lastLeakTime) / 1_000_000_000.0;

        int leaks = (int) (elapsedSeconds * leakRate);
        for (int i = 0; i < leaks && !queue.isEmpty(); i++) {
            queue.poll();
        }

        lastLeakTime = now;

        if (queue.size() < capacity) {
            queue.offer(now);
            return true;
        }
        return false;
    }
}