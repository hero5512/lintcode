package lintcode.array;

public class Problem62 {
    /**
     * @param A:      an integer rotated sorted array
     * @param target: an integer to be searched
     * @return: an integer
     */
    public int search(int[] A, int target) {
        // write your code here
        if (A == null || A.length == 0) {
            return -1;
        }

        int start = 0;
        int end = A.length - 1;
        int mid;

        while (start + 1 < end) {
            mid = (start + end) / 2;
            if (target == A[mid]) {
                return mid;
            }

            if (A[start] < A[mid]) {
                if (A[start] <= target && target <= A[mid]) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else {
                if (A[mid] <= target && target <= A[end]) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
        }
        if (A[start] == target) {
            return start;
        }

        if (A[end] == target) {
            return end;
        }
        return -1;
    }

    public static void main(String[] args) {
        Problem62 p = new Problem62();
        int[] A = {4, 3};
        System.out.println(p.search(A, 3));
    }
}
