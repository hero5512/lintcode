package lintcode.array;

public class Problem100 {
    /*
     * @param nums: An ineger array
     * @return: An integer
     */
    public int removeDuplicates(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int pointer = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[pointer] != nums[i]) {
                nums[++pointer] = nums[i];
            }
        }
        return pointer + 1;
    }

}
