package lintcode.binary;

public class Problem14 {
    /**
     * @param nums:   The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0, right = nums.length;

        while (left + 1 < right) {
            int middle = (left + right) / 2;
            if (nums[middle] == target) {
                right = middle;
            } else if (nums[middle] < target) {
                left = middle;
            } else {
                right = middle;
            }
        }
        if (nums[left] == target) {
            return left;
        } else if (nums[right] == target) {
            return right;
        }
        return -1;
    }
}
