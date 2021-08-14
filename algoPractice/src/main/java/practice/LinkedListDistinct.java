package practice;

/**
 * @author zhangjin
 * @date 2021/8/14 10:52 上午
 */

public class LinkedListDistinct {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode distinctLinked(ListNode head) {
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            }else {
                cur = cur.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(1);
        listNode.next.next = new ListNode(1);
        listNode.next.next.next = new ListNode(2);
        printNode(listNode);
        distinctLinked(listNode);
        System.out.println("----------");
        printNode(listNode);
    }

    public static void printNode(ListNode root) {
        ListNode listNode = root;

        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
