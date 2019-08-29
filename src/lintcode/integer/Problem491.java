package lintcode.integer;

public class Problem491 {

    /**
     * @param num: a positive number
     * @return: true if it's a palindrome or false
     */
    public boolean isPalindrome(int num) {
        // write your code here
        int tmp = num;
        int reverse = 0;
        while (tmp != 0) {
            reverse = reverse * 10 + tmp % 10;
            tmp /= 10;
        }

        if (reverse == num) {
            return true;
        } else {
            return false;
        }
    }
}
