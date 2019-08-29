package lintcode.tree;

import lintcode.common.TreeNode;

public class Problem97 {
    /**
     * @param root: The root of binary tree.
     * @return: An integer
     */
    public int maxDepth(TreeNode root) {
        // write your code here

        if (root == null) {
            return 0;
        }


        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.max(left, right) + 1;
    }
}
