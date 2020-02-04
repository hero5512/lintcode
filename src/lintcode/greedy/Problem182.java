package lintcode.greedy;

public class Problem182 {
    /**
     * @param A: A positive integer which has N digits, A is a string
     * @param k: Remove k digits
     * @return: A string
     */
    public String DeleteDigits(String A, int k) {
        // write your code here
        StringBuffer sb = new StringBuffer(A);
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < sb.length(); j++) {
                if (j == sb.length() - 1 || sb.charAt(j) > sb.charAt(j + 1)) {
                    sb.deleteCharAt(j);
                    break;
                }
            }
        }
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
}
