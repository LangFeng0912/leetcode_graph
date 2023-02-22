package dfs_mid;

import utils.TreeNode;
//给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
//
//        有效 二叉搜索树定义如下：
//
//        节点的左子树只包含 小于 当前节点的数。
//        节点的右子树只包含 大于 当前节点的数。
//        所有左子树和右子树自身必须也是二叉搜索树。

//二叉搜索树的中序遍历 -递增数列
public class validSearchTree {
    TreeNode max;
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        //左，中，右 遍历
        boolean left = isValidBST(root.left);
        if(!left){
            return false;
        }

        //中
        //中序遍历时，每个当前节点值都应该大于之前的
        if(max != null && root.val <= max.val){
            return false;
        }
        max = root;

        //后
        boolean right = isValidBST(root.right);
        return right;

    }
}
