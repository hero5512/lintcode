package lintcode.array;

import java.util.HashMap;

public class Problem56 {
    /**
     * @param numbers: An array of Integer
     * @param target:  target = numbers[index1] + numbers[index2]
     * @return: [index1, index2] (index1 < index2)
     */
    public int[] twoSum(int[] numbers, int target) {
        // write your code here
        if (numbers == null) {
            return null;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            map.put(numbers[i], i);
        }

        for (int i = 0; i < numbers.length; i++) {
            int search = target - numbers[i];
            if (map.containsKey(search) && map.get(search) != i) {
                res[0] = i;
                res[1] = map.get(search);
                return res;
            }
        }
        return null;
    }
}
