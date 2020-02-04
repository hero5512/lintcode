package lintcode.dp;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Problem20 {
    /**
     * @param n an integer
     * @return a list of Map.Entry<sum, probability>
     */
    public List<Map.Entry<Integer, Double>> dicesSum(int n) {
        // Write your code here
        // Ps. new AbstractMap.SimpleEntry<Integer, Double>(sum, pro)
        // to create the pair
        List<Map.Entry<Integer, Double>> res = new ArrayList<>();

        double[][] f = new double[n + 1][6 * n + 1];
        for (int i = 0; i <= 6; i++) {
            f[1][i] = 1.0 / 6;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= 6 * n; j++) {
                for (int k = 1; k <= 6; k++) {
                    if (j > k) {
                        f[i][j] += f[i - 1][j - k];
                    }
                }
                f[i][j] /= 6.0;
            }
        }
        for (int i = n; i <= 6 * n; i++) {
            res.add(new AbstractMap.SimpleEntry<>(i, f[n][i]));
        }
        return res;
    }
}
