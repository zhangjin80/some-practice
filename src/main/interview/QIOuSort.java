import java.util.Arrays;

public class QIOuSort {
    public static void sort(int[] arr) {
        int i = 0;
        int j = arr.length-1;
        while (i < j) {
            if (arr[i] % 2 == 0) {
                if (arr[j] % 2 != 0) {
                    int tmp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = tmp;
                    j--;
                    i++;
                } else {
                    j--;
                }
            }else {
                i++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 5, 6, 3, 7};
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));

    }
}
