package lintcode.recursion;

import java.util.ArrayList;
import java.util.List;

public class Problem427 {
    /**
     * @param n: n pairs
     * @return: All combinations of well-formed parentheses
     */
    public List<String> generateParenthesis(int n) {
        // write your code here

        if (n < 0) {
            return null;
        }

        List<String> result = new ArrayList<>();

        if (n == 0) {
            return result;
        }

        StringBuilder tmp = new StringBuilder();
        generateParenthesisCore(result, n, 0, 0, tmp);

        return result;
    }

    private void generateParenthesisCore(List<String> result, int n, int left, int right, StringBuilder tmp) {
        if (left == n && right == n) {
            result.add(tmp.toString());
            return;
        }

        if (left < n) {
            tmp.append('(');
            generateParenthesisCore(result, n, left + 1, right, tmp);
            tmp.deleteCharAt(tmp.length() - 1);
        }

        if (right < left) {
            tmp.append(')');
            generateParenthesisCore(result, n, left, right + 1 , tmp);
            tmp.deleteCharAt(tmp.length() - 1);
        }
    }

    public static void main(String[] args) {
        Problem427 p = new Problem427();
        List<String> result = p.generateParenthesis(3);
        for (String tmp:
             result) {
            System.out.println(tmp);
        }

    }
}
