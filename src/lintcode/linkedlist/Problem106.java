package lintcode.linkedlist;

import lintcode.common.ListNode;
import lintcode.common.TreeNode;

public class Problem106 {
    /*
     * @param head: The first node of linked list.
     * @return: a tree node
     */

    ListNode current;

    public TreeNode sortedListToBST(ListNode head) {
        // write your code here

        current = head;
        int size = getListLength(head);
        return sortedListToBSTCore(0, size - 1);
    }

    private int getListLength(ListNode head) {
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }
        return size;
    }

    private TreeNode sortedListToBSTCore(int L, int R) {
        if (L > R) {
            return null;
        }
        if (L == R) {
            TreeNode cur = new TreeNode(current.val);
            current = current.next;
            return cur;
        }

        int mid = (L + R) / 2;
        TreeNode left = sortedListToBSTCore(L, mid - 1);
        TreeNode cur = new TreeNode(current.val);
        cur.left = left;
        current = current.next;

        TreeNode right = sortedListToBSTCore(mid + 1, R);
        cur.right = right;
        return cur;
    }
}
