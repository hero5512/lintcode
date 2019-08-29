package lintcode.linkedlist;

import lintcode.common.ListNode;

public class Problem451 {

    /**
     * @param head: a ListNode
     * @return: a ListNode
     */
    public ListNode swapPairs(ListNode head) {
        // write your code here

        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        head = dummy;
        while (true) {
            head = swapPairsCore(head);
            if (head == null) {
                break;
            }
        }
        return dummy.next;
    }

    private ListNode swapPairsCore(ListNode head) {

        if (head.next == null || head.next.next == null) {
            return null;
        }


        ListNode pre = head;
        ListNode cur = head.next;

        for (int i = 0; i < 2; i++) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }

        ListNode node = head.next;
        head.next.next = cur;
        head.next = pre;

        return node;
    }

    public static void main(String[] args) {

        Problem451 p = new Problem451();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        p.swapPairs(l1);
    }
}
