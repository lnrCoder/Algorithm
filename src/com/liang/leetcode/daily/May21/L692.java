package com.liang.leetcode.daily.May21;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 前K个高频单词
 *
 * @author LiaNg
 * @date 2021/5/20 14:46
 */
public class L692 {

    /**
     * 给一非空的单词列表，返回前 k 个出现次数最多的单词。
     * 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
     * 示例 1：
     * 输入: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
     * 输出: ["i", "love"]
     * 解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
     * 注意，按字母顺序 "i" 在 "love" 之前。
     *  
     * 示例 2：
     * 输入: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
     * 输出: ["the", "is", "sunny", "day"]
     * 解析: "the", "is", "sunny" 和 "day" 是出现次数最多的四个单词，
     * 出现次数依次为 4, 3, 2 和 1 次。
     *  
     * 注意：
     * 假定 k 总为有效值， 1 ≤ k ≤ 集合元素数。
     * 输入的单词均由小写字母组成。
     *  
     * 扩展练习：
     * 尝试以 O(n log k) 时间复杂度和 O(n) 空间复杂度解决。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/top-k-frequent-words
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public List<String> topKFrequent(String[] words, int k) {

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }

        List<String> keyList = new ArrayList<>(map.keySet());

        keyList.sort((o1, o2) -> map.get(o1).equals(map.get(o2)) ? o1.compareTo(o2) : map.get(o2) - map.get(o1));

        return keyList.subList(0, k);
    }

    public static void main(String[] args) {
        L692 l692 = new L692();
        String[] words = new String[]{"i", "love", "leetcode", "i", "love", "coding"};
        int k = 1;
        System.out.println("l692.topKFrequent(words, k) = " + l692.topKFrequent(words, k));
    }
}
