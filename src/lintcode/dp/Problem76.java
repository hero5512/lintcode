package lintcode.dp;

public class Problem76 {

    /**
     * @param nums: An integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    public int longestIncreasingSubsequence(int[] nums) {
        // write your code here

        if (nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        int[] dp = new int[len];

        int max = 1;

        for (int i = 0; i < len; i++) {
            dp[i] = 1;
        }

        for (int i = 1; i < len; i++) {
            int tmpMax = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && dp[j] + 1 > tmpMax) {
                    tmpMax = dp[j] + 1;
                }
            }
            dp[i] = tmpMax;
            if (dp[i] > max) {
                max = dp[i];
            }
        }

        return max;
    }
}
