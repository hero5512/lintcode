package lintcode.string;

public class Problem13 {
    /**
     * @param source:
     * @param target:
     * @return: return the index
     */
    public int strStr(String source, String target) {
        // Write your code here
        if (source == null || target == null) {
            return -1;
        }
        if ("".equals(target)) {
            return 0;
        }
        for (int i = 0; i < source.length() - target.length() + 1; i++) {
            int j = 0;
            for (; j < target.length(); j++) {
                if (source.charAt(i + j) != target.charAt(j)) {
                    break;
                }
            }
            if (j == target.length()) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Problem13 p = new Problem13();
        System.out.println(p.strStr("abcdabcdefg", "bcd"));
    }

}
