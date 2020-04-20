package com.liang.leetcode.dynamicProgramming;

/**
 * @ClassName: MST081
 * @Description: 三步问题
 * @Author: LiaNg
 * @Date: 2020/4/20 16:36
 */
public class MST081 {

    public static void main(String[] args) {
        MST081 mst081 = new MST081();
        int n = 3;
        System.out.println("mst081.waysToStep(n) = " + mst081.waysToStep(n));
    }

    /**
     * 三步问题。有个小孩正在上楼梯，楼梯有 n 阶台阶，小孩一次可以上 1 阶、2 阶或 3 阶。实现一种方法，计算小孩有多少种上楼梯的方式。结果可能很大，你需要对结果模 1000000007。
     * 示例 1:
     * 输入：n = 3
     * 输出：4
     * 说明: 有四种走法
     * 示例 2:
     * 输入：n = 5
     * 输出：13
     * 提示:
     * n 范围在 [1, 1000000] 之间
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/three-steps-problem-lcci
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int waysToStep(int n) {

        if (n <= 2) {
            return n;
        }

        long[] dp = new long[n + 1];

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i < dp.length; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3])%1000000007;
        }

        return (int)dp[n];

    }
}
