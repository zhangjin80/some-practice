package interview;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * @Author: zhangjin
 * @Date: 2021/09/24/10:12 上午
 * @Description:
 */
public class InterView {
    class ListNode {
        Integer value;
        ListNode next;

        public ListNode(Integer value) {
            this.value = value;
        }
    }

    public boolean checkLinkedCircl(ListNode head) {
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

    @Test
    public void test() {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        a.next = b;
        b.next = c;
        c.next = a;
        System.out.println(checkLinkedCircl(a));

        ListNode a1 = new ListNode(1);
        System.out.println(checkLinkedCircl(a1));

        System.out.println(checkLinkedCircl(null));

        ListNode a2 = new ListNode(1);
        ListNode b2 = new ListNode(2);
        a2.next = b2;
        System.out.println(checkLinkedCircl(a2));

        Assert.assertFalse(checkLinkedCircl(a2));

    }


    class GriphNode {
        List<GriphNode> nextNodes;
        Integer value;

        public GriphNode(Integer value) {
            this.value = value;
        }
    }


    /**
     * 2*3
     */

    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int getStepSize(int[][] data) {
        int zeroRow = 0;
        int zeroCol = 0;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                if (data[i][j] == 0) {
                    zeroRow = i;
                    zeroCol = j;
                }
            }
        }

        Point zeroPoin = new Point(zeroRow, zeroCol);

        Queue<Point> queue = new LinkedList<>();
        if (zeroRow - 1 >= 0) {
            queue.offer(new Point(zeroRow - 1, zeroCol));
        }
        if (zeroCol - 1 >= 0) {
            queue.offer(new Point(zeroRow, zeroCol - 1));
        }
        if (zeroCol + 1 < data[0].length) {
            queue.offer(new Point(zeroRow, zeroCol + 1));
        }
        if (zeroRow + 1 < data.length) {
            queue.offer(new Point(zeroRow + 1, zeroCol));
        }

        Set<String> exitsSerial = new HashSet<>();

       /* int stepSize = 0;
        while (!queue.isEmpty()) {
            Point current = queue.poll();

            rest(current, zeroPoin);
            if (checkExistsSet()) {
                rest(current, zeroPoin);
            } else {
                stepSize++;
                addExitsSerial(data);
                if (checkIsDone()) {
                    return stepSize;
                }
            }
            queue.offer(getSonPoin(current));
        }*/

        return -1;
    }


}
