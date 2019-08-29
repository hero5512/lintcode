package lintcode.integer;

public class Problem413 {
    /**
     * @param n: the integer to be reversed
     * @return: the reversed integer
     */
    public int reverseInteger(int n) {
        // write your code here
        int reverse = 0;
        while (n != 0) {

            int tmp = reverse * 10 + n % 10;
            if (tmp % 10 != n % 10) {
                reverse = 0;
                break;
            }
            n = n / 10;
            reverse = tmp;
        }
        return reverse;
    }
}
