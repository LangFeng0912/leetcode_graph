package merge_sort;

public class SortColor {
    int[] temp;
    public void sortColors(int[] nums) {

        int n = nums.length;
        if(n<=1) return;
        temp = new int[n];
        mergeSort(nums,0, n-1);
    }

    public void mergeSort(int[] nums,int l,int r){
        if(l == r) return;
        int mid = l+(r-l)/2;
        mergeSort(nums,l,mid);
        mergeSort(nums,mid+1,r);
        merge(nums,l,mid,r);
    }

    public void merge(int[] nums, int l, int mid, int r){
        for(int k = l ;k<=r; k++){
            temp[k] = nums[k];
        }
        int p = l , q = mid+1, count = l;
        while(p<=mid && q<=r){
            if(temp[p]<temp[q]){
                nums[count++] = temp[p++];
            }else{
                nums[count++] = temp[q++];
            }
        }

        while(p<=mid){
            nums[count++] = temp[p++];
        }
        while(q<=r){
            nums[count++] = temp[q++];
        }
    }
}
