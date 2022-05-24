package tree.offer.dfs;

import tree.common.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: zhangjin
 * @Date: 2022/02/12/11:17 上午
 * @Description:
 */
public class PostOrderTraversal {
    public List<Integer> postOrderTraversal(TreeNode root) {
        List<Integer> nodes = new LinkedList<>();
        dfs(root, nodes);
        return nodes;
    }

    private void dfs(TreeNode root, List<Integer> nodes) {
        if (root != null) {
            dfs(root.left, nodes);
            dfs(root.right, nodes);
            nodes.add(root.val);
        }
    }

    public List<Integer> postOrderTraversalStatck(TreeNode root) {
        Stack<TreeNode> statck = new Stack<>();
        List<Integer> result = new LinkedList<>();
        TreeNode curNode = root;
        TreeNode prev = null;
        while (curNode != null || !statck.isEmpty()) {
            while (curNode != null) {
                statck.push(curNode);
                curNode = curNode.left;
            }
            curNode = statck.peek();
            if (curNode.right == null || curNode.right == prev) {
                curNode = statck.pop();
                result.add(curNode.val);
                prev = curNode;
                curNode = null;
            } else {
                curNode = curNode.right;
            }
        }
        return result;
    }
}
