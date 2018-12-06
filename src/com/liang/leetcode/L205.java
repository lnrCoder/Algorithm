package com.liang.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import javax.management.StringValueExp;

/**
 * @ClassName L205
 * @description isomorphic-strings
 * @Author LiaNg
 * @Date 2018/12/6
 */
public class L205 {

    public static void main(String[] args) {
        String s = "ab";
        String t = "aa";

        L205 l = new L205();
        System.out.println(l.isIsomorphic(s, t));
    }

    public boolean isIsomorphic(String s, String t) {

        if(s.length()==0){
            return true;
        }

        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        int i=0;

        while(i<s.length())
        {
            if(s.indexOf(String.valueOf(sChars[i]))!=t.indexOf(String.valueOf(tChars[i])))
            {
                return false;
            }
            i++;
        }
        return true;
    }
}
