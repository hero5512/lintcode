package lintcode.dp;

public class Problem154 {
    /**
     * @param s: A string
     * @param p: A string includes "." and "*"
     * @return: A boolean
     * <p>
     * 解题思路
     * 使用动态规划，match[i][j] = true 表示 s[0...i-1]与p[0...j-1]匹配，否则表示不匹配，分为两种情况：
     * 1.如果p[j - 1] == '*'时，如果表示前面字符重复0次，则match[i][j] = match[i][j-2]，
     * 如果表示前面的字符至少重复1次，则需要判断s[i-1]和p[i-2]是否匹配，
     * 即match[i][j] = match[i - 1][j] && (s[i - 1] == p[j - 2] || p[j - 2] == '.')
     * 2.当p[j-1]不为'*'时，只需要判断s[i-1]与p[j-1]是否匹配即可，即此时
     * match[i][j] = match[i - 1][j - 1] && (s[i - 1] == p[j - 1] || p[j - 1] == '.');
     */
    public boolean isMatch(String s, String p) {
        // write your code here
        if (s == null || p == null) {
            return true;
        }

        int n = s.length();
        int m = p.length();

        boolean[][] match = new boolean[n + 1][m + 1];
        match[0][0] = true;

        for (int i = 0; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (p.charAt(j - 1) == '*') {
                    match[i][j] = j > 1 && (match[i][j - 2] || (i > 0 && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') && match[i - 1][j]));
                } else {
                    match[i][j] = i > 0 && match[i - 1][j - 1] && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.');
                }
            }
        }
        return match[n][m];
    }

    public static void main(String[] args) {
        Problem154 p = new Problem154();
        System.out.printf(p.isMatch("lintcode", "*") + "");
    }

}
