package com.leetcode.editor.cn;

//给你一个以字符串形式表述的 布尔表达式（boolean） expression，返回该式的运算结果。 
//
// 有效的表达式需遵循以下约定： 
//
// 
// "t"，运算结果为 True 
// "f"，运算结果为 False 
// "!(expr)"，运算过程为对内部表达式 expr 进行逻辑 非的运算（NOT） 
// "&(expr1,expr2,...)"，运算过程为对 2 个或以上内部表达式 expr1, expr2, ... 进行逻辑 与的运算（AND） 
// "|(expr1,expr2,...)"，运算过程为对 2 个或以上内部表达式 expr1, expr2, ... 进行逻辑 或的运算（OR） 
// 
//
// 
//
// 示例 1： 
//
// 输入：expression = "!(f)"
//输出：true
// 
//
// 示例 2： 
//
// 输入：expression = "|(f,t)"
//输出：true
// 
//
// 示例 3： 
//
// 输入：expression = "&(t,f)"
//输出：false
// 
//
// 示例 4： 
//
// 输入：expression = "|(&(t,f,t),!(t))"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= expression.length <= 20000 
// expression[i] 由 {'(', ')', '&', '|', '!', 't', 'f', ','} 中的字符组成。 
// expression 是以上述形式给出的有效表达式，表示一个布尔值。 
// 
//
// Related Topics 栈 递归 字符串 👍 112 👎 0


import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1106 解析布尔表达式
 *
 * @author shang.liang
 * @date 2022-11-05 12:10:53
 */
public class ParsingABooleanExpression {
    public static void main(String[] args) {
        Solution soution = new ParsingABooleanExpression().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean parseBoolExpr(String expression) {
            Deque<Character> stack = new ArrayDeque<Character>();
            int n = expression.length();
            for (int i = 0; i < n; i++) {
                char c = expression.charAt(i);
                if (c == ',') {
                    continue;
                } else if (c != ')') {
                    stack.push(c);
                } else {
                    int t = 0, f = 0;
                    while (stack.peek() != '(') {
                        char val = stack.pop();
                        if (val == 't') {
                            t++;
                        } else {
                            f++;
                        }
                    }
                    stack.pop();
                    char op = stack.pop();
                    switch (op) {
                        case '!':
                            stack.push(f == 1 ? 't' : 'f');
                            break;
                        case '&':
                            stack.push(f == 0 ? 't' : 'f');
                            break;
                        case '|':
                            stack.push(t > 0 ? 't' : 'f');
                            break;
                        default:
                    }
                }
            }
            return stack.pop() == 't';
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
