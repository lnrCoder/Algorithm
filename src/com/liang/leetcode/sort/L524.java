package com.liang.leetcode.sort;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName: L524
 * @Description: 通过删除字母匹配到字典里最长单词
 * @Author: LiaNg
 * @Date: 2019/12/20 17:43
 */
public class L524 {

    public static void main(String[] args) {
        String s = "abpcplea";
        List<String> list = new ArrayList<>();
        list.add("ale");
        list.add("apple");
        list.add("monkey");
        list.add("plea");

        L524 l524 = new L524();
        System.out.println("l524.findLongestWord(s, list) = " + l524.findLongestWord(s, list));
    }

    /**
     * 给定一个字符串和一个字符串字典，找到字典里面最长的字符串，该字符串可以通过删除给定字符串的某些字符来得到。如果答案不止一个，返回长度最长且字典顺序最小的字符串。如果答案不存在，则返回空字符串。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-word-in-dictionary-through-deleting
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public String findLongestWord(String s, List<String> d) {

        String result = "";
        int maxLength = 0;

        Set<String> strSet = new HashSet<>();
        for (int i = 0; i < (1 << s.length()); i++) {

            StringBuilder tmpStr = new StringBuilder();
            for (int j = 0; j < s.length(); j++) {
                if (((i >> j) & 1) != 0) {
                    tmpStr.append(s.charAt(j));
                }
            }
            strSet.add(tmpStr.toString());
        }

        for (String s1 : d) {
            if (!strSet.contains(s1)) {
                continue;
            }
            if (maxLength < s1.length() || (maxLength == s1.length() && s1.compareTo(result) < 0)) {
                maxLength = s1.length();
                result = s1;
            }
        }

        return result;
    }
}
