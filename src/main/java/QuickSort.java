import java.util.Arrays;

public class QuickSort {
    public static void quickSort(int[] arr){
        if (arr.length <= 1 || arr == null) {
            return;
        }
        sort(arr, 0, arr.length - 1);
    }

    public static void sort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int i = left;
        int j = right;
        int base = arr[left];
        while (i != j) {
            while (i < j && arr[j] >= base) {
                j--;
            }
            while (i < j && arr[i] <= base) {
                i++;
            }
            if (i != j) {
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }
        arr[i] = base;
        sort(arr, left, i - 1);
        sort(arr,i+1,right);
    }

    public static void main(String[] args) {
        int[] arr = {4,3,2,1};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));

    }
}
