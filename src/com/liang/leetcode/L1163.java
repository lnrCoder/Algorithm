package com.liang.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName L1163
 * @description last-substring-in-lexicographical-order 按字典排序最后的字串
 * @Author LiaNg
 * @Date 2019-08-23
 */
public class L1163 {

    public static void main(String[] args) {

        String s = "world";

        System.out.println("lastSubstring(s) = " + lastSubstring(s));

    }

    private static String lastSubstring(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }

        char[] sChars = s.toCharArray();

        int index = 0;
        char max = 'a';
        char sam = s.charAt(0);
        boolean same = true;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != sam) {
                same = false;
                break;
            }
        }

        if (same) {
            return s;
        }

        for (char sChar : sChars) {
            if ((sChar - 'a') > index) {
                index = sChar - 'a';
                max = sChar;
            }
        }

        List<Node> list = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == max) {
                list.add((new Node(i, i)));
            }
        }

        if (list.size() == 1) {
            return s.substring(list.get(0).index);
        }

        while (true) {
            char x = 'a';
            for (Node n : list) {
                n.temp += 1;
                if (n.temp < s.length() && s.charAt(n.temp) > x) {
                    x = s.charAt(n.temp);
                }
            }

            List<Node> newList = new ArrayList<>();

            for (Node n : list) {
                if (n.temp < s.length() && s.charAt(n.temp) == x) {
                    newList.add(n);
                }
            }
            if (newList.size() == 1) {
                return s.substring(newList.get(0).index);
            }
            list = newList;
        }
    }

    static class Node{
        int temp;
        int index;

        Node(int temp, int index) {
            this.temp = temp;
            this.index = index;
        }
    }
}
