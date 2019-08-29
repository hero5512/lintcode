package lintcode.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem17 {

    /**
     * @param nums: A set of numbers
     * @return: A list of lists
     */
    public List<List<Integer>> subsets(int[] nums) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);
        subsetsCore(nums, new ArrayList<>(), 0, result);
        return result;
    }

    private void subsetsCore(int[] nums, ArrayList<Integer> subset, int index, List<List<Integer>> result) {

        if (index == nums.length) {
            result.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[index]);
        subsetsCore(nums, subset, index + 1, result);

        subset.remove(subset.size() - 1);
        subsetsCore(nums, subset, index + 1, result);
    }

}
