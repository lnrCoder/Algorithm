package com.liang.leetcode.daily;

/**
 * 二进制求和
 *
 * @author LiaNg
 * @date 2020/6/23 11:57
 */
public class L67 {

    public static void main(String[] args) {
        L67 l67 = new L67();
        String a = "1010";
        String b = "1011";
        System.out.println("l67.addBinary(a,b) = " + l67.addBinary(a, b));
    }

    /**
     * 给你两个二进制字符串，返回它们的和（用二进制表示）。
     * 输入为 非空 字符串且只包含数字 1 和 0。
     *  
     * 示例 1:
     * 输入: a = "11", b = "1"
     * 输出: "100"
     * 示例 2:
     * 输入: a = "1010", b = "1011"
     * 输出: "10101"
     *  
     * 提示：
     * 每个字符串仅由字符 '0' 或 '1' 组成。
     * 1 <= a.length, b.length <= 10^4
     * 字符串如果不是 "0" ，就都不含前导零。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/add-binary
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public String addBinary(String a, String b) {

        String res = "";

        int aLength = a.length();
        int bLength = b.length();

        if (a.length() < b.length()) {
            return addBinary(b, a);
        }

        int ra = aLength - 1;
        int rb = bLength - 1;
        int tmp = 0;

        int i = ra;
        for (; i >= 0; i--) {
            if (rb >= 0) {
                tmp += b.charAt(rb) - '0';
            }
            tmp += a.charAt(ra) - '0';

            res = tmp % 2 + res;

            tmp = tmp / 2;
            ra--;
            rb--;
        }

        if (tmp == 1) {
            res = tmp + res;
        }

        return res;
    }
}
