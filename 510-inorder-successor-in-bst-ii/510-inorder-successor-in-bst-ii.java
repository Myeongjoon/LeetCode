/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    int min = Integer.MAX_VALUE;
    Node minNode =null;
    int target = 0;
    Node root;
    public Node inorderSuccessor(Node node) {
        root = node;
        target = node.val;
        while(root.parent!=null){
            root = root.parent;
        }
        findSuccessor(root);
        return minNode;
    }
    public void findSuccessor(Node node){
        if(node.val <= target){
           
        }else{
            if(minNode == null){
                minNode = node;
            }else if(minNode.val > node.val){
                minNode = node;
            }
        }
        if(node.left!=null){
            findSuccessor(node.left);
        }
        
        if(node.right!=null){
            findSuccessor(node.right);
        }
    }
}