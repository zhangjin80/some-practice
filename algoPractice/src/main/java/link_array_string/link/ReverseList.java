package link_array_string.link;

/**
 * 反转链表
 */
public class ReverseList {
    static class ListNode{
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static ListNode recurReverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = recurReverseList(head.next);
        head.next.next = head;
        head.next = null;//不设为null就会产生循环指向
        return newHead;
    }

    public static void main(String[] args) {
        //测试用例1
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        a.next = b;
        b.next = c;
        ListNode head = a;
        while (head != null) {
            System.out.print(head.val+"->");
            head = head.next;
        }
        System.out.println();
        head = recurReverseList(a);
        while (head != null) {
            System.out.print(head.val+"->");
            head = head.next;
        }

        System.out.println("\n----------------------");
        ListNode oneNode = new ListNode(0);
        head = oneNode;
        while (head != null) {
            System.out.print(head.val+"->");
            head = head.next;
        }
        System.out.println();
        head = recurReverseList(oneNode);
        while (head != null) {
            System.out.print(head.val+"->");
            head = head.next;
        }
    }

}
