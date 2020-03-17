package com.liang.leetcode.greedy;

/**
 * @ClassName: L1221
 * @Description: 分割平衡字符串
 * @Author: LiaNg
 * @Date: 2020/3/17 16:01
 */
public class L1221 {

    public static void main(String[] args) {
        String s = "RLLLLRRRLR";
        L1221 l1221 = new L1221();
        System.out.println("l1221.balancedStringSplit(s) = " + l1221.balancedStringSplit(s));
    }

    /**
     * 在一个「平衡字符串」中，'L' 和 'R' 字符的数量是相同的。
     * 给出一个平衡字符串 s，请你将它分割成尽可能多的平衡字符串。
     * 返回可以通过分割得到的平衡字符串的最大数量。
     * 提示：
     * 1 <= s.length <= 1000
     * s[i] = 'L' 或 'R'
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/split-a-string-in-balanced-strings
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int balancedStringSplit(String s) {

        int rCount = 0;
        int result = 0;

        for (char c : s.toCharArray()) {
            if (c == 'R') {
                rCount++;
            } else {
                rCount--;
            }
            if (rCount == 0) {
                result++;
            }
        }

        return result;
    }
}
