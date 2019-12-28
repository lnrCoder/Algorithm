package com.liang.leetcode.dynamicProgramming;

/**
 * @ClassName: L121
 * @Description: 买卖股票的最佳时机
 * @Author: LiaNg
 * @Date: 2019/12/28 20:03
 */
public class L121 {

    public static void main(String[] args) {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        L121 l121 = new L121();
        System.out.println("l121.maxProfit(prices) = " + l121.maxProfit(prices));
    }

    /**
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
     * 注意你不能在买入股票前卖出股票。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int maxProfit(int[] prices) {

        if (prices.length <= 1) {
            return 0;
        }

        int max = 0;
        int min = prices[0];

        for (int price : prices) {
            max = Math.max(max, price - min);
            min = Math.min(min, price);
        }

        return max;
    }
}
