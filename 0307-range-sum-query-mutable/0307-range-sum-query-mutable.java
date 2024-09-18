class NumArray {
    static int[] trees;
    static int size;
    public NumArray(int[] nums) {
        size = nums.length;
        trees = new int[size*3];
        for(int i=0;i<size;i++){
            trees[i + size] = nums[i];
        }
        for(int i= size - 1;i>0;i--){
            trees[i] = trees[i * 2] + trees[i * 2 + 1];
        }
    }
    
    public void update(int index, int val) {
        index += size;
        trees[index] = val;
        while(index > 1){
            index /= 2;
            trees[index] = trees[2*index] + trees[2*index + 1];
        }
    }
    
    public int sumRange(int left, int right) {
        left += size;
        right += size + 1;  // [left, right] 구간을 포함하도록 수정
        int response = 0;
        while(left < right){
            if(left % 2 == 1){
                response += trees[left];
                left ++;
            }
            if(right % 2 == 1){
                right --;
                response += trees[right];
            }
            left /= 2;
            right /= 2;
        }
        return response;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */