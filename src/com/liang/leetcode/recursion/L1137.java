package com.liang.leetcode.recursion;

/**
 * @ClassName L1137
 * @description 第 N 个泰波那契数
 * @Author LiaNg
 * @Date 2019-12-02
 */
public class L1137 {

    public static void main(String[] args) {
        int n = 4;
        L1137 l1137 = new L1137();
        System.out.println("l1137.tribonacci(n) = " + l1137.tribonacci(n));
    }

    /**
     * 泰波那契序列 Tn 定义如下： 
     * T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
     * 给你整数 n，请返回第 n 个泰波那契数 Tn 的值。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/n-th-tribonacci-number
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    // 解法超时
    public int tribonacci_timeout(int n) {

        if (n <= 1) {
            return n;
        }
        if (n == 2) {
            return 1;
        }

        return tribonacci(n - 3) + tribonacci(n - 2) + tribonacci(n - 1);
    }

    /**
     * 将中间变量缓存，减少计算次数
     */
    public int tribonacci(int n) {

        if (n <= 1) {
            return n;
        }
        if (n == 2) {
            return 1;
        }

        int n0 = 0;
        int n1 = 1;
        int n2 = 1;
        while (n-- > 0) {
            // n2->n3 , n1->n2 , n0->n1
            n2 = n2 + n1 + n0;
            n1 = n2 - n1 - n0;
            n0 = n2 - n1 - n0;
        }

        return n0;
    }
}
