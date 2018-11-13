package com.liang.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName L692
 * @description top-k-frequent-words
 * @Author LiaNg
 * @Date 2018/11/13
 */
public class L692 {

    public static void main(String[] args) {

        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        int k = 2;

        L692 l = new L692();
        System.out.println(l.topKFrequent(words, k));

    }

    /**
     * 给一非空的单词列表，返回前 k 个出现次数最多的单词。
     * 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
     */
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> wordMap = new HashMap();
        List<String> resultList = new ArrayList();

        for (String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }

        List<String>[] sortList = new List[words.length + 1];
        for (String key : wordMap.keySet()) {
            int value = wordMap.get(key);
            if (sortList[value] == null) {
                sortList[value] = new ArrayList<>();
            }
            sortList[value].add(key);
        }

        int valueLenght = 0;
        for (int i = sortList.length - 1; i >= 0 && k > 0; i--) {
            if (sortList[i] != null) {
                Collections.sort(sortList[i]);
                for (int j = 0; j < sortList[i].size(); j++) {
                    if (valueLenght == k) {
                        return resultList;
                    }
                    resultList.add(sortList[i].get(j));
                    valueLenght++;
                }
            }
        }

        return resultList;
    }

}
