package lintcode.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem48 {

    /**
     * @param nums: A list of integers
     * @param k:    An integer
     * @return: The majority number
     */
    public int majorityNumber(List<Integer> nums, int k) {
        // write your code here

        int length = nums.size();

        if (length < k) {
            return -1;
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int x : nums) {
            if (!map.containsKey(x)) {
                map.put(x, 1);
            } else if (map.containsKey(x)) {
                map.put(x, map.get(x) + 1);
            }

            if (map.size() >= k) {
                Map<Integer, Integer> tmp = new HashMap<>();
                for (int key : map.keySet()) {
                    if (map.get(key) > 1) {
                        tmp.put(key, map.get(key) - 1);
                    }
                }
                map = tmp;
            }
        }

        for (int key : map.keySet()) {
            map.put(key, 0);
        }

        for (int i : nums) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            }
        }

        int result = 0;
        int count = 0;
        for (int key : map.keySet()) {
            if (map.get(key) > count) {
                result = key;
                count = map.get(key);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] aa = {6, 2, 3, 4, 5, 1, 6, 6, 1, 1, 6};
        ArrayList<Integer> input = new ArrayList<>();
        for (int i = 0; i < aa.length; i++) {
            input.add(aa[i]);
        }
        Problem48 p = new Problem48();
        p.majorityNumber(input, 3);
    }
}
