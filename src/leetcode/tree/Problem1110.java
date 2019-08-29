package leetcode.tree;


import leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem1110 {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {

        List<TreeNode> res = new ArrayList<>();
        Set<Integer> delete = new HashSet<>();

        for (int i :
                to_delete) {
            delete.add(i);
        }

        if (!helper(root, delete, res, false)) {
            res.add(root);
        }
        return res;
    }

    private boolean helper(TreeNode root, Set<Integer> delete, List<TreeNode> res, boolean add) {
        if (root == null) {
            return false;
        }
        if (delete.contains(root.val)) {
            helper(root.left, delete, res, true);
            helper(root.right, delete, res, true);
            return true;
        }

        if (add) {
            res.add(root);
        }

        if(helper(root.left, delete, res, false)) {
            root.left = null;
        }
        if(helper(root.right, delete, res, false)) {
            root.right = null;
        }
        return false;
    }
}
