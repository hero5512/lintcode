package lintcode.string;

/**
 * 给出一个字符串（假设长度最长为1000），
 * 求出它的最长回文子串，你可以假定只有一个满足条件的最长回文串。
 */
public class Problem200 {
    /**
     * @param s: input string
     * @return: the longest palindromic substring
     */
    public String longestPalindrome(String s) {
        // write your code here

        if (s == null) {
            return null;
        }
        int start = 0;
        int len = 0;
        int longest = 0;
        for (int i = 0; i < s.length(); i++) {
            len = findLongestPalindrome(s, i, i);
            if (len > longest) {
                longest = len;
                start = i - len / 2;
            }

            len = findLongestPalindrome(s, i, i + 1);
            if (len > longest) {
                longest = len;
                start = i - len / 2 + 1;
            }

        }
        return s.substring(start, start + longest);
    }

    public int findLongestPalindrome (String s, int left, int right) {

        int len = 0;
        while (left >= 0 && right < s.length()) {
            if (s.charAt(right) != s.charAt(left)) {
                break;
            }
            len += (right == left ? 1 : 2);
            right++;
            left--;
        }
        return len;
    }


}
