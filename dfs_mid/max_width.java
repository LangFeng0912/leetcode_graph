package dfs_mid;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javafx.util.*;


// pair类可以用Map.Entry<String, Integer>替代
public class max_width {
    ArrayList<Integer> wid = new ArrayList<>();
    public int widthOfBinaryTree(TreeNode root) {
        BFS(root);
        // System.out.println(wid.size());
        return Collections.max(wid);
    }

    public void BFS(TreeNode root){
        if(root == null){
            return;
        }
        Queue<Pair<TreeNode,Integer>> que = new LinkedList<Pair<TreeNode,Integer>>();
        que.offer(new Pair<>(root,1));
        while(!que.isEmpty()){

            // TreeNode cur = que.poll();
            List<Integer> level = new ArrayList<>();
            int l = que.size();

            while(l-- > 0){
                Pair<TreeNode,Integer> cur_pair = que.poll();
                level.add(cur_pair.getValue());
                TreeNode cur = cur_pair.getKey();
                if(cur.left!=null){
                    que.offer(new Pair<>(cur.left,cur_pair.getValue()*2));
                }

                if(cur.right!=null){
                    que.offer(new Pair<>(cur.right,cur_pair.getValue()*2+1));
                }

            }

            int num = level.get(level.size()-1) - level.get(0)+1;
            // System.out.println(num);
            wid.add(num);


        }
    }
}
