package com.liang.leetcode.daily.Mar21;

import java.util.Arrays;

/**
 * 分割回文串 II
 *
 * @author LiaNg
 * @date 2021/3/8 9:14
 */
public class L132 {

    /**
     * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文。
     * 返回符合要求的 最少分割次数 。
     *  
     * 示例 1：
     * 输入：s = "aab"
     * 输出：1
     * 解释：只需一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。
     * 示例 2：
     * 输入：s = "a"
     * 输出：0
     * 示例 3：
     * 输入：s = "ab"
     * 输出：1
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/palindrome-partitioning-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int minCut(String s) {
        char[] charArray = s.toCharArray();

        int length = charArray.length;

        // 存储 i-j 是否为回文字符串
        boolean[][] g = new boolean[length][length];

        for (boolean[] booleans : g) {
            Arrays.fill(booleans, true);
        }

        for (int i = length-1; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                // 两端相等，中间为回文字符串，则整体也为回文字符串
                g[i][j] = (charArray[i] == charArray[j]) && g[i + 1][j - 1];
            }
        }

        int[] res = new int[length];
        Arrays.fill(res, Integer.MAX_VALUE);

        for (int i = 0; i < length; i++) {

            // 字符串 0-i 为回文字符串
            if (g[0][i]) {
                res[i] = 0;
                continue;
            }

            // 如果 j-i 为回文字符串，切割次数为 0-j 的最小切割次数 +1
            for (int j = 0; j < i; j++) {
                if (g[j + 1][i]) {
                    res[i] = Math.min(res[j] + 1, res[i]);
                }
            }
        }

        return res[length - 1];
    }

    public static void main(String[] args) {
        L132 l132 = new L132();
        String s = "aabaaba";
        System.out.println("l132.minCut(s) = " + l132.minCut(s));
    }
}
