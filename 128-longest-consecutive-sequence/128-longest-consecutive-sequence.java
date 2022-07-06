import java.util.HashSet;

class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        int max = 0;
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }

        for(Integer i : set){
            int count = 1;
            if(!set.contains(i-1)){
                int current = i;
                while(set.contains(current+1)){
                    count++;
                    current++;
                }
            }
            max = Math.max(max, count);
        }
        return max;
    }
}