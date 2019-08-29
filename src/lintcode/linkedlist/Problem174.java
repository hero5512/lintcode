package lintcode.linkedlist;

import lintcode.common.ListNode;

public class Problem174 {
    /**
     * @param head: The first node of linked list.
     * @param n: An integer
     * @return: The head of linked list.
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // write your code here
        if (head == null || n <= 0) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode tail = dummy;
        for (int i = 0; i < n; i++) {
            tail = tail.next;
            if (tail == null && i < n) {
                return head;
            }
        }
        ListNode pre = dummy;

        //定位
        while (tail.next != null) {
            pre = pre.next;
            tail = tail.next;
        }

        //删除
        pre.next = pre.next.next;
        return dummy.next;
    }
}
