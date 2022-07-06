class SparseVector {
    LinkedList root;
    int size = 0;
    class LinkedList{
        int i;
        int data;
        LinkedList next = null;
    }
    
    SparseVector(int[] nums) {
        LinkedList last = null;
        for(int i=0;i<nums.length;i++){
            if(i==0){
                this.root = new LinkedList();
                root.i = 0;
                root.data = nums[i];
                root.next = null;
                last = root;
            }else{
                last.next = new LinkedList();
                last = last.next;
                last.data = nums[i];
                last.i = i;
            }
        }
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int response = 0;
        LinkedList left = this.root;
        LinkedList right = vec.root;
        while(left != null && right != null){
            if(left.i == right.i){
                response += left.data * right.data;
                left = left.next;
                right = right.next;
            }else if(left.i > right.i){
                right = right.next;
            }else{
                left = left.next;
            }
        }
        return response;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);