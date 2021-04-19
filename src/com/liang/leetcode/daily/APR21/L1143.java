package com.liang.leetcode.daily.APR21;

/**
 * 最长公共子序列
 *
 * @author LiaNg
 * @date 2021/4/19 14:51
 */
public class L1143 {

    /**
     * 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
     * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
     * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
     * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
     *  
     * 示例 1：
     * 输入：text1 = "abcde", text2 = "ace"
     * 输出：3
     * 解释：最长公共子序列是 "ace" ，它的长度为 3 。
     * 示例 2：
     * 输入：text1 = "abc", text2 = "abc"
     * 输出：3
     * 解释：最长公共子序列是 "abc" ，它的长度为 3 。
     * 示例 3：
     * 输入：text1 = "abc", text2 = "def"
     * 输出：0
     * 解释：两个字符串没有公共子序列，返回 0 。
     *  
     * 提示：
     * 1 <= text1.length, text2.length <= 1000
     * text1 和 text2 仅由小写英文字符组成。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-common-subsequence
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int longestCommonSubsequence(String text1, String text2) {

        int length1 = text1.length();
        int length2 = text2.length();

        int[][] dp = new int[length1 + 1][length2 + 1];

        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[length1][length2];
    }

    public int longestCommonSubsequence1(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();
        int[] dp = new int[n2 + 1];
        for (int i = 1; i <= n1; i++) {
            int cur = 0;
            for (int j = 1; j <= n2; j++) {
                int leftTop = cur;
                cur = dp[j];//记录j值,作为下个循环的左上值
                dp[j] = text1.charAt(i - 1) == text2.charAt(j - 1) ? leftTop + 1 : Math.max(dp[j - 1], dp[j]);
            }
        }
        return dp[n2];
    }

    public static void main(String[] args) {
        L1143 l1143 = new L1143();
        String text1 = "abcde";
        String text2 = "ace";
        System.out.println("l1143.longestCommonSubsequence(text1, text2) = " + l1143.longestCommonSubsequence(text1, text2));
    }
}
