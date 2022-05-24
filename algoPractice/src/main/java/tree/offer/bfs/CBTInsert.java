package tree.offer.bfs;

import tree.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: zhangjin
 * @Date: 2022/01/13/1:25 下午
 * @Description: 剑指 Offer II 043.
 * 往完全二叉树添加节点
 * 实现思路：
 *  1. 使用队列存储可以插入的节点，把左右节点都不为空的节点出队。
 *  2. 插入节点。获取队头元素，左右节点哪个不为空就插入哪个节点，最后要把满的节点出队，把的子节点插入队列。
 */
public class CBTInsert {
    private Queue<TreeNode> queue = new LinkedList<>();
    private TreeNode root;

    public CBTInsert(TreeNode root) {
        this.root = root;
        queue.offer(root);
        while (queue.peek().left != null && queue.peek().right != null) {
            TreeNode node = queue.poll();
            queue.offer(node.left);
            queue.offer(node.right);
        }
    }

    public int insert(int v) {
        TreeNode parent = queue.peek();
        if (parent.left != null) {
            parent.left = new TreeNode(v);
        } else {
            parent.right = new TreeNode(v);
            queue.poll();
            queue.offer(parent.left);
            queue.offer(parent.right);
        }
        return parent.val;
    }

    public int getRoot() {
        return root.val;
    }


}
