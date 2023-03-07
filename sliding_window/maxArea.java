package sliding_window;

public class maxArea {
    //从两侧向中间递减
    public int maxArea(int[] height) {
        int maxA = 0;
        int left = 0, right = height.length-1;
        while(left<right){
            int cur = Math.min(height[left],height[right])*(right-left);
            maxA = Math.max(cur,maxA);
            if(height[left]>=height[right]){
                right--;
            }else{
                left++;
            }
        }
        return maxA;
    }
}
