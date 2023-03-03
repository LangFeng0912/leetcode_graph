package multi_pointer;

public class Mountain {
    public int longestMountain(int[] arr) {
        if(arr.length<3) return 0;
        int max_l = 0;
        for(int i = 1;i<arr.length;i++){
            int l =i, r = i;
            while(l-1>=0 && arr[l-1]<arr[l]){
                l--;
            }
            while(r<arr.length-1 && arr[r+1]<arr[r]){
                r++;
            }
            int count = 0;
            if(l == i || r == i){
                count = 0;
            }else{
                count = r-l+1;
            }
            max_l = Math.max(max_l, count);
        }
        return max_l;
    }
}
