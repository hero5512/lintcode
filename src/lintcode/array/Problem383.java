package lintcode.array;

public class Problem383 {
    /**
     * @param heights: a vector of integers
     * @return: an integer
     */
    public int maxArea(int[] heights) {
        // write your code here

        if (heights == null || heights.length <= 1) {
            return 0;
        }

        int left = 0;
        int right = heights.length - 1;
        int capicity = 0;

        while (left < right) {
            if (heights[left] < heights[right]) {
                capicity = Math.max(capicity, (right - left) * heights[left]);
                left++;
            } else {
                capicity = Math.max(capicity, (right - left) * heights[right]);
                right--;
            }
        }
        return capicity;
    }

}
