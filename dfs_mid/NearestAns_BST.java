package dfs_mid;

import utils.TreeNode;

import java.util.*;
import java.util.LinkedList;

public class NearestAns_BST {
    List<TreeNode> listP = new ArrayList<>();
    List<TreeNode> listQ = new ArrayList<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        LinkedList<TreeNode> list0 = new LinkedList<>();
        LinkedList<TreeNode> list1 = new LinkedList<>();
        dfs(root, p, q,list0);
        dfs(root, p, q,list1);

        System.out.println(listP.size());
        System.out.println(listQ.size());

        for(int i = listQ.size()-1; i>= 0; i--){
            if(listP.contains(listQ.get(i))){
                return listQ.get(i);
            }
        }

        return root;


    }

    public void dfs(TreeNode root, TreeNode p, TreeNode q, LinkedList<TreeNode> list){
        if(root == null){
            return ;
        }
        if(root.val == p.val || root.val == q.val){
            if(root.val == p.val){
                list.add(root);
                listP = new ArrayList<>(list);
                list.removeLast();
            }else{
                list.add(root);
                listQ = new ArrayList<>(list);
                list.removeLast();
            }
        }

        list.add(root);
        dfs(root.left,p, q,list);
        dfs(root.right, p, q,list);
        list.removeLast();
    }
}
