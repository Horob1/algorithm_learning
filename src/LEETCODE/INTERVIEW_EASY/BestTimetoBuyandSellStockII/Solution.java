package LEETCODE.INTERVIEW_EASY.BestTimetoBuyandSellStockII;

class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;
        int profit = 0;
        int lastPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > lastPrice) {
                profit += prices[i] - lastPrice;
            }
            lastPrice = prices[i];

        }
        return profit;
    }
}