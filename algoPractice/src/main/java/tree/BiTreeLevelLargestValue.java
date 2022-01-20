package tree;

import tree.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: zhangjin
 * @Date: 2021/09/20/8:37 下午
 * @Description: 剑指 Offer II 044. 二叉树每层的最大值
 */
public class BiTreeLevelLargestValue {
    public List<Integer> largestValues(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int curLevelSize = queue.size();
            int maxValue = Integer.MIN_VALUE;
            for (int i = 0; i < curLevelSize; i++) {
                TreeNode currentNode = queue.poll();
                maxValue = Math.max(maxValue, currentNode.val);
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            result.add(maxValue);
        }
        return result;
    }

    /**
     * 方法二：
     * @param root
     * @return
     */
    public List<Integer> largestValues2(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        int curLevelSize = 0;
        int nextLevelSize = 0;
        if (root != null) {
            queue.offer(root);
            curLevelSize++;
        }
        int maxValue = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();
            maxValue = Math.max(maxValue, currentNode.val);
            curLevelSize--;
            if (currentNode.left != null) {
                queue.offer(currentNode.left);
                nextLevelSize++;
            }
            if (currentNode.right != null) {
                queue.offer(currentNode.right);
                nextLevelSize++;
            }
            if (curLevelSize == 0) {
                result.add(maxValue);
                maxValue = Integer.MIN_VALUE;
                curLevelSize = nextLevelSize;
                nextLevelSize = 0;
            }
        }
        return result;
    }
}
