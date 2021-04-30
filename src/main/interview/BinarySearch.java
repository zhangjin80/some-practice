package main.interview;

public class BinarySearch {

    public static int biSerch(int arr[], int value) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int idx = (start + end) / 2;
            if (arr[idx] == value) {
                return idx;
            } else if (arr[idx] > value) {
                end = idx;
            } else {
                start = idx;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 7, 12, 19, 22, 25, 29, 33};
        System.out.println(biSerch(arr, 29));
    }
}