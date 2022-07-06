class Solution {
    int[] w;
    int[] w1;
    int sum = 0;

    public Solution(int[] w) {
        int w1 = 0;
        int w2 = 0;
        this.w1 = new int[w.length];
        this.w = w;
        for(int i=0;i<w.length;i++){
            this.sum = this.sum + w[i];
            this.w1[i] = w2;
            w2 = w2 + w[i];
        }
    }

    public int pickIndex() {
        double rand = Math.random();
        for(int i=0;i<w.length;i++){
            double left = (double)this.w1[i]/this.sum;
            if(left > rand){
                return i-1;
            }
        }
        return w.length-1;
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