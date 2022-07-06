class Solution {
    public int subarraySum(int[] nums, int k) {
        int response = 0;
        int current_sum = 0;
        HashMap<Integer,Integer> sum = new HashMap<>();
        sum.put(0,1);
        for(int i=0;i<nums.length;i++){
            int current = nums[i];
            current_sum = current_sum + current;
            if(sum.containsKey(current_sum - k)){
                response += sum.get(current_sum - k);
            }
            if(sum.containsKey(current_sum)){
                sum.put(current_sum, sum.get(current_sum) + 1);
            }else{
                sum.put(current_sum, 1);
            }
        }   
        return response;
    }
}