import java.util.concurrent.*;

class RateLimiterService {
    private final ConcurrentHashMap<String, TokenBucket> userBuckets = new ConcurrentHashMap<>();

    public boolean allowRequest(String userId) {
        userBuckets.putIfAbsent(userId, new TokenBucket(5, 1)); // 5 tokens, 1/sec
        return userBuckets.get(userId).allowRequest();
    }
}