package lintcode.recursion;

import java.util.ArrayList;
import java.util.List;

public class Problem16 {
    public List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null) {
            return result;
        }
        if (nums.length == 0) {
            result.add(new ArrayList<Integer>());
            return result;
        }


        core(result, nums, 0);
        return result;
    }

    private void core(List<List<Integer>> result, int[] nums, int cur) {

        if (cur == nums.length) {
            ArrayList<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                tmp.add(nums[i]);
            }
            if (!result.contains(tmp)) {
                result.add(tmp);
            }
            return;
        }

        for (int i = cur; i < nums.length; i++) {
            swamp(nums, cur, i);
            core(result, nums, cur + 1);
            swamp(nums, cur, i);
        }
    }

    private void swamp(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
