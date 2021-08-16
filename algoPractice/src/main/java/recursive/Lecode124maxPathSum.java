package recursive;

import bitree.TreeNode;

/**
 * 二叉树中的最大路径和
 * @author zhangjin
 * @date 2021-08-10 18:01
 * goto https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/
 */
public class Lecode124maxPathSum {
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxSumHelper(root);
        return maxSum;

    }

    private int maxSumHelper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMaxSum = Math.max(maxSumHelper(root.left), 0);
        int rightMaxSum = Math.max(maxSumHelper(root.right), 0);
        maxSum = Math.max(root.val + leftMaxSum + rightMaxSum, maxSum);
        return root.val + Math.max(leftMaxSum, rightMaxSum);
    }
}
