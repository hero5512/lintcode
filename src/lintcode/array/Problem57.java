package lintcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem57 {
    public List<List<Integer>> threeSum(int[] numbers) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();

        if (numbers == null || numbers.length < 3) {
            return result;
        }

        Arrays.sort(numbers);

        for (int i = 0; i < numbers.length; i++) {
            if (i > 0 && numbers[i] == numbers[i - 1]) {
                continue;
            }
            int target = -numbers[i];
            twoSum(numbers, target, i + 1, numbers.length - 1, result);
        }
        return result;
    }


    public void twoSum(int[] numbers, int target, int left, int right, List<List<Integer>> result) {

        while (left < right) {

            if (numbers[left] + numbers[right] == target) {

                List<Integer> l = new ArrayList<>();
                l.add(-target);
                l.add(numbers[left]);
                l.add(numbers[right]);
                result.add(l);

                left++;
                right--;
                while (left < right && numbers[left] == numbers[left - 1]) {
                    left++;
                }

                while (left < right && numbers[right] == numbers[right + 1]) {
                    right--;
                }

            } else if (numbers[left] + numbers[right] < target) {
                left++;
            } else {
                right--;
            }
        }
    }


}
