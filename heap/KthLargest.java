package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargest {
    public int findKthLargest(int[] nums, int k) {
        // Arrays.sort(nums);
        // return nums[nums.length-k];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        for(int i = 0; i<nums.length; i++){
            maxHeap.offer(nums[i]);
        }

        int j = 0;
        int temp = 0;;
        while(j<k){
            temp = maxHeap.poll();
            j++;
        }
        return temp;
    }
}
