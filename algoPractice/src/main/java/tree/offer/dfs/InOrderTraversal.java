package tree.offer.dfs;

import tree.common.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: zhangjin
 * @Date: 2022/02/12/10:17 上午
 * @Description: 二叉树的中序遍历
 */
public class InOrderTraversal {
    public List<Integer> inOrderTraversal(TreeNode root) {
        List<Integer> nodes = new LinkedList<>();
        dfs(root, nodes);
        return nodes;
    }

    private void dfs(TreeNode root, List<Integer> nodes) {
        if (root != null) {
            dfs(root.left, nodes);
            nodes.add(root.val);
            dfs(root.right, nodes);
        }

    }

    public List<Integer> inOrderTraversalStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curNode = root;
        List<Integer> result = new LinkedList<>();
        while (curNode != null || !stack.isEmpty()) {
            while (curNode != null) {
                stack.push(curNode);
                curNode = curNode.left;
            }
            curNode = stack.pop();
            result.add(curNode.val);
            curNode = curNode.right;
        }
        return result;
    }
}
