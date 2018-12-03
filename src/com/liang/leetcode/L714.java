package com.liang.leetcode;

/**
 * @ClassName L714
 * @description best-time-to-buy-and-sell-stock-with-transaction-fee
 * @Author LiaNg
 * @Date 2018/12/3
 */
public class L714 {

    public static void main(String[] args) {
        int[] numbers = {1, 3, 2, 8, 4, 9};
        int fee = 2;

        L714 l = new L714();
        System.out.println(l.maxProfit(numbers, fee));
    }

    /**
     * 买卖股票的最佳时机含手续费
     * 给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；非负整数 fee 代表了交易股票的手续费用。
     * 你可以无限次地完成交易，但是你每次交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
     */
    public int maxProfit(int[] prices, int fee) {
        if (prices.length == 0) {
            return 0;
        }
        int[] dp = new int[2];
        dp[1] = -prices[0];
        for (int i = 0; i < prices.length; ++i) {
            dp[0] = Math.max(dp[0], dp[1] + prices[i] - fee);
            dp[1] = Math.max(dp[1], dp[0] - prices[i]);
        }
        return Math.max(dp[0], dp[1]);
    }
}
