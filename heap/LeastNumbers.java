package heap;

public class LeastNumbers {
    public int[] getLeastNumbers(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i = 0; i<arr.length; i++){
            minHeap.offer(arr[i]);
        }
        int[] ans = new int[k];
        for(int j = 0; j<k; j++){
            ans[j] = minHeap.poll();
        }
        return ans;
    }
}
