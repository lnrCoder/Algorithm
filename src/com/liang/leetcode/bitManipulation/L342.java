package com.liang.leetcode.bitManipulation;

/**
 * @ClassName: L342
 * @Description: 4的幂
 * @Author: LiaNg
 * @Date: 2020/1/3 10:30
 */
public class L342 {

    public static void main(String[] args) {
        int num = 16;
        L342 l342 = new L342();
        System.out.println("l342.isPowerOfFour(num) = " + l342.isPowerOfFour(num));
    }

    /**
     * 给定一个整数 (32 位有符号整数)，请编写一个函数来判断它是否是 4 的幂次方。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/power-of-four
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public boolean isPowerOfFour(int num) {
        if (num <= 0) {
            return false;
        }
        return ((num & (num - 1)) == 0) && ((num & 0x55555555) == num);
    }
}
