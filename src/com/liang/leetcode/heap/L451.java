package com.liang.leetcode.heap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @ClassName L451
 * @description 根据字符出现频率排序
 * @Author LiaNg
 * @Date 2019-11-27
 */
public class L451 {

    public static void main(String[] args) {
        String s = "tree";
        L451 l451 = new L451();
        System.out.println("l451.frequencySort(s) = " + l451.frequencySort(s));
    }

    /**
     * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/sort-characters-by-frequency
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public String frequencySort(String s) {

        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Character> pq = new PriorityQueue<>((o1, o2) -> map.get(o2) - map.get(o1));

        for (Character character : map.keySet()) {
            pq.offer(character);
        }

        StringBuilder result = new StringBuilder();
        while (!pq.isEmpty()) {
            Character character = pq.poll();
            for (int i = 0; i < map.get(character); i++) {
                result.append(character);
            }
        }

        return result.toString();
    }

    /**
     * LeetCode 耗时最短解答
     */
    public String frequencySort1(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        int[] freq = new int[256];
        char[] chs = s.toCharArray();
        for (char ch : chs) {
            freq[ch]++;
        }
        int[] copy = freq.clone();
        Arrays.sort(freq);
        char[] rets = new char[chs.length];
        int cnt = 0;
        for (int i = freq.length - 1; i >= 0; i--) {
            if (freq[i] == 0) {
                return new String(rets);
            }
            for (int j = 0; j < copy.length; j++) {
                if (copy[j] != freq[i]) {
                    continue;
                }
                while (copy[j]-- > 0) {
                    rets[cnt++] = (char) j;
                }
            }
        }
        return new String(rets);
    }

}
