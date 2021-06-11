package com.liang.leetcode.daily.Jun21;

/**
 * 完全平方数
 * 四平方定理： https://baike.baidu.com/item/%E5%9B%9B%E5%B9%B3%E6%96%B9%E5%92%8C%E5%AE%9A%E7%90%86
 *
 * @author LiaNg
 * @date 2021/6/11 9:22
 */
public class L279 {

    /**
     * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
     * 给你一个整数 n ，返回和为 n 的完全平方数的 最少数量 。
     * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
     *  
     * 示例 1：
     * 输入：n = 12
     * 输出：3
     * 解释：12 = 4 + 4 + 4
     * 示例 2：
     * 输入：n = 13
     * 输出：2
     * 解释：13 = 4 + 9
     *  
     * 提示：
     * 1 <= n <= 104
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/perfect-squares
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int numSquares(int n) {

        if (isPerfectSquare(n)) {
            return 1;
        }

        if (checkAnswer4(n)) {
            return 4;
        }

        for (int i = 1; i * i <= n; i++) {
            int j = n - i * i;
            if (isPerfectSquare(j)) {
                return 2;
            }
        }

        return 3;
    }

    /**
     * 判断 n 是否平方数
     */
    public boolean isPerfectSquare(int n) {
        int x = (int) Math.sqrt(n);
        return x * x == n;
    }

    /**
     * 评断 n 是否是 4 个平方数的合
     */
    public boolean checkAnswer4(int n) {
        while (n % 4 == 0) {
            n /= 4;
        }

        return n % 8 == 7;
    }

    public static void main(String[] args) {
        L279 l279 = new L279();
        int n = 13;
        System.out.println("l279.numSquares(n) = " + l279.numSquares(n));
    }

}
