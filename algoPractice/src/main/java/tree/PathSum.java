package tree;

import tree.common.TreeNode;
import tree.common.TreeUtil;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zhangjin
 * @Date: 2021/10/18/7:39 下午
 * @Description: 向下的路径节点值之和
 * 给定一棵二叉树和一个值sum，求二叉树中节点值之和等于sum的路径的数目。
 * 路径的定义为二叉树中顺着指向子节点的指针向下移动所经过的节点，但不一定从根节点开始，也不一定到叶节点结束。
 * url: https://leetcode-cn.com/problems/6eUYwP/
 */
public class PathSum {
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }

        int ret = rootSum(root, targetSum);
        ret += pathSum(root.left, targetSum);
        ret += pathSum(root.right, targetSum);
        return ret;
    }

    public int rootSum(TreeNode root, int targetSum) {
        int ret = 0;

        if (root == null) {
            return 0;
        }
        int val = root.val;
        if (val == targetSum) {
            ret++;
        }

        ret += rootSum(root.left, targetSum - val);
        ret += rootSum(root.right, targetSum - val);
        return ret;
    }


    /**
     * 方法二
     * @param root
     * @param sum
     * @return
     */
    public int pathSum2(TreeNode root, int sum) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return dfs(root, sum, map, 0);
    }

    private int dfs(TreeNode root, int sum, Map<Integer, Integer> map, int path) {
        if (root == null) {
            return 0;
        }
        path += root.val;
        int count = map.getOrDefault(path - sum, 0);
        map.put(path, map.getOrDefault(path, 0) + 1);
        count += dfs(root.left, sum, map, path);
        count += dfs(root.right, sum, map, path);
        map.put(path, map.get(path) - 1);
        return count;
    }

    @Test
    public void test(){
        Integer[] arr  = {10,5,-3,3,2,null,11,3,-2,null,1};
        TreeNode root = TreeUtil.createBinaryTreeByArray(arr);
        Assert.assertEquals(3, pathSum(root, 8));
    }
}
