package lintcode.string;

public class Problem1363 {
    /**
     * @param s:       the given string
     * @param numRows: the number of rows
     * @return: the string read line by line
     */
    public String convert(String s, int numRows) {
        // Write your code here

        if (numRows < 2) {
            return s;
        }

        int length = s.length();

        char[] chars = new char[length];
        int count = 0;
        int step = 2 * numRows - 2;
        for (int i = 0; i < numRows; i++) {
            for (int j = i; j < length; j += step) {
                chars[count] = s.charAt(j);
                count++;
                if (i > 0 && i < numRows - 1 && j+ step - 2 * i < length) {
                    chars[count] = s.charAt(j + step - 2 * i);
                    count++;
                }
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        Problem1363 p = new Problem1363();
        System.out.println(p.convert("PAYPALISHIRING", 3));
    }
}
