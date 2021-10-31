package search.binary;

import org.junit.Assert;
import org.junit.Test;

/**
 * @Author: zhangjin
 * @Date: 2021/10/31/4:55 下午
 * @Description: 峰值元素是指其值严格大于左右相邻值的元素。
 * <p>
 * 给你一个整数数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums =
 * [1,2,3,1]
 * <p>
 * 输出：2
 * 解释：3 是峰值元素，你的函数应该返回其索引 2。
 * 示例 2：
 * <p>
 * 输入：nums =
 * [
 * 1,2,1,3,5,6,4]
 * 输出：1 或 5
 */
public class FindPeekElement {
    public int findPeekElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid + 1 < nums.length && nums[mid + 1] > nums[mid]) {
                left = mid + 1;
            } else if (mid - 1 >= 0 && nums[mid - 1] > nums[mid]) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    @Test
    public void test(){
        int[] nums = {1,2,1,3,5,6,4};
        int peekElement = findPeekElement(nums);
        Assert.assertEquals(5, peekElement);
    }
}
