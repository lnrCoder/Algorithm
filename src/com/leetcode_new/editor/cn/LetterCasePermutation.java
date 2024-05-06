package com.leetcode_new.editor.cn;

//给定一个字符串 s ，通过将字符串 s 中的每个字母转变大小写，我们可以获得一个新的字符串。 
//
// 返回 所有可能得到的字符串集合 。以 任意顺序 返回输出。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "a1b2"
//输出：["a1b2", "a1B2", "A1b2", "A1B2"]
// 
//
// 示例 2: 
//
// 
//输入: s = "3z4"
//输出: ["3z4","3Z4"]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length <= 12 
// s 由小写英文字母、大写英文字母和数字组成 
// 
//
// Related Topics 位运算 字符串 回溯 👍 445 👎 0


import java.util.ArrayList;
import java.util.List;

/**
 * 784 字母大小写全排列
 *
 * @author shang.liang
 * @date 2022-10-30 11:03:45
 */
public class LetterCasePermutation {
    public static void main(String[] args) {
        Solution soution = new LetterCasePermutation().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        char[] cs;
        List<String> ans = new ArrayList<>();

        public List<String> letterCasePermutation(String s) {
            cs = s.toCharArray();
            dfs(0, s.length(), new char[s.length()]);
            return ans;
        }

        void dfs(int idx, int n, char[] cur) {
            if (idx == n) {
                ans.add(String.valueOf(cur));
                return;
            }
            cur[idx] = cs[idx];
            dfs(idx + 1, n, cur);
            if (Character.isLetter(cs[idx])) {
                cur[idx] = (char) (cs[idx] ^ 32);
                dfs(idx + 1, n, cur);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
