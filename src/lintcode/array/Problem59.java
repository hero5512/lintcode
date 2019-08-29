package lintcode.array;

import java.util.Arrays;

public class Problem59 {

    /**
     * @param numbers: Give an array numbers of n integer
     * @param target: An integer
     * @return: return the sum of the three integers, the sum closest target.
     */
    public int threeSumClosest(int[] numbers, int target) {
        // write your code here
        if (numbers == null || numbers.length < 3) {
            throw new RuntimeException("Illegal parameters");
        }

        int best = numbers[0] + numbers[1] + numbers[2];

        Arrays.sort(numbers);

        for (int i = 0; i < numbers.length; i++) {
            int left = i + 1; int right = numbers.length - 1;
            while (left < right) {
                int sum = numbers[i] + numbers[left] + numbers[right];
                if (Math.abs(sum - target) < Math.abs(best - target)) {
                    best = sum;
                }
                if (sum == target) { //如果和与target相等就不用判断了
                    break;
                } else if (sum > target) {
                    right -= 1;
                } else {
                    left += 1;
                }
            }
        }
        return best;
    }

}
