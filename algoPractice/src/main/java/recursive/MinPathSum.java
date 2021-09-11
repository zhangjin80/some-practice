package recursive;

/**
 * @Author: zhangjin
 * @Date: 2021/09/04/10:37 上午
 * @Modify: 2021/09/04/10:37 上午
 * @Description: 求矩阵最小路径和：
 * goto https://leetcode-cn.com/problems/minimum-path-sum/submissions/
 */
public class MinPathSum {
    public int getMinPathSum(int[][] arr) {
        if (arr == null || arr.length == 0 || arr[0] == null || arr[0].length == 0) {
            return 0;
        }
        int row = arr.length;
        int col = arr[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = arr[0][0];

        for (int i = 1; i < col; i++) {
            dp[0][i] = arr[0][i] + dp[0][i - 1];
        }
        for (int j = 1; j < row; j++) {
            dp[j][0] = arr[j][0] + dp[j - 1][0];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + arr[i][j];
            }
        }
        return dp[row - 1][col - 1];
    }

    public int getMinPathSum2(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        int less = Math.min(grid.length, grid[0].length);
        int more = Math.max(grid.length, grid[0].length);
        boolean rowMore = grid.length > grid[0].length;//先考虑行多列少的情况。
        int[] arr = new int[less];
        arr[0] = grid[0][0];
        for (int i = 1; i < less; i++) {
            arr[i] = arr[i - 1] + (rowMore ? grid[0][i] : grid[i][0]);
        }
        for (int i = 1; i < more; i++) {
            arr[0] = arr[0] + (rowMore ? grid[i][0] : grid[0][i]);
            for (int j = 1; j < less; j++) {
                arr[j] = (rowMore ? grid[i][j] : grid[j][i]) + Math.min(arr[j], arr[j - 1]);
            }
        }
        return arr[less - 1];
    }
}
