package lintcode.sort;

import java.util.ArrayList;
import java.util.List;

public class Problem894 {

    public List<Integer> pancakeSort(int[] A) {
        List<Integer> res = new ArrayList<>();
        int len = A.length;
        while (len >= 1) {
            int maxIndex = getMaxIndex(A, len - 1);
            res.add(maxIndex + 1);
            reverse(A, 0, maxIndex);
            res.add(len);
            reverse(A, 0, len - 1);
            len--;
        }
        return res;
    }

    private void reverse(int[] A, int left, int right) {
        while (left < right) {
            int tmp = A[left];
            A[left] = A[right];
            A[right] = tmp;
            left++;
            right--;
        }
    }

    private int getMaxIndex(int[] A, int right) {
        int maxValue, maxIndex;
        maxValue = A[0];
        maxIndex = 0;
        for (int i = 0; i <= right; i++) {
            if (maxValue <= A[i]) {
                maxValue = A[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

}
