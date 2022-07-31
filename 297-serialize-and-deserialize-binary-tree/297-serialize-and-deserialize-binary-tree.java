/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    StringBuilder internal = new StringBuilder();
    TreeNode response;
    
    public String serialize2(TreeNode root, String current){
        if(root == null){
            current = current + "null,";
        }else{
            current = current + root.val + ",";
            current = serialize2(root.left, current);
            current = serialize2(root.right, current);
        }
        return current;
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String response = serialize2(root, "");
        System.out.println(response);
        return response;
    }
    
    public TreeNode deserialize2(ArrayList<String> l ){
        if (l.get(0).equals("null")) {
          l.remove(0);
          return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(l.get(0)));
        l.remove(0);
        root.left = deserialize2(l);
        root.right = deserialize2(l);

        return root;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] splited = data.split(",");
        ArrayList<String> list = new ArrayList<>();
        for(int i=0;i<splited.length;i++){
            list.add(splited[i]);
        }
        return deserialize2(list);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));