package com.liang.leetcode.daily;

/**
 * 面试题46. 把数字翻译成字符串
 *
 * @author LiaNg
 * @date 2020/6/9 11:06
 */
public class MST46 {

    public static void main(String[] args) {
        MST46 mst46 = new MST46();
        int num = 12258;
        System.out.println("mst46.translateNum(num) = " + mst46.translateNum(num));
    }

    /**
     * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
     *  
     * 示例 1:
     * 输入: 12258
     * 输出: 5
     * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
     *  
     * 提示：
     * 0 <= num < 2^31
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int translateNum(int num) {
        if (num == 0) {
            return 1;
        }
        return f(num);
    }

    int f(int num) {
        if (num < 10) {
            return 1;
        }
        if (num % 100 < 26 && num % 100 > 9) {
            return f(num / 10) + f(num / 100);
        } else {
            return f(num / 10);
        }
    }
}
