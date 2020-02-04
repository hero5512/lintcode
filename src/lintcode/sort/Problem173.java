package lintcode.sort;

import lintcode.common.ListNode;

public class Problem173 {
    /**
     * @param head: The first node of linked list.
     * @return: The head of linked list.
     */
    public ListNode insertionSortList(ListNode head) {
        // write your code here
        ListNode dumy = new ListNode(0);
        while (head != null) {
            ListNode node = dumy;
            while (node.next != null && node.next.val < head.val) {
                node = node.next;
            }
            ListNode tmp = head.next;
            head.next = node.next;
            node.next = head;
            head = tmp;
        }
        return dumy.next;
    }
}
