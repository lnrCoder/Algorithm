package com.liang.leetcode.twoPointers;

import java.util.Arrays;

/**
 * @ClassName: L344
 * @Description: 反转字符串
 * @Author: LiaNg
 * @Date: 2020/3/17 18:37
 */
public class L344 {

    public static void main(String[] args) {
        char[] s = new char[]{'h','e','l','l','o'};
        L344 l344 = new L344();
        l344.reverseString(s);
        System.out.println("s = " + Arrays.toString(s));
    }

    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;

        char tmp;

        while (left < right) {
//            tmp = s[left];
//            s[left] = s[right];
//            s[right] = tmp;

            s[left]^=s[right];
            s[right] ^= s[left];
            s[left] ^= s[right];
            left++;
            right--;
        }
    }
}
