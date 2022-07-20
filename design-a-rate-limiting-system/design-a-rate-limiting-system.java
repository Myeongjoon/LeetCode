class RateLimiter {
    
    private int allowedRequest;
    
    private int timeWindowInSec;
    
    private Queue<Integer> queue;
    
    
    public RateLimiter(int n, int t) {
        this.allowedRequest = n;
        this.timeWindowInSec = t;
        queue = new LinkedList<>();
    }
    
    public boolean shouldAllow(int timestamp) {
        boolean isAllowed = false;
        int lastTime = timestamp - timeWindowInSec + 1;
        while (queue.peek() != null && queue.peek() < lastTime) {
            queue.poll();
        }
        if (queue.size() < allowedRequest) {
            queue.add(timestamp);
            isAllowed = true;
        }
        return isAllowed;
    }
}

/**
 * Your RateLimiter object will be instantiated and called as such:
 * RateLimiter obj = new RateLimiter(n, t);
 * boolean param_1 = obj.shouldAllow(timestamp);
 */