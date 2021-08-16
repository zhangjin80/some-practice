package recursive;

/**
 * 53. 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * goto https://leetcode-cn.com/problems/maximum-subarray/
 *
 * @author zhangjin
 * @date 2021-08-15 18:08
 * [-1,-1]
 */
public class MaxSubArray {
    static int maxSum = Integer.MIN_VALUE;

    public static int maxSubArray(int[] nums) {
        helper(nums, nums.length - 1);
        return maxSum;
    }

    private static int helper(int[] nums, int i) {
        if (i == 0) {
            maxSum = Math.max(nums[i], maxSum);
            return nums[i];
        }
        int preMaxSum = Math.max(0, helper(nums, i - 1));
        final int curSum = preMaxSum + nums[i];
        maxSum = Math.max(curSum, maxSum);
        return curSum;
    }

    public static void main(String[] args) {
        int[] nums = {-1,-1,1,1,-2,3,3,4,-4};
        System.out.println(maxSubArray(nums));
    }

}
