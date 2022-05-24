package tree.offer.dfs;

import tree.common.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: zhangjin
 * @Date: 2022/02/12/10:52 上午
 * @Description:
 */
public class PreOrderTraversal {
    public List<Integer> preOrderTraversal(TreeNode root) {
        List<Integer> nodes = new LinkedList<>();
        dfs(root, nodes);
        return nodes;
    }

    private void dfs(TreeNode root, List<Integer> nodes) {
        if (root != null) {
            nodes.add(root.val);
            dfs(root.left, nodes);
            dfs(root.right, nodes);
        }
    }

    public List<Integer> preOrderTraversalStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curNode = root;
        stack.push(curNode);
        List<Integer> result = new LinkedList<>();
        while (curNode != null || !stack.isEmpty()) {
            while (curNode != null) {
                result.add(curNode.val);
                stack.push(curNode);
                curNode = curNode.left;
            }
            curNode = stack.pop();
            curNode = curNode.right;
        }
        return result;
    }
}
