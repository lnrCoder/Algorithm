package com.liang.leetcode.twoPointers;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: L763
 * @Description: 划分字母区间
 * @Author: LiaNg
 * @Date: 2020/3/19 0:17
 */
public class L763 {

    public static void main(String[] args) {
        L763 l763 = new L763();
        String s = "eaaaabaaec";
        System.out.println("l763.partitionLabels(s) = " + l763.partitionLabels(s));
    }

    /**
     * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一个字母只会出现在其中的一个片段。返回一个表示每个字符串片段的长度的列表。
     * 注意:
     * S 的长度在 [1, 500] 之间。
     * S 只包含小写字母'a' 到'z'。
     */
    public List<Integer> partitionLabels(String S) {

        List<Integer> result = new ArrayList<>();

        int[] lastIndex = new int[26];
        char[] charArray = S.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            lastIndex[charArray[i] - 'a'] = i;
        }

        int j = 0;
        int anchor = 0;
        for (int i = 0; i < S.length(); ++i) {
            j = Math.max(j, lastIndex[S.charAt(i) - 'a']);
            if (i == j) {
                result.add(i - anchor + 1);
                anchor = i + 1;
            }
        }

        return result;
    }
}
