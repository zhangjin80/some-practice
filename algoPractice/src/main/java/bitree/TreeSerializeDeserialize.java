package bitree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: zhangjin
 * @Date: 2021/10/19/5:41 下午
 * @Description:
 */
public class TreeSerializeDeserialize {

    public static TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));

        return dfs(queue);
    }

    private static TreeNode dfs(Queue<String> queue) {
        String val = queue.poll();
        if ("null".equals(val) || val == null) {
            return null;
        }

        TreeNode curNode = new TreeNode(Integer.parseInt(val));
        curNode.left = dfs(queue);
        curNode.right = dfs(queue);
        return curNode;
    }

    public static String serialize(TreeNode root) {
        if (root == null) {
            return "null";
        }
        String leftStr = serialize(root.left);
        String rightStr = serialize(root.right);
        return root.val + "," + leftStr + "," + rightStr;
    }
}
