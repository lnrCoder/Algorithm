package com.liang.leetcode;

/**
 * @ClassName L459
 * @description repeated-substring-pattern
 * @Author LiaNg
 * @Date 2019-08-10
 */
public class L459 {

    public static void main(String[] args) {
        boolean abcabc = repeatedSubstringPattern("abcabc");
        System.out.println("abcabc = " + abcabc);
    }

    private static boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        if (len == 0 || len == 1) {
            return false;
        }
        char lastc = s.charAt(len - 1);
        int l = s.lastIndexOf(lastc, len / 2 - 1) + 1;
        for (; l > 0; l = s.lastIndexOf(lastc, l - 2) + 1) {
            if (len % l == 0) {
                String p = s.substring(0, l);
                boolean res = true;
                for (int i = l; i < len; i += l) {
                    if (!s.substring(i, i + l).equals(p)) {
                        res = false;
                        break;
                    }
                }
                if (res) {
                    return true;
                }
            }
        }
        return false;
    }

}
