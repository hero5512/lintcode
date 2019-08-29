package lintcode.dp;

public class Problem154 {
    /**
     * @param s: A string
     * @param p: A string includes "." and "*"
     * @return: A boolean
     */
    public boolean isMatch(String s, String p) {
        // write your code here
        if (s == null || p == null) {
            return true;
        }

        return isMatchCore(s, 0, p, 0);
    }

    private boolean isMatchCore(String s, int sIndex, String p, int pIndex) {

        if (pIndex == p.length()) {
            return sIndex == s.length();
        }

        if (sIndex == s.length()) {
            return isEmpty(p, pIndex);
        }

        if (p.charAt(pIndex) == '.') {
            return isMatchCore(s, sIndex + 1, p, pIndex + 1);
        } else if (p.charAt(pIndex) == '*') {
            if (p.charAt(pIndex - 1) == '.') {
                return isMatchCore(s, sIndex + 1, p, pIndex) || isMatchCore(s, sIndex + 1, p, pIndex + 1) || isMatchCore(s, sIndex, p, pIndex + 1);
            } else {
                if (s.charAt(sIndex) == p.charAt(pIndex - 1)) {
                    return isMatchCore(s, sIndex + 1, p, pIndex) || isMatchCore(s, sIndex + 1, p, pIndex + 1) || isMatchCore(s, sIndex, p, pIndex + 1);
                } else {
                    return isMatchCore(s, sIndex, p, pIndex + 1);
                }

            }
        } else {
            if (p.charAt(pIndex) == s.charAt(sIndex)) {
                return isMatchCore(s, sIndex + 1, p, pIndex + 1) ;
            } else {
                return isMatchCore(s, sIndex, p, pIndex + 1);
            }
        }
    }

    private boolean isEmpty(String p, int index) {
//        for (int i = index; i < p.length(); i++) {
//            if (p.charAt(i) != '*') {
//                return false;
//            }
//        }
        while (index < p.length()) {
            if (p.charAt(index) != '*') {
                if (!(index + 1 < p.length() && p.charAt(index + 1) == '*')) {
                    return false;
                }
            }
            index++;
        }
        return true;
    }


    public static void main(String[] args) {
        Problem154 p = new Problem154();
        System.out.println(p.isMatch("bbbba",".*a*a"
        ));
    }
}
