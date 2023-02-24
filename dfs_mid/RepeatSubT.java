package dfs_mid;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


//某些时刻需要序列化子树，通过dfs和stringBuilder；
// 然后用hashMap判断是否重复
public class RepeatSubT {
    List<TreeNode> res = new ArrayList<>();
    HashMap<String,Integer> map = new HashMap<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return res;
    }

    public String dfs(TreeNode root){
        if(root == null) return " ";
        StringBuilder sb = new StringBuilder();
        sb.append(root.val).append("_");
        sb.append(dfs(root.left)).append(dfs(root.right));
        String key = sb.toString();
        if(!map.containsKey(key)){
            map.put(key,1);
        }else{
            map.put(key,map.get(key)+1);
            if(map.get(key) == 2){
                res.add(root);
            }
        }
        return key;
    }
}
