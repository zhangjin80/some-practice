package bitree;

import bitree.util.TreeUtil;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zhangjin
 * @Date: 2021/09/25/9:46 上午
 * @Description: 求根结点到所有叶子节点的和
 */
public class SumFromRootToLeaf {
    public int getSumFromRootToLeaf(TreeNode root) {
        if (root == null) {
            return 0;
        }
        ArrayList<Integer> results = new ArrayList<>();
        help(root, 0, results);
        int sums = 0;
        for (Integer sum : results) {
            sums += sum;
        }
        return sums;
    }

    public void help(TreeNode root, Integer preSum, List<Integer> results) {
        if (root == null) {
            return;
        }

        preSum = preSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            results.add(preSum);
            return;
        }

        help(root.left, preSum, results);
        help(root.right, preSum, results);
    }


    /**
     * 方法二：
     */
    public int dfs(TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode root, int preSum) {
        if (root == null) {
            return 0;
        }
        int sum = preSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        } else {
            return dfs(root.left, sum) + dfs(root.right, sum);
        }
    }


    @Test
    public void test() {
        Integer[] arr1 = {4, 9, 0, 5, 1};
        TreeNode binaryTreeByArray = TreeUtil.createBinaryTreeByArray(arr1);
        int sumFromRootToLeaf = dfs(binaryTreeByArray);
        Assert.assertEquals(sumFromRootToLeaf, 1026);
    }
}
