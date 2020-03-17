package com.liang.leetcode.daily;

import java.util.Arrays;

/**
 * @ClassName: L1160
 * @Description: 拼写单词
 * @Author: LiaNg
 * @Date: 2020/3/17 15:11
 */
public class L1160 {

    public static void main(String[] args) {
        String[] words = {"cat", "bt", "hat", "tree"};
        String chars = "atach";
        L1160 l1160 = new L1160();
        System.out.println("l1160.countCharacters(words,chars) = " + l1160.countCharacters(words, chars));
    }

    /**
     * 给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。
     * 假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。
     * 注意：每次拼写时，chars 中的每个字母都只能用一次。
     * 返回词汇表 words 中你掌握的所有单词的 长度之和。
     *  
     * 提示：
     * 1 <= words.length <= 1000
     * 1 <= words[i].length, chars.length <= 100
     * 所有字符串中都仅包含小写英文字母
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/find-words-that-can-be-formed-by-characters
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int countCharacters(String[] words, String chars) {

        int result = 0;

        int[] intArr = new int[26];
        char a = 'a';

        Arrays.fill(intArr, 0);

        for (char c : chars.toCharArray()) {
            intArr[c - a]++;
        }

        int[] countArr = new int[26];

        forout1:
        for (String word : words) {
            System.arraycopy(intArr, 0, countArr, 0, 26);
            for (char c : word.toCharArray()) {
                if (--countArr[c - a] < 0) {
                    continue forout1;
                }
            }
            result += word.length();
        }
        return result;
    }
}
