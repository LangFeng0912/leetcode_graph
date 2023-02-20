package dfs_mid;

public class TreeNode {
    int val;
   TreeNode left;
   TreeNode right;
   TreeNode(int x) { val = x; }
 * }
public class Nearest_Ans {
    List<List<TreeNode>> pathL = new ArrayList<>();
    // ArrayList<TreeNode> pathQ = new ArrayList<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> path1 = new ArrayList<>();
        ArrayList<TreeNode> path2 = new ArrayList<>();

        traverse(root,path1,p);
        traverse(root,path2,q);
        // traverse_2(root,path2,p,q);

        // System.out.println(pathL.get(0).size());
        // System.out.println(pathL.get(1).size());

        int n = pathL.get(0).size();
        for(int i = n-1;i>=0;i--){
            TreeNode node = pathL.get(0).get(i);
            if(pathL.get(1).contains(node)){
                return node;
            }
        }

        return root;

    }

    public void traverse(TreeNode node, ArrayList<TreeNode> path, TreeNode tar ){
        path.add(node);
        if(node == tar){
            // System.out.println(path.size());
            pathL.add(new ArrayList<>(path));
            // System.out.println(pathP.size());
            // path.remove(path.size()-1);
            return;

        }

        else{

            // System.out.println(node.val);
            if (node.left != null){
                traverse(node.left, path, tar);
            }
            if (node.right != null){
                traverse(node.right, path, tar);
            }

            path.remove(path.size()-1);
        }



    }
}
