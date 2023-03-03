package multi_pointer;

import java.util.Arrays;
import java.util.HashMap;

public class Intersect {

    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length){
            return intersect(nums2,nums1);
        }

        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i<nums1.length; i++){
            if(!map.containsKey(nums1[i])){
                map.put(nums1[i],1);
            }else{
                map.put(nums1[i],map.get(nums1[i])+1);
            }
        }

        int[] ans = new int[nums1.length];
        int i = 0;
        for(int j = 0;j<nums2.length;j++){
            if(map.containsKey(nums2[j])){
                ans[i++] = nums2[j];
                if(map.get(nums2[j])-1 == 0){
                    map.remove(nums2[j]);
                }else{
                    map.put(nums2[j],map.get(nums2[j])-1);
                }
            }
        }

        return Arrays.copyOfRange(ans,0,i);
    }
}
