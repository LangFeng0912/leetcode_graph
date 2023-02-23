package dfs_mid;

import java.util.*;
import utils.Node;
public class ASTtoLinked {
    List<Node> list = new ArrayList<>();
    public Node treeToDoublyList(Node root) {
        traverse(root);
        int n = list.size();

        for(int i = 0; i<n;i++){
            int l_index = (i-1+n)%n;
            int r_index = (i+1)%n;
            list.get(i).left = list.get(l_index);
            list.get(i).right = list.get(r_index);
        }
        if(list.size()==0){
            return null;
        }else{
            return list.get(0);
        }

    }

    public void traverse(Node node){
        if(node == null) return;
        traverse(node.left);
        list.add(node);
        traverse(node.right);
    }
}
