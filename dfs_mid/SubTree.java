package dfs_mid;
import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class SubTree {
    //注意找出所有的，先
    //然后dfs比较
    List<TreeNode> rootBL = new ArrayList<>();
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(B == null) return false;
        traverse(A,B);
        for (TreeNode node:rootBL){
            if(dfs(B,node)){
                return true;
            }
        }
        return false;
    }

    public void traverse(TreeNode root, TreeNode B){
        if(root == null){
            return;
        }
        if(root.val == B.val){
            rootBL.add(root);
            // return;
        }
        traverse(root.left,B);
        traverse(root.right,B);

    }

    public boolean dfs(TreeNode A, TreeNode B){

        if(A.val != B.val){
            return false;
        }
        if(A.left!=null){
            if(B.left==null){
                return false;
            }
            else{
                boolean ans = dfs(A.left,B.left);
                if(!ans){
                    return false;
                }
            }
        }
        if(A.right!=null){
            if(B.right==null){
                return false;
            }
            else{
                boolean ans = dfs(A.right,B.right);
                return ans;
            }
        }
        return true;

    }
}
