package basic;

import org.junit.Test;

/**
 * “不重复打印排序数组中相加和为给定值的所有二元组和三元组”
 *
 * @author zhangjin
 * @date 2021-09-17 19:05
 */
public class PrintUniquePair {
    public static void printUniquePair(int[] sortedArr, int target) {
        int left = 0;
        int right = sortedArr.length - 1;
        while (left < right) {
            int sum = sortedArr[left] + sortedArr[right];
            if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            } else {
                if (left == 0 || sortedArr[left] != sortedArr[left - 1]) {
                    System.out.println(sortedArr[left] + ", " + sortedArr[right]);
                }
                left++;
                right--;
            }
        }
    }

    @Test
    public void test() {
        int[] arr = {-8, -4, -3, 0, 1, 2, 4, 5, 8, 9};
        printUniquePair(arr, 10);
    }

    public void printUniqueTriad(int[] arr, int target) {
        if (arr == null || arr.length < 3) {
            return;
        }
        for (int i = 0; i < arr.length - 2; i++) {
            if (i == 0 || arr[i] != arr[i - 1]) {
                help(arr, i, i + 1, arr.length - 1, target - arr[i]);
            }
        }
    }

    private void help(int[] arr, int base, int left, int right, int target) {
        while (left < right) {
            final int sum = arr[left] + arr[right];
            if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            } else {
                if (left == base + 1 || arr[left] != arr[left - 1]) {
                    System.out.println(arr[base] + ", " + arr[left] + ", " + arr[right]);
                }
                left++;
                right--;
            }

        }
    }

    @Test
    public void test2() {
        int[] arr = {-8, -4, -3, 0, 1, 2, 4, 5, 8, 9};
        printUniqueTriad(arr, 10);
    }
}
