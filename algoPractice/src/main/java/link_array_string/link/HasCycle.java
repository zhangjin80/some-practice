package link_array_string.link;

/**
 * @Author: zhangjin
 * @Date: 2021/09/25/10:20 上午
 * @Description:
 */
public class HasCycle {
    class ListNode {
        Integer value;
        ListNode next;

        public ListNode(Integer value) {
            this.value = value;
        }
    }

    public boolean checkLinkedCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    /**
     * 方法二
     */

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {
            if (fast.next == null || fast.next.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
