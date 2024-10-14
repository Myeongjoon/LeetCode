class Solution {
    static class Node implements Comparable<Node> {
        long raw;
        long val;

        @Override
        public int compareTo(Node other) {
            return -Long.compare(this.raw, other.raw);
        }
    }

    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        long sum = 0;
        for(int i=0;i<nums.length;i++){
            Node t = new Node();
            t.val = (long) Math.ceil(nums[i] / 3.0);
            t.raw = nums[i];
            queue.offer(t);
        }
        while(k>0){
            Node front = queue.poll();
            sum += front.raw;
            front.raw = front.val;
            front.val = (long) Math.ceil(front.raw / 3.0);
            k--;
            queue.offer(front);
        }
        return sum;
    }
}