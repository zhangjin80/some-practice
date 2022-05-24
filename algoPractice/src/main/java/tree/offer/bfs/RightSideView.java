package tree.offer.bfs;

import tree.common.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: zhangjin
 * @Date: 2022/02/12/9:45 上午
 * @Description: 46.“二叉树的右侧视图”
 */
public class RightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        if (root != null) {
            q1.offer(root);
        }
        List<Integer> result = new LinkedList<>();

        while (!q1.isEmpty()) {
            TreeNode node = q1.poll();
            if (node.left != null) {
                q2.offer(node.left);
            }
            if (node.right != null) {
                q2.offer(node.right);
            }
            if (q1.isEmpty()) {
                result.add(node.val);
                q1 = q2;
                q2 = new LinkedList<>();
            }

        }
        return result;
    }
}
