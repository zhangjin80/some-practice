package recursive;

/**
 * @Author: zhangjin
 * @Date: 2021/09/05/8:41 下午
 * @Description: 零钱兑换。给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。、
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回-1 。
 * goto https://leetcode-cn.com/problems/coin-change/
 */
public class CoinChange {
    /**
     * 递归暴力求解
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount < 0) {
            return -1;
        }
        return process(coins, 0, amount);
    }

    private int process(int[] coins, int i, int rest) {
        if (i == coins.length) {
            return rest == 0 ? 0 : -1;
        }
        int result = -1;
        for (int k = 1; k * coins[i] <= rest; k++) {
            int next = process(coins, i + 1, rest - k * coins[i]);
            if (next != -1) {
                result = result == -1 ? next + k : Math.min(result, next + k);
            }
        }
        return result;
    }
}
