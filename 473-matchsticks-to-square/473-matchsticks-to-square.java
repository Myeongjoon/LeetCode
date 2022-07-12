class Solution {
    public List<Integer> nums;
    int[] sum = new int[4];
    int div_4 = 0;
    public boolean solution(int depth){
        //4개의 길이가 전부다 같아야함. 
        if(depth == nums.size() - 1){
            int first = sum[0];
            for(int i=1;i<4;i++){
                if(first != sum[i]){
                    return false;
                }
            }
            return true;
        }
        for(int i=0;i<4;i++){
            //가능한 4분면보다 크면 안봐도 됨. 
            if(sum[i] + nums.get(depth+1) <= div_4){    
                sum[i] += nums.get(depth+1);
                boolean response = solution(depth+1);
                if(response){
                    return true;
                }
                sum[i] -= nums.get(depth+1);
            }
        }
        return false;
    }
    public boolean makesquare(int[] matchsticks) {
        for(int i=0;i<4;i++){
            sum[i] = 0;
        }
        int all_sum = 0;
        //만약 4분면의 크기가 나올수가 없으면 그냥 끝남. 
        for(int i=0;i<matchsticks.length;i++){
            all_sum += matchsticks[i];
        }
        div_4 = all_sum/4;
        if(div_4 * 4 != all_sum){
            return false;
        }
        
        
        this.nums = Arrays.stream(matchsticks).boxed().collect(Collectors.toList());
        Collections.sort(this.nums, Collections.reverseOrder());
        return solution(-1);
    }
}