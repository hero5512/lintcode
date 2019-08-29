package lintcode.recursion;

import javafx.beans.binding.StringBinding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem425 {
    /**
     * @param digits: A digital string
     * @return: all posible letter combinations
     */
    public List<String> letterCombinations(String digits) {
        // write your code here
        List<String> result = new ArrayList<>();

        if (digits == null || digits.length() == 0) {
            return result;
        }

        HashMap<Character, char[]> map = new HashMap<>();
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});
        StringBuilder tmp = new StringBuilder();

        letterCombinationsCore(digits, map, 0, tmp, result);
        return result;
    }

    private void letterCombinationsCore(String digits, Map<Character, char[]> map, int index, StringBuilder tmp, List<String> result) {
        if (index == digits.length()) {
            result.add(tmp.toString());
            return;
        }
        char[] curs = map.get(digits.charAt(index));
        for (char c:
             curs) {
            tmp.append(c);
            letterCombinationsCore(digits, map, index + 1, tmp, result);
            tmp.deleteCharAt(tmp.length() - 1);
        }
    }

    public static void main(String[] args) {
        Problem425 p = new Problem425();
        p.letterCombinations("23");
    }
}
