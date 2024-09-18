class NumArray {

    public static int[] tree;
    public static int[] nums;

    public NumArray(int[] nums) {
        int count = nums.length;
        tree = new int[count + 1]; // 1-based index, so tree size is count + 1
        NumArray.nums = nums;
        
        // Initialize the tree by updating the tree with nums values
        for (int i = 0; i < count; i++) {
            makeNode(i + 1, nums[i]); // 1-based index for tree, 0-based for nums
        }
    }

    // Updates the Fenwick Tree with the value `target` at index `i`
    public void makeNode(int i, int target) {
        while (i < tree.length) {
            tree[i] += target;
            i += i & -i;  // Move to the next index
        }
    }

    // Get the prefix sum up to index `i`
    public int sum(int i) {
        int response = 0;
        while (i > 0) {
            response += tree[i];
            i -= i & -i; // Move to the parent index
        }
        return response;
    }
    
    // Get the sum of the range [left, right] (0-based index)
    public int sumRange(int left, int right) {
        return sum(right + 1) - sum(left); // sum(left - 1) for prefix sum
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
