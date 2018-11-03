package com.liang.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName L412
 * @description Fizz Buzz
 * @Author LiaNg
 * @Date 2018/11/3
 */
public class L412 {

    public static void main(String[] args) {
        L412 l = new L412();
        System.out.println(l.fizzBuzz(15));
    }

    /**
     * 写一个程序，输出从 1 到 n 数字的字符串表示。
     * 1. 如果 n 是3的倍数，输出“Fizz”；
     * 2. 如果 n 是5的倍数，输出“Buzz”；
     * 3. 如果 n 同时是3和5的倍数，输出 “FizzBuzz”。
     */
    public List<String> fizzBuzz(int n) {

        List<String> list = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            String value = "";
            if (i % 3 == 0) {
                value = "Fizz";
            }
            if (i % 5 == 0) {
                value = value+"Buzz";
            }
            if("".equals(value)){
                list.add(String.valueOf(i));
            }else{
                list.add(value);
            }
        }

        return list;
    }

}
