package com.liang.leetcode.daily.Mar21;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 删除字符串中的所有相邻重复项
 *
 * @author LiaNg
 * @date 2021/3/9 9:10
 */
public class L1047 {

    /**
     * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
     * 在 S 上反复执行重复项删除操作，直到无法继续删除。
     * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
     *  
     * 示例：
     * 输入："abbaca"
     * 输出："ca"
     * 解释：
     * 例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
     *  
     * 提示：
     * 1 <= S.length <= 20000
     * S 仅由小写英文字母组成。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public String removeDuplicates(String S) {

        char[] charArray = S.toCharArray();

        Deque<Character> deque = new LinkedList<>();

        for (char c : charArray) {

            if (deque.isEmpty()) {
                deque.push(c);
                continue;
            }

            if (deque.peek() == c) {
                while (!deque.isEmpty() && deque.peek() == c) {
                    deque.pop();
                }
            } else {
                deque.push(c);
            }
        }

        StringBuilder builder = new StringBuilder();
        while (!deque.isEmpty()) {
            builder.append(deque.pollLast());
        }

        return builder.toString();
    }

    public String removeDuplicates1(String S) {
        if (S.length() == 1) {
            return S;
        }
        char[] ss = S.toCharArray();
        int index = -1;
        for (char c : ss) {
            if (index != -1 && c == ss[index]) {
                index--;
            } else {
                ++index;
                ss[index] = c;
            }
        }
        return new String(ss, 0, index + 1);
    }

    public static void main(String[] args) {
        L1047 l1047 = new L1047();
        String s = "abbbaca";
        System.out.println("l1047.removeDuplicates(s) = " + l1047.removeDuplicates(s));
        System.out.println("l1047.removeDuplicates1(s) = " + l1047.removeDuplicates1(s));
    }
}
