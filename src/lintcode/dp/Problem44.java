package lintcode.dp;

import java.util.ArrayList;
import java.util.List;

public class Problem44 {
    /*
     * @param nums: a list of integers
     * @return: A integer indicate the sum of minimum subarray
     */
    public int minSubArray(List<Integer> nums) {
        // write your code here
        if (nums == null || nums.size() == 0) {
            return 0;
        }
        int sum = nums.get(0);
        int min = nums.get(0);

        for (int i = 1; i < nums.size(); i++) {
            if (sum > 0) {
                sum = nums.get(i);
            } else {
                sum += nums.get(i);
            }
            min = min > sum ? sum : min;
        }
        return min;
    }

    public static void main(String[] args) {
        Problem44 p = new Problem44();
        List<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(-1);
        input.add(-2);
        input.add(1);
        System.out.println(p.minSubArray(input));

    }
}
