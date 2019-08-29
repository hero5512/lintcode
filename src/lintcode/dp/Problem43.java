package lintcode.dp;

public class Problem43 {
    /**
     * @param nums: A list of integers
     * @param k:    An integer denote to find k non-overlapping subarrays
     * @return: An integer denote the sum of max k non-overlapping subarrays
     */
    public int maxSubArray(int[] nums, int k) {
        // write your code here
        if (nums.length < k) {
            return 0;
        }

        int len = nums.length;

        // 表示前i个元素取k个子数组并且必须包含第i个元素的最大和
        int[][] localMax = new int[len + 1][k + 1];
        // 表示前i个元素取k个子数组不一定包含第i个元素的最大和
        int[][] globalMax = new int[len + 1][k + 1];

        for (int j = 1; j <= k; j++) {
            localMax[j - 1][j] = Integer.MIN_VALUE;
            for (int i = j; i <= len; i++) {
                localMax[i][j] = Math.max(globalMax[i - 1][j - 1], localMax[i - 1][j]) + nums[i - 1];
                if (i == j) {
                    globalMax[i][j] = localMax[i][j];
                } else {
                    globalMax[i][j] = Math.max(globalMax[i - 1][j], localMax[i][j]);
                }
            }
        }
        return globalMax[len][k];
    }
}
