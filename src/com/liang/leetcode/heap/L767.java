package com.liang.leetcode.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @ClassName L767
 * @description 重构字符串
 * @Author LiaNg
 * @Date 2019-11-29
 */
public class L767 {

    public static void main(String[] args) {
        String s = "aabab";
        L767 l767 = new L767();
        System.out.println("l767.reorganizeString(s) = " + l767.reorganizeString(s));
    }

    /**
     * 给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
     * 若可行，输出任意可行的结果。若不可行，返回空字符串。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/reorganize-string
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public String reorganizeString(String S) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : S.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Character> queue = new PriorityQueue<>(map.size(), (o1, o2) -> map.get(o2) - map.get(o1));
        for (Character character : map.keySet()) {
            queue.offer(character);
        }

        if (map.get(queue.peek()) > (S.length() + 1) >> 1) {
            return "";
        }

        char[] result = new char[S.length()];

        int index = 0;
        boolean flag = true;
        while (flag || index < S.length()) {
            if (map.get(queue.peek()) > 0) {
                result[index] = queue.peek();
            } else {
                queue.poll();
                result[index] = queue.peek();
            }
            map.put(queue.peek(), map.getOrDefault(queue.peek(), 1) - 1);
            index += 2;
            if (index >= S.length() && flag) {
                flag = false;
                index = 1;
            }
        }
        return String.valueOf(result);
    }

    /**
     * LeetCode 耗时最短解答
     */
    public String reorganizeString1(String S) {
        if (S == null || S.length() == 0) {
            return "";
        }
        //词频统计
        int[] count = new int[26];
        for (char c : S.toCharArray()) {
            count[c - 'a']++;
        }
        //寻找最大频率的字母
        int maxCount = 0;
        char letter = 0;
        for (int i = 0; i < 26; i++) {
            if (maxCount < count[i]) {
                maxCount = count[i];
                letter = (char) ('a' + i);
            }
        }
        //如果最大频率大于一半+1，则无法完成任务
        if (maxCount > (1 + S.length()) / 2) {
            return "";
        }

        //结果集
        char[] res = new char[S.length()];
        //index 维护下一个应该插入的位置
        //隔空插入最大频率字母
        int index = getResult(count, res, 0, letter);

        //插入其他字母
        for (int i = 0; i < 26; i++) {
            index = getResult(count, res, index, (char) ('a' + i));
        }
        return new String(res);

    }

    private int getResult(int[] count, char[] res, int index, char letter) {
        int i = letter - 'a';
        while (count[i] > 0) {
            if (index >= res.length) {
                index = 1;
            }
            res[index] = letter;
            count[i]--;
            index += 2;
        }
        return index;
    }
}
