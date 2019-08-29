package lintcode.greedy;

import java.util.List;

public class Problem46 {
    /*
     * @param nums: a list of integers
     * @return: find a  majority number
     */
    public int majorityNumber(List<Integer> nums) {
        // write your code here

        int count = 1;
        int majority = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            if (majority == nums.get(i)) {
                count++;
            } else {
                count--;
                if (count < 0) {
                    majority = nums.get(i);
                }
            }
        }
        return majority;
    }
}
