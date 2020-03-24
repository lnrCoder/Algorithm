package com.liang.leetcode.binarySearch;

import java.util.Arrays;

/**
 * @ClassName: L1111
 * @Description: 有效括号的嵌套深度
 * @Author: LiaNg
 * @Date: 2020/3/24 18:13
 */
public class L1111 {

    public static void main(String[] args) {
        L1111 l1111 = new L1111();
        String seq = "(()(()()))";
        System.out.println("l1111.maxDepthAfterSplit(seq) = " + Arrays.toString(l1111.maxDepthAfterSplit(seq)));
    }

    /**
     * 有效括号字符串 仅由 "(" 和 ")" 构成，并符合下述几个条件之一：
     * 空字符串
     * 连接，可以记作 AB（A 与 B 连接），其中 A 和 B 都是有效括号字符串
     * 嵌套，可以记作 (A)，其中 A 是有效括号字符串
     * 类似地，我们可以定义任意有效括号字符串 s 的 嵌套深度 depth(S)：
     * s 为空时，depth("") = 0
     * s 为 A 与 B 连接时，depth(A + B) = max(depth(A), depth(B))，其中 A 和 B 都是有效括号字符串
     * s 为嵌套情况，depth("(" + A + ")") = 1 + depth(A)，其中 A 是有效括号字符串
     * 例如：""，"()()"，和 "()(()())" 都是有效括号字符串，嵌套深度分别为 0，1，2，而 ")(" 和 "(()" 都不是有效括号字符串。
     *  
     * 给你一个有效括号字符串 seq，将其分成两个不相交的子序列 A 和 B，且 A 和 B 满足有效括号字符串的定义（注意：A.length + B.length = seq.length）。
     * 现在，你需要从中选出 任意 一组有效括号字符串 A 和 B，使 max(depth(A), depth(B)) 的可能取值最小。
     * 返回长度为 seq.length 答案数组 answer ，选择 A 还是 B 的编码规则是：如果 seq[i] 是 A 的一部分，那么 answer[i] = 0。否则，answer[i] = 1。即便有多个满足要求的答案存在，你也只需返回 一个。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/maximum-nesting-depth-of-two-valid-parentheses-strings
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int[] maxDepthAfterSplit(String seq) {
        int[] res = new int[seq.length()];
        for (int i = 0, cnt = 0; i < res.length; ++i) {
            if (seq.charAt(i) == '(') {
                res[i] = cnt++ & 1;
            } else {
                res[i] = --cnt & 1;
            }
        }
        return res;
    }
}
