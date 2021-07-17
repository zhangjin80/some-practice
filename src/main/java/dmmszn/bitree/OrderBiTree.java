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
    public static void posOrderNoRecur(TreeNode head) {
        if (head == null) {
            return;
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
            System.out.println(cur.val);
        }
    }

    /**
     * 非递归中序遍历
     *
     * @param head
     */
    public static void inOrderNoRecur(TreeNode head) {
        if (head == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                head = stack.pop();
                System.out.println(head.val);
                head = head.right;
            }
        }
    }


    /**
     * 非递归前序遍历
     *
     * @param head
     */
    public static void preOrderNoRecur(TreeNode head) {
        if (head == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(head);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            System.out.println(cur.val);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }

    public static List<Integer> preOrder(TreeNode head) {
        ArrayList<Integer> re = new ArrayList<>();
        preOrder(re, head);
        return re;
    }

    private static void preOrder(List<Integer> re, TreeNode head) {
        if (head == null) {
            return;
        }
        re.add(head.val);
        preOrder(re, head.left);
        preOrder(re, head.right);
    }


    public static void main(String[] args) {
        /*TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(2);
        TreeNode rr = new TreeNode(9);
        right.right = rr;
        TreeNode root = new TreeNode(0);
        root.left = left;
        root.right = right;*/
        Integer[] arr = {1, 2, 3, null, 5, null, 7};
        TreeNode node = TreeNode.createBinaryTreeByArray(arr);
        posOrderNoRecur(node);
    }

}
