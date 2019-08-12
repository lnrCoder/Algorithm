package com.liang.leetcode.hashTable;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName L1002
 * @description find-common-characters 查找常用字符
 * @Author LiaNg
 * @Date 2019-08-12
 */
public class L1002 {

    public static void main(String[] args) {
        String[] A = {"bella","label","roller"};
        List<String> strings = commonChars(A);
        System.out.println("strings = " + strings);
    }

    private static List<String> commonChars(String[] A) {
        List<String> list = new ArrayList<>();
        int[] res = new int[26];

        for(char c: A[0].toCharArray()){
            res[c-'a']++;
        }

        for (String s : A) {
            int[] temp = new int[26];
            for (char c : s.toCharArray()) {
                temp[c - 'a']++;
            }
            for (int j = 0; j < 26; j++) {
                res[j] = Math.min(res[j], temp[j]);
            }
        }

        for(int i = 0; i<res.length; i++){
            if(res[i]>0){
                for(int j = 0; j<res[i]; j++){
                    list.add((char)('a'+i)+"");
                }
            }
        }
        return list;
    }
}
