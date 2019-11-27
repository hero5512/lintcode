package lintcode.array;

import java.util.List;

public class Problem51 {
    /**
     * @param nums
     * @return TestCase 765234354321 765234354312
     * [7,6,5,2,3,4,3,5,4,3,2,1]
     */
    /*
     * @param nums: A list of integers
     * @return: A list of integers that's previous permuation
     */
    public List<Integer> previousPermuation(List<Integer> nums) {
        int i = nums.size() - 2;
        while (i >= 0 && nums.get(i + 1) >= nums.get(i)) {
            i--;
        }
        if (i >= 0) {
            int j = nums.size() - 1;
            while (j >= 0 && nums.get(j) >= nums.get(i)) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1, nums.size() - 1);
        return nums;
    }

    public void swap(List<Integer> nums, int i, int j) {
        int tmp = nums.get(i);
        nums.set(i, nums.get(j));
        nums.set(j, tmp);
    }

    public void reverse(List<Integer> nums, int i, int j) {
        while (i < j) {
            swap(nums, i++, j--);
        }
    }
}
