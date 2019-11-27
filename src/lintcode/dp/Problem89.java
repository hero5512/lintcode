package lintcode.dp;


public class Problem89 {

    /*
     * @param A: an integer array
     * @param k: a postive integer <= length(A)
     * @param target: an integer
     * @return: A list of lists of integer
     */

    /**
     * @param A:      An integer array
     * @param k:      A positive integer (k <= length(A))
     * @param target: An integer
     * @return: An integer
     */
    public int kSum(int[] A, int k, int target) {
        // write your code here

        int n = A.length;
        int[][][] dp = new int[n + 1][k + 1][target + 1];

        for (int i = 0; i < n + 1; i++) {
            dp[i][0][0] = 1;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < k + 1; j++) {
                for (int l = 0; l < target + 1; l++) {
                    dp[i][j][l] = dp[i - 1][j][l];
                    if (l - A[i - 1] >= 0) {
                        dp[i][j][l] += dp[i - 1][j - 1][l - A[i - 1]];

                    }
                }
            }
        }
        return dp[n][k][target + 1];
    }
}
