class Solution {
    int[] w;
    int[] prefixSum;
    int sum = 0;

    public Solution(int[] w) {
        int prefixSum = 0;
        this.prefixSum = new int[w.length];
        this.w = w;
        for(int i=0;i<w.length;i++){
            this.sum = this.sum + w[i];
            prefixSum = prefixSum + w[i];
            this.prefixSum[i] = prefixSum;
        }
    }

    public int pickIndex() {
        double rand = Math.random() * this.sum;
        int low  = 0;
        int high = this.w.length;
        while(low<high){
            // better to avoid the overflow
            int mid = low + (high - low) / 2;
            if(prefixSum[mid] < rand){
                low = mid + 1;
            }else{
                high = mid;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] w = {1,3};
        Solution s = new Solution(w);
        s.pickIndex();
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */