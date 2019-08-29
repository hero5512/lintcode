package lintcode.greedy;

import java.util.List;

public class Problem47 {
    /*
     * @param nums: a list of integers
     * @return: The majority number that occurs more than 1/3
     */
    public int majorityNumber(List<Integer> nums) {
        // write your code here
        int a = 0, b = 0;
        int count1 = 0, count2 = 0;

        for (int num : nums) {
            if (num == a) {
                count1++;
            } else if (num == b) {
                count2++;
            } else if (count1 == 0) {
                a = num;
                count1 = 1;
            } else if (count2 == 0) {
                b = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = count2 = 0;
        for (int num : nums) {
            if (num == a) {
                count1++;
            } else if (num == b) {
                count2++;
            }
        }
        return count1 > count2 ? a : b;
    }
}
