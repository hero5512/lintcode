package lintcode.array;

public class Problem65 {

    public double findMedianSortedArrays(int[] A, int[] B) {
        // write your code here
        int n = A.length + B.length;
        if (n % 2 == 0) {
            return (findKthNum(A, 0, B, 0, n / 2) +
                    findKthNum(A, 0, B, 0, n / 2 + 1)) / 2.0;
        }
        return findKthNum(A, 0, B, 0, n / 2 + 1);
    }

    public int findKthNum(int[] A, int startOfA, int[] B, int startOfB, int k) {

        if (startOfA >= A.length) {
            return B[startOfB + k - 1];
        }

        if (startOfB >= B.length) {
            return A[startOfA + k - 1];
        }

        if (k == 1) {
            return Math.min(A[startOfA], B[startOfB]);
        }

        int halfKthOfA = startOfA + k / 2 - 1 < A.length ? A[startOfA + k / 2 - 1] : Integer.MAX_VALUE;
        int halfKthOfB = startOfB + k / 2 - 1 < B.length ? B[startOfB + k / 2 - 1] : Integer.MAX_VALUE;

        if (halfKthOfA < halfKthOfB) {
            return findKthNum(A, startOfA + k / 2, B, startOfB, k - k / 2);
        } else {
            return findKthNum(A, startOfA, B, startOfB + k / 2, k - k / 2);
        }

    }

    public static void main(String[] args) {
        Problem65 p = new Problem65();
        int[] A = {1, 2, 3, 4, 5, 6};
        int[] B = {2, 3, 4, 5};
        System.out.println(p.findMedianSortedArrays(A, B));
    }


}
