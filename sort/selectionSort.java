package sort;

public class selectionSort {
    public void sortIntegers(int[] a) {
        // write your code here
        int l = a.length;
        if(l == 1 || l ==0) return;
        for(int i = 0; i<l-1;i++){
            int j = i;
            int index = i;
            int min = a[i];
            while(j<l){
                if(a[j]<=min){
                    min = a[j];
                    index = j;
                }
                j++;
            }

            int temp = a[i];
            a[i] = min;
            a[index] = temp;
        }
    }
}
