package hash_table;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

public class MagicNumber {
    // 最小堆实现
    PriorityQueue<Integer> minheap = new PriorityQueue<>();
    //最大堆实现
    PriorityQueue<Integer> maxheap = new PriorityQueue<Integer>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    });
    HashSet<Long> set = new HashSet<>();
    public int getKthMagicNumber(int k) {
        PriorityQueue<Long> que = new PriorityQueue<>();
        int[] factors = new int[]{3,5,7};
        que.offer((long)1);
        set.add((long)1);
        int ans = 0;
        for(int i = 0; i<k ;i++){
            long top = que.poll();
            ans = (int) top;
            for(int f : factors){
                if(set.add(top*f)){
                    que.offer(top*f);
                }
            }
        }
        return ans;
    }
}
