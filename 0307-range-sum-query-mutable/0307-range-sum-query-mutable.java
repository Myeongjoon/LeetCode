

 class NumArray {

    public static int[] tree;
    public static int[] nums;
    public NumArray(int[] nums) {
        int count = nums.length;
        tree = new int[count+1];
                NumArray.nums = nums;
        for(int i=1;i<=count;i++){
            makeNode(i, nums[i-1]);
        }
    }

    public void makeNode(int i, int target){
        while(i<tree.length){
          tree[i] += target;
          i += i& -i;  
        }
    }
    
    public void update(int i, int val) {
        int diff = val - nums[i];
        nums[i] = val;
        makeNode(i+1, diff);
    }

    public int sum(int i){
        int response = 0;
        while(i >0){
            response += tree[i];
            i = i - (i& -i);
        }
        return response;
    }
    
    public int sumRange(int left, int right) {
        return sum(right+1) - sum(left);
    }
}