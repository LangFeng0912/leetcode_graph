package heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class TopKOccur {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<nums.length; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],1);
            }else{
                map.put(nums[i],map.get(nums[i])+1);
            }
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>(new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[1]-o2[1];
            }
        });

        for(int key:map.keySet()){
            int[] cur = new int[]{key, map.get(key)};
            if(minHeap.size()<k){
                minHeap.offer(cur);
            }else{
                if(minHeap.peek()[1]>map.get(key)){
                    continue;
                }
                else{
                    minHeap.poll();
                    minHeap.offer(cur);
                }
            }

        }

        int[] ans =new int[k];
        for(int i = 0; i<k ;i++){
            ans[i] = minHeap.poll()[0];
        }
        return ans;

    }
}
