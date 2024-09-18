class NumArray {
    public static int[] tree;
    public static int[] nums;

    public NumArray(int[] nums) {
        int count = nums.length;
        tree = new int[count + 1]; // 1-based index, tree size is count + 1
        NumArray.nums = nums;
        
        // Initialize tree with values
        for (int i = 0; i < count; i++) {
            update(i + 1, nums[i]); // 1-based index
        }
    }

    // Update function to add value at index i
    public void update(int i, int delta) {
        while (i < tree.length) { // tree.length - 1 is the last valid index
            tree[i] += delta;
            i += i & -i;  // Move to the next index
        }
    }

    // Get prefix sum up to index i (1-based index)
    public int sum(int i) {
        int response = 0;
        while (i > 0) {
            response += tree[i];
            i -= i & -i; // Move to the parent index
        }
        return response;
    }
    
    // Get sum of range [left, right]
    public int sumRange(int left, int right) {
        return sum(right + 1) - sum(left); // left and right are 0-based, so adjust
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
