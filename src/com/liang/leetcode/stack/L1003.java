package com.liang.leetcode.stack;

/**
 * @ClassName L1003
 * @description 检查替换后的词是否有效
 * @Author LiaNg
 * @Date 2019-11-25
 */
public class L1003 {

    public static void main(String[] args) {

        String S = "abcabcababcc";

        L1003 l1003 = new L1003();
        System.out.println("l1003.isValid(S) = " + l1003.isValid(S));

    }

    /**
     * 给定有效字符串 "abc"。
     * 对于任何有效的字符串 V，我们可以将 V 分成两个部分 X 和 Y，使得 X + Y（X 与 Y 连接）等于 V。（X 或 Y 可以为空。）那么，X + "abc" + Y 也同样是有效的。
     * 例如，如果 S = "abc"，则有效字符串的示例是："abc"，"aabcbc"，"abcabc"，"abcabcababcc"。无效字符串的示例是："abccba"，"ab"，"cababc"，"bac"。
     * 如果给定字符串 S 有效，则返回 true；否则，返回 false。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/check-if-word-is-valid-after-substitutions
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public boolean isValid(String S) {
        String abc = S.replace("abc", "");

        while (abc.length() != S.length()) {
            S = S.replace("abc", "");
            abc = abc.replace("abc", "");
        }

        return S.length() == 0;
    }

    /**
     * LeetCode 耗时最短解答
     */
    public boolean isValid1(String S) {
        char[] cs = S.toCharArray(), stack = new char[S.length()];
        int index = 0;

        for (char c : cs) {
            if (c != 'c') {
                stack[index++] = c;
            } else {
                if (index < 2) {
                    return false;
                } else {
                    if (stack[--index] != 'b') {
                        return false;
                    }
                    if (stack[--index] != 'a') {
                        return false;
                    }
                }
            }
        }

        return index == 0;
    }
}
