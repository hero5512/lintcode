package lintcode.linkedlist;

import lintcode.common.ListNode;

public class Problem167 {
    /**
     * @param l1: the first list
     * @param l2: the second list
     * @return: the sum list of l1 and l2
     */
    public ListNode addLists(ListNode l1, ListNode l2) {
        // write your code here
        if (l1 == null && l2 == null) {
            return null;
        }
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        int carry = 0;
        while (l1 != null && l2 != null) {
            ListNode tmp = new ListNode((l1.val + l2.val + carry) % 10);
            carry = (l1.val + l2.val + carry) / 10;
            l1 = l1.next;
            l2 = l2.next;
            cur.next = tmp;
            cur = tmp;
        }
        while (l1 != null) {
            ListNode tmp = new ListNode((l1.val + carry) % 10);
            carry = (l1.val + carry) / 10;
            l1 = l1.next;
            cur.next = tmp;
            cur = tmp;
        }

        while (l2 != null) {
            ListNode tmp = new ListNode((l2.val + carry) % 10);
            carry = (l2.val + carry) / 10;
            l2 = l2.next;
            cur.next = tmp;
            cur = tmp;
        }
        if (carry != 0) {
            cur.next = new ListNode(carry);
        }
        return head.next;
    }
}
