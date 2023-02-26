package heap;

import java.util.PriorityQueue;

public class KthLargestinStream {
    int tar;
    PriorityQueue<Integer> maxHeap;
    public KthLargestinStream(int k, int[] nums) {
        maxHeap = new PriorityQueue<Integer>();
        tar = k;
        for(int i = 0; i<nums.length; i++){
            add(nums[i]);
        }

    }

    public int add(int val) {
        maxHeap.offer(val);
        if(maxHeap.size() > tar){
            maxHeap.poll();
        }
        return maxHeap.peek();
    }
}
