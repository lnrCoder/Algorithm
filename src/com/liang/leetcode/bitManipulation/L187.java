package com.liang.leetcode.bitManipulation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName L187
 * @description repeated-dna-sequences 重复的DNA序列
 * @Author LiaNg
 * @Date 2019-08-11
 */
public class L187 {

    public static void main(String[] args) {

        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        List<String> repeatedDnaSequences = findRepeatedDnaSequences(s);
        System.out.println("repeatedDnaSequences = " + repeatedDnaSequences);
    }

    private static List<String> findRepeatedDnaSequences(String s) {
        Set<String> allSet = new HashSet<>();
        Set<String> result = new HashSet<>();

        for (int i = 0; i + 9 < s.length(); i++) {
            String str = s.substring(i, i + 10);
            if (!allSet.add(str)) {
                result.add(str);
            }
        }
        return new ArrayList<String>(result);
    }
}
