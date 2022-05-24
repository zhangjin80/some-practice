package tree.offer.bfs;

import tree.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: zhangjin
 * @Date: 2022/02/12/9:31 上午
 * @Description: 45.寻找二叉树最底层最左边的节点
 */
public class FindBottomLeftValue {
    public Integer findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        Integer leftValue = null;
        if (root != null) {
            q1.offer(root);
            leftValue = root.val;
        }
        while (!q1.isEmpty()) {
            TreeNode node = q1.poll();
            if (node.left != null) {
                q2.offer(node.left);
            }
            if (node.right != null) {
                q2.offer(node.right);
            }
            if (q1.isEmpty()) {
                q1 = q2;
                q2 = new LinkedList<>();
                if (!q1.isEmpty()) {
                    TreeNode leftNode = q1.peek();
                    leftValue = leftNode.val;
                }
            }
        }
        return leftValue;
    }
}
