package search.binary;

public class BinarySearch {
    public static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] > target) {
                high = mid - 1;
            }
            if (arr[mid] < target) {
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * ●　查找第一个满足条件的元素，例如查找第一个大于或等于x的元素。
     * @param arr
     * @param target
     * @return
     */

    public static int firstBiggerValue(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (start == end) {
                break;
            }
            if (arr[mid] >= target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return arr[start];


    }

    /**
     * ●　查找最后一个满足条件的元素，例如查找最后一个小于或等于x的元素。
     *
     * @param arr
     * @param target
     * @return
     */
    public static int lastLowValue(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (start == end || start + 1 == end) {
                break;
            }
            if (arr[mid] <= target) {
                start = mid;
            } else {
                end = mid - 1;
            }
        }
        if (arr[end] <= target) {
            return arr[end];
        } else {
            return arr[start];
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 7, 12, 19, 22, 25, 29, 33};
        System.out.println(lastLowValue(arr, 22));
    }
}