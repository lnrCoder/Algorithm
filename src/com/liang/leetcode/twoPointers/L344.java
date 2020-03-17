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
        char[] s = new char[]{'h', 'e', 'l', 'l', 'o'};
        L344 l344 = new L344();
        l344.reverseString(s);
        System.out.println("s = " + Arrays.toString(s));
    }

    /**
     * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
     * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O (1) 的额外空间解决这一问题。
     * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/reverse-string
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;

        char tmp;

        while (left < right) {
//            tmp = s[left];
//            s[left] = s[right];
//            s[right] = tmp;

            s[left] ^= s[right];
            s[right] ^= s[left];
            s[left] ^= s[right];
            left++;
            right--;
        }
    }
}
