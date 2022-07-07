class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int left = 0;
        int response = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            sum = sum + nums[i];
            while(sum >= target){
                response = Math.min(response, i + 1 - left);
                sum = sum - nums[left];
                left++;
            }
        }
        return response == Integer.MAX_VALUE ? 0 : response;
    }
}