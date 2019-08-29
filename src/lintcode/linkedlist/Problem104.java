package lintcode.linkedlist;

import lintcode.common.ListNode;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Problem104 {
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {
        // write your code here
        if (lists == null || lists.size() == 0) {
            return null;
        }

        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;

        Queue<ListNode> minStack = new PriorityQueue<>(lists.size(), Comparator.comparingInt(o -> o.val));

        for (int i = 0; i < lists.size(); i++) {
            ListNode headI = lists.get(i);
            if (headI != null) {
                minStack.add(headI);
            }
        }

        while (!minStack.isEmpty()) {
            ListNode curMinNode = minStack.poll();
            cur.next = curMinNode;
            cur = cur.next;
            if (curMinNode.next != null) {
                minStack.add(curMinNode.next);
            }
        }

        return dummy.next;
    }
}
