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
    HashMap<Integer, Long> sum = new HashMap<>();
    HashMap<Integer, Long> count = new HashMap<>();
    public void addLevel(TreeNode current, int level){
        if(current==null){
            return;
        }
        if(!sum.containsKey(level)){
            sum.put(level,0L);
        }
        if(!count.containsKey(level)){
            count.put(level,0L);
        }
        sum.put(level,sum.get(level) + current.val);
        count.put(level,count.get(level) + 1);
        if(current.left!=null){
            addLevel(current.left, level+1);
        }        
        if(current.right!=null){
            addLevel(current.right, level+1);
        }
    }
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> response = new ArrayList<>();
        int level = 0;
        addLevel(root,0);
        while(sum.containsKey(level)){
            response.add((double)sum.get(level)/(double)count.get(level));
            level++;
        }
        return response;
    }
}