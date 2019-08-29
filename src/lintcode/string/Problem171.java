package lintcode.string;

import java.util.*;

public class Problem171 {
    /**
     * @param strs: A list of strings
     * @return: A list of strings
     */
    public List<String> anagrams(String[] strs) {
        // write your code here
        List<String> res = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return res;
        }

        Map<String, ArrayList> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            char[] tmp = strs[i].toCharArray();
            Arrays.sort(tmp);
            String key = String.valueOf(tmp);
            if (!map.containsKey(key)) {
                ArrayList list = new ArrayList();
                map.put(key, list);
            }
            map.get(key).add(strs[i]);
        }

        for (Map.Entry<String, ArrayList> entry : map.entrySet()) {
            if (entry.getValue().size() >= 2) {
                res.addAll(entry.getValue());
            }
        }

        return res;
    }
}
