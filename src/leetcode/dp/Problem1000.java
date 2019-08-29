package leetcode.dp;

public class Problem1000 {

    /**
     * @param prices: a list of integers
     * @param fee: a integer
     * @return: return a integer
     */
    public int maxProfit(int[] prices, int fee) {
        // write your code here
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int length = prices.length;
        int[] sell = new int[length];
        int[] hold = new int[length];
        sell[0] = 0;
        hold[0] = -prices[0];

        for (int i = 1; i < length; i++) {
            sell[i] = Math.max(sell[i - 1], hold[i - 1] + prices[i] - fee);
            hold[i] = Math.max(hold[i - 1], sell[i - 1] - prices[i]);
        }
        return sell[length - 1];
    }
    
}
