package dfs_mid;

import utils.TreeNode;

public class Trim {

    //二叉搜索树剪枝

    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root == null){
            return null;
        }

        if(root.val<low){
            return trimBST(root.right,low,high);
        }
        else if(root.val>high){
            return trimBST(root.left,low,high);
        }
        else{
            root.left = trimBST(root.left,low,high);
            root.right = trimBST(root.right,low,high);
        }

        return root;


    }

}
