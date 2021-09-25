package dp;

/**
 * @Author: zhangjin
 * @Date: 2021/09/23/3:12 下午
 * @Description: 爬楼梯的最小花费
 */
public class MinCostClimbingStairs {
    /**
     * 递推，动态规划
     * @param cost
     * @return
     */
    public int minCostClimbingStairs(int[] cost) {
        int length = cost.length;
        int[] dp = new int[length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }
        return Math.min(dp[length - 1], dp[length - 2]);
    }

    /**
     * 递归法
     */
    public int minCostClimbingStairs2(int[] cost) {
        if (cost == null) {
            return -1;
        }
        return Math.min(help(cost, cost.length - 1), help(cost, cost.length - 2));

    }

    public int help(int[] cost, int i) {
        if (i < 2) {
            return cost[i];
        }
        return Math.min(help(cost, i - 1), help(cost, i - 2)) + cost[i];
    }

    /**
     * 递归法,加状态记录
     */
    public int minCostClimbingStairs3(int[] cost) {
        if (cost == null || cost.length == 0) {
            return -1;
        }
        int length = cost.length;
        int[] dp = new int[length];
        dp[0] = cost[0];
        help(cost, length - 1, dp);
        return Math.min(dp[length - 1], dp[length - 2]);

    }

    private void help(int[] cost, int i, int[] dp) {
        if (i < 2) {
            dp[i] = cost[i];
        } else if (dp[i] == 0) {
            help(cost, i - 1, dp);
            help(cost, i - 2, dp);
            dp[i] = Math.min(dp[i - 2], dp[i - 1]) + cost[i];
        }
    }
}
