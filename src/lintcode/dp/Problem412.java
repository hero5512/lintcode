package lintcode.dp;

import java.util.Arrays;

public class Problem412 {
    /**
     * @param ratings: Children's ratings
     * @return: the minimum candies you must give
     */
    public int candy(int[] ratings) {
        // write your code here

        if (ratings == null || ratings.length == 0) {
            return 0;
        }

        int[] candies = new int[ratings.length];
        int result = 0;

        Arrays.fill(candies, 1);
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        for (int i = ratings.length - 1; i >= 1 ; i--) {
            result += candies[i];
            if (ratings[i] < ratings[i - 1] && candies[i] >= candies[i - 1]) {
                candies[i - 1] = candies[i] + 1;
            }
        }

        result += candies[0];
        return result;
    }
}
