package com.liang.leetcode;

/**
 * @ClassName L123
 * @description best-time-to-buy-and-sell-stock-iii
 * @Author LiaNg
 * @Date 2018/11/12
 */
public class L123 {

    public static void main(String[] args) {
        int[] numbers = {3,3,5,0,0,3,1,4};

        L123 l = new L123();
        System.out.println(l.maxProfit(numbers));
    }

    /**
     * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
     * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
     * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     *
     * 参考 https://cloud.tencent.com/developer/article/1019199
     */
    public int maxProfit(int[] prices) {
        int b1=Integer.MIN_VALUE,b2=Integer.MIN_VALUE;
        int s1=0,s2=0;

        for(int i=0;i<prices.length;i++){
            b1=Math.max(b1,-prices[i]);
            s1=Math.max(s1,b1+prices[i]);
            b2=Math.max(b2,s1-prices[i]);
            s2=Math.max(s2,b2+prices[i]);
        }
        return s2;
    }

}
