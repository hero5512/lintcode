package lintcode.array;

import java.util.ArrayList;
import java.util.List;

public class Problem50 {

    /*
     * @param nums: Given an integers array A
     * @return: A long long array B and B[i]= A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1]
     */
    public List<Long> productExcludeItself(List<Integer> nums) {
        int len = nums.size();
        List<Long> result = new ArrayList<>();

        long[] reverseAccMul = new long[len];

        reverseAccMul[len - 1] = nums.get(len - 1);

        for (int i = len - 2; i >= 0; i--) {
            reverseAccMul[i] = nums.get(i) * reverseAccMul[i + 1];
        }

        long orderedAccMul = 1;
        for (int i = 0; i < len; i++) {
            int cur = nums.get(i);
            if (i + 1 < len) {
                result.add(i, orderedAccMul * reverseAccMul[i + 1]);
            } else {
                result.add(i, orderedAccMul);
            }
            orderedAccMul *= cur;
        }
        return result;
    }
}
