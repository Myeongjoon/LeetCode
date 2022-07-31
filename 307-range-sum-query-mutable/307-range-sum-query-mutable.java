class NumArray {

    int[] segment;
    int n;
    public NumArray(int[] nums) {
        if (nums.length > 0) {
            n = nums.length;
            segment = new int[n * 2];
            buildTree(nums);
        }
    }
    private void buildTree(int[] nums) {
        for (int i = n, j = 0;  i < 2 * n; i++,  j++)
            segment[i] = nums[j];
        for (int i = n - 1; i > 0; --i)
            segment[i] = segment[i * 2] + segment[i * 2 + 1];
    }
    
    void update(int pos, int val) {
        pos += n;
        segment[pos] = val;
        while (pos > 0) {
            int left = pos;
            int right = pos;
            if (pos % 2 == 0) {
                right = pos + 1;
            } else {
                left = pos - 1;
            }
            segment[pos / 2] = segment[left] + segment[right];
            pos /= 2;
        }
    }
    
    public int sumRange(int l, int r) {
        l += n;
        r += n;
        int sum = 0;
        while (l <= r) {
            if ((l % 2) == 1) {
               sum += segment[l];
               l++;
            }
            if ((r % 2) == 0) {
               sum += segment[r];
               r--;
            }
            l /= 2;
            r /= 2;
        }
        return sum;
    }
}