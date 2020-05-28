package com.liang.acwing;

/**
 * 01背包问题
 *
 * @author LiaNg
 * @date 2020/5/28 21:18
 */
public class A2 {

    public static void main(String[] args) {

        // N 件物品
        int N = 4;
        // 背包容量
        int V = 5;
        // 物品体积
        int[] vArr = new int[]{0,1, 2, 3, 4};
        // 物品价值
        int[] wArr = new int[]{0,2, 4, 4, 5};

        A2 a2 = new A2();
        System.out.println("a2.bag01(N, V, vArr, wArr) = " + a2.bag01(N, V, vArr, wArr));
    }

    public int bag01(int N, int V, int[] vArr, int[] wArr) {

        int[][] dp = new int[N+1][V+1];

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= V; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= vArr[i]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - vArr[i]] + wArr[i]);
                }
            }
        }

        int res = 0;
        for (int i = 0; i <= V; i++) {
            res = Math.max(res, dp[N][i]);
        }

        return res;
    }
}
