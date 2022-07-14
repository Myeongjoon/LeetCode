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
    int preorderIndex = 0;
    HashMap<Integer, Integer> inorderLocationMap = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<inorder.length;i++){
            inorderLocationMap.put(inorder[i],i);
        }
        return build(preorder, 0, inorder.length-1);
    }
    
    public TreeNode build(int[] preorder, int left, int right){
        if(left > right){
            return null;
        }
        
        int currentVal = preorder[preorderIndex];
        preorderIndex++;
        TreeNode currentNode = new TreeNode(currentVal);
        int target = inorderLocationMap.get(currentVal);
        currentNode.left = build(preorder, left, target - 1);
        currentNode.right = build(preorder, target + 1, right);
        
        return currentNode;
    }
}