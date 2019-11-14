package com.liang.leetcode.stack;

import java.util.Stack;

/**
 * @ClassName L844
 * @description 比较含退格的字符串
 * @Author LiaNg
 * @Date 2019-11-14
 */
public class L844 {

    public static void main(String[] args) {
        String S = "y#fo##f";
        String T = "y#f#o##f";
        System.out.println("backspaceCompare(S,T) = " + backspaceCompare(S, T));
    }

    /**
     * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/backspace-string-compare
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static boolean backspaceCompare(String S, String T) {

        Stack<Character> sStack = new Stack<>();
        Stack<Character> tStack = new Stack<>();

        for (Character c : S.toCharArray()) {
            if (c == '#' && !sStack.empty()) {
                sStack.pop();
            } else if (c != '#') {
                sStack.push(c);
            }
        }

        for (Character c : T.toCharArray()) {
            if (c == '#' && !tStack.empty()) {
                tStack.pop();
            } else if (c != '#') {
                tStack.push(c);
            }
        }

        if (sStack.size() != tStack.size()) {
            System.out.println("sStack = " + sStack.size());
            System.out.println("tStack.size() = " + tStack.size());
            return false;
        }

        while (!sStack.empty()) {
            if (!sStack.pop().equals(tStack.pop())) {
                return false;
            }
        }

        return true;
    }
}
