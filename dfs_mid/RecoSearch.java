package dfs_mid;

import utils.TreeNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class RecoSearch {
    List<Integer> valL = new ArrayList<>();
    public void recoverTree(TreeNode root) {
        traverse(root);
        List<Integer> valL_sort = new ArrayList<>(valL);
        Collections.sort(valL_sort);
        List<Integer> val = new ArrayList<>();
        for(int i = 0; i<valL.size(); i++){
            if(valL.get(i) != valL_sort.get(i)){
                // System.out.println("yes");
                val.add(valL.get(i));
            }
        }
        // System.out.println(val.size());
        int val0 = val.get(0); int val1 = val.get(1);
        switch_n(root,val0,val1);


    }

    public void traverse(TreeNode root){
        if(root == null){
            return;
        }
        traverse(root.left);
        valL.add(root.val);
        traverse(root.right);
    }

    public void switch_n(TreeNode root, int i, int j){

        if(root == null){
            return;
        }
        System.out.println(root.val);
        if (root.val == i || root.val == j){
            if(root.val == i){
                root.val = j;
                // return;
            }else{
                root.val = i;
                // return;
            }
        }

        switch_n(root.left,i,j);
        switch_n(root.right,i,j);
    }
}
