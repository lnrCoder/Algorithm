package com.liang.leetcode.twoPointers;

/**
 * @ClassName: L345
 * @Description: 反转字符串中的元音字母
 * @Author: LiaNg
 * @Date: 2020/3/17 21:07
 */
public class L345 {

    public static void main(String[] args) {
        L345 l345 = new L345();
        String s = "leetcode";
        System.out.println("l345.reverseVowels(s) = " + l345.reverseVowels(s));
    }

    public String reverseVowels(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        int left = 0;
        int right = s.length() - 1;

        char[] charArray = s.toCharArray();

        while (left < right) {
            if (isVowel(charArray[left]) && isVowel(charArray[right])) {
                charArray[left] ^= charArray[right];
                charArray[right] ^= charArray[left];
                charArray[left] ^= charArray[right];
                left++;
                right--;
            }
            if (!isVowel(charArray[left])) {
                left++;
            }
            if (!isVowel(charArray[right])) {
                right--;
            }
        }

        return String.valueOf(charArray);

    }

    public boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
                ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
    }
}
