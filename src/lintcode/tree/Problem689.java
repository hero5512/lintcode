package lintcode.tree;

import lintcode.common.TreeNode;

public class Problem689 {
    /*
     * @param : the root of tree
     * @param : the target sum
     * @return: two numbers from tree which sum is n
     */

    TreeNode root;
    public int[] twoSum(TreeNode root, int n) {
        // write your code here
        this.root = root;
        return inOrder(root, n);
    }

    private int[] inOrder(TreeNode root, int n) {

        if (root == null) {
            return null;
        }

        int[] left = inOrder(root.left, n);
        if (find(this.root, n - root.val, root)) {
            int[] res = new int[2];
            res[0] = root.val;
            res[1] = n - root.val;
            return res;
        }

        int[] right = inOrder(root.right, n);
        return left != null ? left : right;
    }

    private boolean find(TreeNode root, int val, TreeNode pre) {

        if (root == null) {
            return false;
        }
        if (root.val == val && root != pre) {
            return true;
        }

        if (root.val < val) {
            return find(root.right, val, pre);
        } else {
            return find(root.left, val, pre) ;
        }
    }

    public static void main(String[] args) {
        /**
         * {4,2,5,1,3}
         * 3
         */

        TreeNode root = new TreeNode(4);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(3);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;

        Problem689 p = new Problem689();

        System.out.println(p.twoSum(root, 3));
    }
}
