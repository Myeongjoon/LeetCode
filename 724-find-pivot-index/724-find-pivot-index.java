class Solution {
    public int pivotIndex(int[] nums) {
        int[] prefix_sum = new int[nums.length];
        int sum = 0;
        for(int i=0;i<nums.length;i++)
        {
            sum = sum + nums[i];
            prefix_sum[i] = sum;
        }
        if(sum - prefix_sum[0] == 0){
            return 0;
        }
        for(int i=0;i<nums.length-1;i++){
            if(prefix_sum[i] == sum - prefix_sum[i+1]){
                return i+1;
            }
        }
        return -1;
    }
}