package tree;

import tree.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: zhangjin
 * @Date: 2021/09/20/7:52 下午
 * @Description:
 * 剑指 Offer II 043. 往完全二叉树添加节点
 */
public class CBTInserter {
    private Queue<TreeNode> notFullNodeQueue;
    private TreeNode root;

    public CBTInserter(TreeNode root) {
        this.root = root;
        notFullNodeQueue = new LinkedList<>();
        notFullNodeQueue.offer(root);
        while (notFullNodeQueue.peek().left != null && notFullNodeQueue.peek().right != null) {
            TreeNode node = notFullNodeQueue.poll();
            notFullNodeQueue.offer(node.left);
            notFullNodeQueue.offer(node.right);
        }
    }

    public int insert(int value) {
        TreeNode newNode = new TreeNode(value);
        TreeNode parent = this.notFullNodeQueue.peek();
        if (parent.left == null) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
            this.notFullNodeQueue.poll();
            this.notFullNodeQueue.offer(parent.left);
            this.notFullNodeQueue.offer(parent.right);
        }
        return parent.val;
    }

    public TreeNode get_root() {
        return this.root;
    }


}
