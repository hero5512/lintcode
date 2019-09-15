package lintcode.stack;

import java.util.ArrayList;

public class Problem421 {

    /**
     * @param path: the original path
     * @return: the simplified path
     */
    public String simplifyPath(String path) {
        // write your code here

        String result = "/";
        String[] stubs = path.split("/+");

        ArrayList<String> paths = new ArrayList<>();

        for (String s : stubs) {
            if ("..".equals(s)) {
                if (paths.size() > 0) {
                    paths.remove(paths.size() - 1);
                }
            } else if (!".".equals(s) && !"".equals(s)) {
                paths.add(s);
            }
        }

        for (String p : paths) {
            result += p + "/";
        }

        if (result.length() > 1) {
            result = result.substring(0, result.length() - 1);
        }
        return result;
    }
}
