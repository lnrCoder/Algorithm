package com.liang.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @ClassName L1047
 * @description 删除字符串中的所有相邻重复项
 * @Author LiaNg
 * @Date 2019-11-07
 */
public class L1047 {

    public static void main(String[] args) {
        String s = "abbaca";
        System.out.println("removeDuplicates(s) = " + removeDuplicates(s));
    }

    /**
     * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
     * 在 S 上反复执行重复项删除操作，直到无法继续删除。
     * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static String removeDuplicates(String S) {

        if (S.length() <= 0) {
            return "";
        }

        Deque deque = new ArrayDeque<>();
        char[] charArray = S.toCharArray();
        deque.addLast(charArray[0]);

        for (int i = 1; i < charArray.length; i++) {
            if (!deque.isEmpty() && deque.peekLast().equals(charArray[i])) {
                deque.pollLast();
                continue;
            } else {
                deque.addLast(charArray[i]);
            }
        }

        StringBuilder result = new StringBuilder();
        while (!deque.isEmpty()) {
            result.append(deque.pollFirst());
        }

        return result.toString();
    }

    /**
     * LeetCode 耗时最短解答
     */
    public String removeDuplicates1(String S) {
        int top = -1;

        char[] s = S.toCharArray();

        for (int i = 0; i < s.length; i++) {

            if (top != -1 && s[i] == s[top]) {
                top--;
            } else {
                s[++top] = s[i];
            }
        }

        return new String(s, 0, top + 1);
    }

}
