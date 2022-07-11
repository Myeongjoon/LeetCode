/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int count = -1;
    HashMap<Integer, Integer> map = new HashMap<>();
    ArrayList<Integer> response = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        if(root != null){
            deep(0,root);
        }
        for(int i=0;i<=count;i++){
            response.add(map.get(i));
        }
        return response;
    }
    
    public void deep(int depth, TreeNode current){
        count = Math.max(count,depth);
        if(current == null){
            return;
        }
        map.put(depth,current.val);
        if(current.left!=null){
            deep(depth+1,current.left);
        }
        if(current.right!=null){
            deep(depth+1,current.right);
        }
    }
}