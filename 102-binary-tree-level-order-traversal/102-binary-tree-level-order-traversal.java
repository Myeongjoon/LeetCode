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
    HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
    int max = 0;
    public List<List<Integer>> levelOrder(TreeNode root) {
        levelOrder(0,root);
        List<List<Integer>> response = new ArrayList<>();
        for(int i=0;i<=max;i++){
            if(map.containsKey(i)){
                response.add(map.get(i));
            }
        }
        return response;
    }
    void levelOrder(int level, TreeNode current){
        if(current==null){
            return;
        }
        max = Math.max(max,level);
        if(!map.containsKey(level)){
            map.put(level, new ArrayList<>());
        }
        map.get(level).add(current.val);
        if(current.left!=null){
            levelOrder(level+1, current.left);
        }
        
        
        if(current.right!=null){
            levelOrder(level+1, current.right);
        }
    }
}