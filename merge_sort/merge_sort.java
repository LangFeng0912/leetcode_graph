package merge_sort;

public class merge_sort {
    int[] temp;

    //初始化temp数组，左侧 == 右侧时返回条件
    public int[] sortArray(int[] nums) {
        if(nums.length<=1){
            return nums;
        }
        temp = new int[nums.length];
        mergeSort(nums,0,nums.length-1);
        return nums;
    }

    public void mergeSort(int[] nums, int l, int r){
        if(l == r) return;
        int mid = (l+r)/2;
        mergeSort(nums, l, mid);
        mergeSort(nums,mid+1, r);
        merge(nums,l, mid,r);
    }

    public void merge(int[] nums, int l, int mid, int r){
        for(int k = l; k<=r;k++){
            temp[k] = nums[k];
        }
        int i = l, j = mid+1, count = l;
        while(i<=mid && j<=r){
            if(temp[i]<temp[j]){
                nums[count++] = temp[i++];
            }else{
                nums[count++] = temp[j++];
            }
        }

        while(i<=mid){
            nums[count++] = temp[i++];
        }
        while(j<=r){
            nums[count++] = temp[j++];
        }
    }

}
