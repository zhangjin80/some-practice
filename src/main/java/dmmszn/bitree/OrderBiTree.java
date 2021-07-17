package dmmszn.bitree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class OrderBiTree {
    /**
     * 非递归后序遍历
     *
     * @param head
     */
    public List<Integer> posOrderNoRecur(TreeNode head) {
        ArrayList<Integer> re = new ArrayList<>();
        if (head == null) {
            return re;
        }
        Stack<TreeNode> stackIn = new Stack<>();
        Stack<TreeNode> stackOut = new Stack<>();
        stackIn.push(head);
        while (!stackIn.isEmpty()) {
            TreeNode cur = stackIn.pop();
            stackOut.push(cur);
            if (cur.left != null) {
                stackIn.push(cur.left);
            }
            if (cur.right != null) {
                stackIn.push(cur.right);
            }
        }
        while (!stackOut.isEmpty()) {
            TreeNode cur = stackOut.pop();
            re.add(cur.val);
        }
        return re;
    }

    /**
     * 非递归中序遍历
     *
     * @param head
     */
    public List<Integer> inOrderNoRecur(TreeNode head) {
        ArrayList<Integer> re = new ArrayList<>();

        if (head == null) {
            return re;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                head = stack.pop();
                re.add(head.val);
                head = head.right;
            }
        }
        return re;
    }


    /**
     * 非递归前序遍历
     *
     * @param head
     */
    public List<Integer> preOrderNoRecur(TreeNode head) {
        ArrayList<Integer> re = new ArrayList<>();
        if (head == null) {
            return re;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(head);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            re.add(cur.val);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
        return re;
    }

    public List<Integer> preOrder(TreeNode head) {
        ArrayList<Integer> re = new ArrayList<>();
        preOrder(re, head);
        return re;
    }

    private void preOrder(List<Integer> re, TreeNode head) {
        if (head == null) {
            return;
        }
        re.add(head.val);
        preOrder(re, head.left);
        preOrder(re, head.right);
    }
}
