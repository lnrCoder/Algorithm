package com.liang.leetcode.stack;

import java.util.Stack;

/**
 * @ClassName L1209
 * @description 删除字符串中的所有相邻重复项 II
 * @Author LiaNg
 * @Date 2019-11-22
 */
public class L1209 {

    public static void main(String[] args) {
        String s = "deeedbbcccbdaa";
        int k = 3;

        L1209 l1209 = new L1209();
        System.out.println("l1209.removeDuplicates(s, k) = " + l1209.removeDuplicates(s, k));
    }

    /**
     * 给你一个字符串 s，「k 倍重复项删除操作」将会从 s 中选择 k 个相邻且相等的字母，并删除它们，使被删去的字符串的左侧和右侧连在一起。
     * 你需要对 s 重复进行无限次这样的删除操作，直到无法继续为止。
     * 在执行完所有删除操作后，返回最终得到的字符串。
     * 本题答案保证唯一。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public String removeDuplicates(String s, int k) {
        Stack<Integer[]> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            int index = 1, ch = c - 'a';

            if (!stack.isEmpty() && stack.peek()[0] == ch) {
                index = stack.peek()[1] + 1;
            }

            stack.push(new Integer[]{ch, index});
            if (stack.peek()[1] == k) {
                for (int i = 0; i < k; i++) {
                    stack.pop();
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Integer[] integers : stack) {
            sb.append((char) (integers[0] + 'a'));
        }
        return sb.toString();
    }

}
