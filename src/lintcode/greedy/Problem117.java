package lintcode.greedy;

public class Problem117 {
    /**
     * @param A: A list of integers
     * 动态规划解法
     * @return: An integer
     */
    public int jump(int[] A) {
        // write your code here

        int[] steps = new int[A.length];
        steps[0] = 0;
        for (int i = 1; i < A.length; i++) {
            steps[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                if (steps[j] != Integer.MAX_VALUE && j + A[j] >= i) {
                    steps[i] = Math.min(steps[i], steps[j] + 1);
                }
            }
        }

        return steps[A.length - 1];
    }

    /**
     * TODO 贪心算法待续
     */
}
