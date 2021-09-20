package basic;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

/**
 * CD2 最长的可整合子数组的长度
 *
 * @author zhangjin
 * @date 2021-09-17 18:05
 */
public class MaxConcordanceLength {
    public static int getMaxLength(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int[] newArr = Arrays.copyOfRange(arr, 0, arr.length);
        Arrays.sort(newArr);
        return help(newArr, newArr.length - 1);
    }

    private static int help(int[] arr, int i) {
        if (i == 0) {
            return 1;
        }
        if (arr[i] - arr[i - 1] == 1) {
            return 1 + help(arr, i - 1);
        } else {
            return help(arr, i - 1);
        }

    }

    public static int getMaxLength2(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int maxLen = Integer.MIN_VALUE;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;

            for (int j = i; j < arr.length; j++) {
                if (set.contains(arr[j])) {
                    break;
                }
                set.add(arr[j]);
                min = Math.min(arr[j], min);
                max = Math.max(arr[j], max);
                if (max - min == j - i) {
                    maxLen = Math.max(maxLen, j - i + 1);

                }
            }
            set.clear();

        }
        return maxLen;
    }

    @Test
    public void test() {
        int[] arr = {5, 5, 3, 2, 6, 4, 3};
        Assert.assertEquals(5, getMaxLength(arr));

        int[] arr2 = {5, 3, 4, 6, 2};
        Assert.assertEquals(5, getMaxLength(arr2));
    }

    @Test
    public void test2() {
        int[] arr = {5, 5, 3, 2, 6, 4, 3, 7};
        Assert.assertEquals(5, getMaxLength2(arr));

        int[] arr2 = {5, 3, 4, 6, 2};
        Assert.assertEquals(5, getMaxLength2(arr2));
    }

}
