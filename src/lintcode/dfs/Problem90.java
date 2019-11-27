package lintcode.dfs;

import java.util.ArrayList;
import java.util.List;

public class Problem90 {
    /*
     * @param A: an integer array
     * @param k: a postive integer <= length(A)
     * @param target: an integer
     * @return: A list of lists of integer
     */

    List<List<Integer>> result;

    public List<List<Integer>> kSumII(int[] A, int k, int target) {
        // write your code here
        result = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        dfs(A, k, target, tmp, A.length - 1);
        return result;
    }

    private void dfs(int[] A, int k, int target, List<Integer> tmp, int index) {
        if (k == 0 && target == 0) {
            result.add(new ArrayList<>(tmp));
            return;
        }
        if (k < 0 || target < 0 || index < 0) {
            return;
        }

        dfs(A, k, target, tmp, index - 1);
        tmp.add(A[index]);
        dfs(A, k - 1, target - A[index], tmp, index - 1);
        tmp.remove(tmp.size() - 1);
    }

    public static void main(String[] args) {
        Problem90 p = new Problem90();
        int[] A = {1, 2, 3, 4};
        p.kSumII(A, 2, 5);
    }
}
