package lintcode.enumeration;

public class Problem3 {
    /**
     * @param k: An integer
     * @param n: An integer
     * @return: An integer denote the count of digit k in 1..n
     */
    public int digitCounts(int k, int n) {
        // write your code here

        int result = 0;
        for (int i = k; i <= n; i++) {
            result += singleCount(k, i);
        }
        return result;
    }

    int singleCount(int k, int i) {

        if (i == 0 && k == 0) {
            return 1;
        }
        int result = 0;
        while (i > 0) {
            if (i % 10 == k) {
                result++;
            }
            i /= 10;
        }

        return result;
    }

    //TODO 更快的方法

    public int digitCounts2(int k, int n) {
        // write your code here

        if (n < 10) {
            return 1;
        }
        int cnt = 0, pow = 1;
        int tmp = n;
        while (tmp != 0) {
            int digit = tmp % 10;
            if (digit < k) {
                cnt += (tmp / 10) * pow;

            } else if (digit == k) {
                cnt += (tmp / 10) * pow + n % pow + 1;
            } else {
                if (!(k == 0 && tmp / 10 == 0)) {
                    cnt += (tmp / 10 + 1) * pow;
                }
            }
            tmp /= 10;
            pow *= 10;
        }
        return cnt;
    }

}
