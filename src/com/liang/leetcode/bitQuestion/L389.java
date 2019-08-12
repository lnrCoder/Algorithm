package com.liang.leetcode.bitQuestion;

/**
 * @ClassName L389
 * @description find-the-difference 找不同
 * @Author LiaNg
 * @Date 2019-08-12
 */
public class L389 {

    public static void main(String[] args) {
        String s = "abcde";
        String t = "cbdafe";
        char theDifference = findTheDifference(s, t);
        System.out.println("theDifference = " + theDifference);
    }

    private static char findTheDifference(String s, String t) {
        int[] result = new int[26];

        for(char word : s.toCharArray()){
            result[word-'a']++;
        }

        for(char word : t.toCharArray()){
            if(result[word-'a']==0){
                return word;
            }else{
                result[word-'a']--;
            }
        }
        return 0;
    }
}
