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
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        subsetsWithDupCore(nums, new ArrayList<>(), 0, result);
        return result;
    }

    private void subsetsWithDupCore(int[] nums, List<Integer> subset, int index, List<List<Integer>> result) {

        if (index == nums.length) {
            result.add(new ArrayList<>(subset));
            return;
        }

            subset.add(nums[index]);
            subsetsWithDupCore(nums, subset, index + 1, result);
        if ((index != 0 && nums[index - 1] != nums[index])) {
            subset.remove(subset.size() - 1);
            subsetsWithDupCore(nums, subset, index + 1, result);
        } else {
            subsetsWithDupCore(nums, subset, index + 1, result);
        }
    }

    public static void main(String[] args) {
        Problem18 p = new Problem18();
        int[] input = {0};
        p.subsetsWithDup(input);
    }
}
