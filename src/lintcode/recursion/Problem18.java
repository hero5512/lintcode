package lintcode.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem18 {
    /**
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // write your code here
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null) {
            return results;
        }
        Arrays.sort(nums);
        ArrayList<Integer> subset = new ArrayList<>();
        subsetsWithDupCore(nums, 0, subset, results);
        return results;
    }

    public void subsetsWithDupCore(int[] nums, int startIndex, List<Integer> subset, List<List<Integer>> results) {
        results.add(new ArrayList<>(subset));
        for (int i = startIndex; i < nums.length; i++) {
            if (i != startIndex && nums[i] == nums[i - 1]) {
                continue;
            }
            subset.add(nums[i]);
            subsetsWithDupCore(nums, i + 1, subset, results);
            subset.remove(subset.size() - 1);
        }
    }

    public static void main(String[] args) {
        Problem18 p = new Problem18();
        int[] input = {1, 2};
        p.subsetsWithDup(input);
    }
}
