package com.liang.leetcode.hashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName L1078
 * @description occurrences-after-bigram Bigram 分词
 * @Author LiaNg
 * @Date 2019-08-12
 */
public class L1078 {

    public static void main(String[] args) {
        String text = "alice is a good girl she is a good student", first = "a", second = "good";
        String[] ocurrences = findOcurrences(text, first, second);
        System.out.println("ocurrences = " + Arrays.toString(ocurrences));

    }

    private static String[] findOcurrences(String text, String first, String second) {

        HashMap<Integer, String> map = new HashMap<>();
        String[] strings = text.split(" ");

        for (int i = 0; i < strings.length; i++) {
            map.put(i, strings[i]);
        }

        List<String> resultList = new ArrayList<>();
        for (int i = 0; i < strings.length - 1; i++) {
            if (first.equals(map.get(i)) && second.equals(map.get(i + 1))) {
                resultList.add(map.get(i + 2));
            }
        }

        return resultList.toArray(new String[0]);
    }
}
