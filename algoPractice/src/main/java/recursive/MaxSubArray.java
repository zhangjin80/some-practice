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


    /**
     * 动态规划求法
     * @param num
     * @return
     */
    public static int getMaxSubArraySum(int[] num) {
        int maxSub = num[0];
        int preSum = num[0];
        for (int i = 1; i < num.length; i++) {
            preSum = Math.max(preSum + num[i], num[i]);
            maxSub = Math.max(maxSub, preSum);
        }
        return maxSub;
    }

    /**
     * 递归求法
     * @param nums
     * @return
     */
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
        int[] arr = {-1,-1,2};
        System.out.println(getMaxSubArraySum(arr));
    }

}
