package bitree;

import java.util.*;

public class OrderBiTree {
    /**
     * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
     * 示例：
     * 二叉树：[3,9,20,null,null,15,7],
     * <p>
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * 返回其层序遍历结果：
     * <p>
     * [
     * [3],
     * [9,20],
     * [15,7]
     * ]
     */
    public List<List<Integer>> levelOrder2(TreeNode head) {
        List<List<Integer>> re = new ArrayList<>();

        if (head == null) {
            return re;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(head);
        while (!queue.isEmpty()) {
            ArrayList<Integer> curLevelRes = new ArrayList<>();
            int curLevelSize = queue.size();
            for (int i = 0; i < curLevelSize; i++) {
                TreeNode cur = queue.poll();
                curLevelRes.add(cur.val);
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            re.add(curLevelRes);

        }

        return re;
    }

    /**
     * 层序遍历
     */
    public List<Integer> levelOrder(TreeNode head) {
        List<Integer> re = new ArrayList<>();

        if (head == null) {
            return re;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(head);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            re.add(cur.val);
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
        return re;

    }

    /**
     * 非递归后序遍历
     *
     * @param head
     */
    public List<Integer> posOrderUnRecur(TreeNode head) {
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
     * 非递归后序遍历
     * @param root
     * @return
     */
    public List<Integer> posOrderUnRecur2(TreeNode root) {
        ArrayList<Integer> re = new ArrayList<>();
        if (root == null) {
            return re;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode prev = null;
        stack.push(cur);
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.peek();
            if (cur.right == null || cur.right == prev) {
                stack.pop();
                re.add(cur.val);
                prev = cur;
                cur = null;
            }else {
                cur = cur.right;
            }

        }
        return re;
    }


        /**
         * 非递归中序遍历
         *
         * @param head
         */
    public List<Integer> inOrderUnRecur(TreeNode head) {
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
    public List<Integer> preOrderUnRecur(TreeNode head) {
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
