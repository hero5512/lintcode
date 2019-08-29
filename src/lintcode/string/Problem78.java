package lintcode.string;

public class Problem78 {
    /**
     * @param strs: A list of strings
     * @return: The longest common prefix
     */
//    public String longestCommonPrefix(String[] strs) {
//        // write your code here
//        if (strs == null || strs.length == 0) {
//            return "";
//        }
//
//        String prefix = strs[0];
//
//        for (int i = 1; i < strs.length; i++) {
//            int j = 0;
//            while (j < prefix.length() && j < strs[i].length() && prefix.charAt(j) == strs[i].charAt(j)) {
//                j++;
//            }
//            if (j == 0) {
//                return "";
//            }
//            prefix = prefix.substring(0, j);
//        }
//
//        return prefix;
//    }
    public String longestCommonPrefix(String[] strs) {
        // write your code here
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }

        int index = 0;

        String first = strs[0];
        while (true) {
            for (int i = 1; i < strs.length; i++) {
                if (index < first.length()) {
                    char cur = first.charAt(index);
                    if (index < strs[i].length()) {
                        if (cur != strs[i].charAt(index)) {
                            return first.substring(0, index);
                        }
                    } else {
                        return strs[i];
                    }
                } else {
                    return first;
                }
            }
            index++;
        }
    }

    public static void main(String[] args) {
        Problem78 p = new Problem78();
        String[] strs = {"ABCD","ABEF","ACEF"};
        System.out.println(p.longestCommonPrefix(strs));
    }
}
