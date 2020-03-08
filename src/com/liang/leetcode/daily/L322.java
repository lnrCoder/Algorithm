package com.liang.leetcode.daily;

import java.util.Arrays;

/**
 * @ClassName: L322
 * @Description: 零钱兑换 2020.3.8
 * @Author: LiaNg
 * @Date: 2020/3/8 20:15
 */
public class L322 {

    public static void main(String[] args) {

        L322 l322 = new L322();
        int[] coins = {2};
        int amount = 3;
        System.out.println(l322.coinChange(coins, amount));
    }

    int ans = Integer.MAX_VALUE;

    /**
     * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/coin-change
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int coinChange(int[] coins, int amount) {

        Arrays.sort(coins);
        dfs(coins, amount, coins.length - 1, 0);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public void dfs(int[] coins, int amount, int index, int count) {

        if (index < 0) {
            return;
        }

        for (int i = amount / coins[index]; i >= 0; i--) {
            int nowAmount = amount - i * coins[index];
            int nowCount = count + i;
            if (nowAmount == 0) {
                ans = Math.min(ans, nowCount);
                break;
            }
            if (nowCount + 1 >= ans) {
                break;
            }
            dfs(coins, nowAmount, index - 1, nowCount);
        }
    }
}
