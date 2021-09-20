package dp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangjin
 * @date 2021-09-12 10:46
 * 求最长公共子序列：
 * goto https://leetcode-cn.com/problems/longest-common-subsequence/
 */
public class LongestCommonSubsequence {

    public void longestCommonSubsequenceOutput(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        int[][] subSqDp = new int[text1.length() + 1][text2.length() + 1];
        longestCommonSubsequence(text1, text2, dp, subSqDp);
        System.out.println(dp[dp.length - 1][dp[0].length - 1]);
        List<Character> subSqresult = new ArrayList<>();
        getSubSq(subSqDp, text1, subSqresult);
        System.out.println(subSqresult.toString());
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        int[][] subSqDp = new int[text1.length() + 1][text2.length() + 1];
        longestCommonSubsequence(text1, text2, dp, subSqDp);
        return dp[dp.length - 1][dp[0].length - 1];
    }

    private void longestCommonSubsequence(String text1, String text2, int[][] dp, int[][] subSqDp) {
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    subSqDp[i][j] = 1;
                } else if (dp[i][j - 1] >= dp[i - 1][j]) {
                    dp[i][j] = dp[i][j - 1];
                    subSqDp[i][j] = 2;
                } else {
                    dp[i][j] = dp[i - 1][j];
                    subSqDp[i][j] = 3;
                }
            }
        }
    }

    private List<Character> getSubSq(int[][] subSqDp, String text1, List<Character> subSqresult) {
        getSubSq(subSqDp, text1, subSqDp.length - 1, subSqDp[0].length - 1, subSqresult);
        return subSqresult;
    }

    private void getSubSq(int[][] subSqDp, String text1, int i, int j, List<Character> subSqresult) {
        if (i == j && i == 0) {
            return;
        }
        if (subSqDp[i][j] == 1) {
            getSubSq(subSqDp, text1, i - 1, j - 1, subSqresult);
            subSqresult.add(text1.charAt(i - 1));
        } else if (subSqDp[i][j] == 2) {
            getSubSq(subSqDp, text1, i, j - 1, subSqresult);
        } else {
            getSubSq(subSqDp, text1, i - 1, j, subSqresult);
        }
    }

    public static void main(String[] args) {
        final LongestCommonSubsequence longestCommonSubsequence = new LongestCommonSubsequence();
        longestCommonSubsequence.longestCommonSubsequenceOutput("abcde", "ace");
        longestCommonSubsequence.longestCommonSubsequenceOutput("abc", "abc");
        longestCommonSubsequence.longestCommonSubsequenceOutput("abc", "def");
    }

}
