package hard;

import utils.TreeNode;
import java.util.*;

public class Codec {
    List<Integer> leaf =  new ArrayList<>();
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String res = dfs(root);
        System.out.println(res);
        return res;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strArr = data.split("_");
        List<String> list = Arrays.asList(strArr);
        LinkedList<String> nodeL =  new LinkedList<>(list);
        return dfs1(nodeL);
    }

    public String dfs(TreeNode root){
        if(root == null) return " _";
        StringBuilder sb = new StringBuilder();
        sb.append(root.val).append("_");
        sb.append(dfs(root.left)).append(dfs(root.right));
        String id = sb.toString();
        return id;
    }

    public TreeNode dfs1(LinkedList<String> nodeL){
        if(nodeL.get(0).equals(" ")){
            nodeL.removeFirst();
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(nodeL.get(0)));
        nodeL.removeFirst();
        root.left = dfs1(nodeL);
        root.right = dfs1(nodeL);
        return root;

    }
}
