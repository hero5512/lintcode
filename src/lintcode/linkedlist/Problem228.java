package lintcode.linkedlist;

import lintcode.common.ListNode;

public class Problem228 {
    public ListNode middleNode(ListNode head) {
        // write your code here
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            cur = cur.next;
        }
        return cur;
    }
}
