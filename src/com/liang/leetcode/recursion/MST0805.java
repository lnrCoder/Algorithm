package com.liang.leetcode.recursion;

/**
 * @ClassName: MST0805
 * @Description: 递归乘法
 * @Author: LiaNg
 * @Date: 2020/3/26 20:04
 */
public class MST0805 {

    public static void main(String[] args) {
        MST0805 mst0805 = new MST0805();
        int A = 2;
        int B = 10;
        System.out.println("mst0805.multiply(A,B) = " + mst0805.multiply(A, B));
    }

    /**
     * 递归乘法。 写一个递归函数，不使用 * 运算符， 实现两个正整数的相乘。可以使用加号、减号、位移，但要吝啬一些。
     * 提示:
     * 保证乘法范围不会溢出
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/recursive-mulitply-lcci
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int multiply(int A, int B) {

        if (A == 0 || B == 0) {
            return 0;
        }
        if (A == 1) {
            return B;
        }
        if (B == 1) {
            return A;
        }

        int result = 0;

        result += (A << 1) + multiply(A, B - 2);

        return result;
    }
}
