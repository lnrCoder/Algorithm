package com.liang.leetcode.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @ClassName L20
 * @description 有效的括号
 * @Author LiaNg
 * @Date 2019-11-20
 */
public class L20 {

    public static void main(String[] args) {
        String s = "[";
        L20 l20 = new L20();
        System.out.println("l20.isValid(s) = " + l20.isValid(s));
    }

    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     * 有效字符串需满足：
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 注意空字符串可被认为是有效字符串。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/valid-parentheses
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>(3);
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (!map.containsKey(c)) {
                stack.push(c);
            } else if (!stack.empty() && map.get(c).equals(stack.peek())) {
                stack.pop();
            } else {
                return false;
            }
        }

        return stack.empty();
    }

    /**
     * LeetCode 耗时最短解答
     */
    public boolean isValid1(String s) {
        if ("".equals(s)) {
            return true;
        }
        char[] stack = new char[s.length()];
        int stackCur = -1;
        char[] split = s.toCharArray();
        for (char cur : split) {
            if (cur == '{' || cur == '(' || cur == '[') {
                stack[++stackCur] = cur;
            } else if (stackCur == -1
                    || cur == ')' && stack[stackCur--] != '('
                    || cur == ']' && stack[stackCur--] != '['
                    || cur == '}' && stack[stackCur--] != '{') {
                return false;
            }
        }
        return stackCur == -1;
    }
}
