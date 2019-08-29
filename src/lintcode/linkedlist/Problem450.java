package lintcode.linkedlist;

import lintcode.common.ListNode;

public class Problem450 {
    /**
     * @param head: a ListNode
     * @param k:    An integer
     * @return: a ListNode
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        head = dummy;

        while (true) {
            head = reverseK(head, k);
            if (head == null) {
                break;
            }
        }
        return dummy.next;
    }

    public ListNode reverseK(ListNode head, int k) {

        // check the length of the list
        ListNode tailK = head.next;
        for (int i = 0; i < k; i++) {
            if (tailK == null) {
                return null;
            }
            tailK = tailK.next;
        }

        //reverse
        ListNode pre = head;
        ListNode curK = head.next;

        for (int i = 0; i < k; i++) {
            ListNode tmp = curK.next;
            curK.next = pre;
            pre = curK;
            curK = tmp;
        }

        //connect
        ListNode tmp = head.next;
        head.next.next = curK;
        head.next = pre;

        return tmp;
    }

    public static void main(String[] args) {

        Problem450 p = new Problem450();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        p.reverseKGroup(l1, 2);
    }
}
