class Solution {
    public int minCostClimbingStairs(int[] cost) {
        
        int[] dp = new int[cost.length+1];
        for(int i=2;i<=cost.length;i++){
            int left = cost[i-1] + dp[i-1];
            int right = cost[i-2] + dp[i-2];
            dp[i] = Math.min(left, right);
        }
        return dp[dp.length-1];
    }
}