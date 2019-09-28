package lintcode.array;

public class Problem143 {

    /**
     * @param colors: A list of integer
     * @param k:      An integer
     * @return: nothing
     */
    public void sortColors2(int[] colors, int k) {
        // write your code here
        if (colors == null || colors.length == 0) {
            return;
        }
        rainbowSort(colors, 0, colors.length - 1, 1, k);
    }

    private void rainbowSort(int[] colors, int left, int right, int fromColor, int toColor) {
        if (fromColor == toColor) {
            return;
        }
        if (left >= right) {
            return;
        }

        int midColor = (fromColor + toColor) / 2;
        int l = left, r = right;
        while (l <= r) {
            while (l <= r && colors[l] <= midColor) {
                l++;
            }
            while (l <= r && colors[r] > midColor) {
                r--;
            }
            if (l <= r) {
                int tmp = colors[l];
                colors[l] = colors[r];
                colors[r] = tmp;
                l++;
                r--;
            }
        }
        rainbowSort(colors, left, r, fromColor, midColor);
        rainbowSort(colors, l, right, midColor + 1, toColor);
    }

    public static void main(String[] args) {
        Problem143 p = new Problem143();
        int[] input = {3, 2, 3, 3, 4, 3, 3, 2, 4, 4, 1, 2, 1, 1, 1, 3, 4, 3, 4, 2};
        p.sortColors2(input, 4);
    }
}
