package search.binary;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: zhangjin
 * @Date: 2021/10/27/10:58 上午
 * @Description:
 */
public class OtherBinarySearch {
    /**
     * 6.2　寻找旋转排序数组中的最小值
     */
    public int finMin(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (low == high) {
                return arr[low];
            } else if (arr[mid] > arr[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return -1;
    }

    /**
     * 6.3　爱吃香蕉的珂珂
     * 珂珂喜欢吃香蕉。这里有n堆香蕉，第i堆中有piles[i]根香蕉。警卫已经离开了，将在h小时后回来。
     * 珂珂可以决定她吃香蕉的速度k（单位：根/小时）。
     * 每个小时，她将会选择一堆香蕉，从中吃掉k根。如果这堆香蕉少于k根，她将吃掉这堆里的所有香蕉，然后这一小时内不会再吃更多的香蕉。
     * 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
     * 返回她可以在h小时内吃掉所有香蕉的最小速度k（k为整数）。
     * 示例 1：
     * <p>
     * 输入: piles = [3,6,7,11], H = 8
     * 输出: 4
     * 示例 2：
     * <p>
     * 输入: piles = [30,11,23,4,20], H = 5
     * 输出: 30
     * 示例 3：
     * <p>
     * 输入: piles = [30,11,23,4,20], H = 6
     * 输出: 23
     */
    public int minEatingSpeed(List<Integer> piles, int hour) {
        int start = 1;
        int end;
        end = piles.stream().max(Comparator.comparingInt(a -> a)).get();
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (start == end) {
                return start;
            }
            if (help(mid, piles, hour)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return -1;

    }


    private boolean help(int k, List<Integer> piples, int hour) {
        int count = 0;
        for (int piple : piples) {
            count += (piple - 1) / k + 1;
        }
        return count <= hour;
    }

    public int minEatingSpeed2(int[] piles, int H) {
        int left = 1;
        int right = piles[0];
        for (int pile : piles) {
            right = Math.max(right, pile);
        }
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int hours = getHour(mid, piles);
            if (hours <= H) {
                if (mid == 1 || getHour(mid - 1, piles) > H) {
                    return mid;
                } else {
                    right = mid - 1;
                }

            } else {
                //速度太慢
                left = mid + 1;
            }

        }
        return -1;
    }

    public int getHour(int speed, int[] piles) {
        int hours = 0;
        for (int pile : piles) {
            hours += (pile + speed - 1) / speed;
        }
        return hours;
    }

    @Test
    public void test() {
        ArrayList<Integer> sample1 = Lists.newArrayList(3, 6, 7, 11);
        int i = minEatingSpeed(sample1, 8);
        Assert.assertEquals(4, i);
    }

    @Test
    public void test2() {
        ArrayList<Integer> sample1 = Lists.newArrayList(30, 11, 23, 4, 20);
        int i = minEatingSpeed(sample1, 5);
        Assert.assertEquals(30, i);
    }

    @Test
    public void test3() {
        ArrayList<Integer> sample1 = Lists.newArrayList(30, 11, 23, 4, 20);
        int i = minEatingSpeed(sample1, 6);
        Assert.assertEquals(23, i);
    }

    @Test
    public void testMethod2() {
        int[] arr1 = {3, 6, 7, 11};
        Assert.assertEquals(4, minEatingSpeed2(arr1, 8));
    }


}
