package lintcode.linkedlist;

import lintcode.common.ListNode;

public class Problem96 {
    /**
     * @param head: The first node of linked list
     * @param x:    An integer
     * @return: A ListNode
     */
    public ListNode partition(ListNode head, int x) {
        // write your code here
        if (head == null) {
            return head;
        }
        ListNode leftDummy = new ListNode(0);
        ListNode rightDummy = new ListNode(0);
        ListNode left = leftDummy, right = rightDummy;

        while (head != null) {
            if (head.val < x) {
                left.next = head;
                left = left.next;
            } else {
                right.next = head;
                right = right.next;
            }
            head = head.next;
        }
        right.next = null;
        left.next = rightDummy.next;
        return leftDummy.next;
    }
}
