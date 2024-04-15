package Code;

public class BuyAndSellStock {

    /**
     * You are given an array prices where prices[i] is the price of a given stock on the ith day.
     *
     * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
     *
     * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
     * Input: prices = [7,1,5,3,6,4]
     * Output: 5
     * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
     */

    public static void main(String[] args) {
        int[] prices = {1,2};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int profit = 0;
        int lsf = Integer.MAX_VALUE, tempProfit;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < lsf)
                lsf = prices[i];
            tempProfit = prices[i] - lsf;
            if (tempProfit > profit)
                profit = tempProfit;
        }
        return profit;
    }
}
