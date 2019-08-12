package com.liang.leetcode.bitQuestion;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName L401
 * @description binary-watch 二进制手表
 * @Author LiaNg
 * @Date 2019-08-12
 */
public class L401 {

    public static void main(String[] args) {
        int num = 1;
        List<String> strings = readBinaryWatch(num);
        System.out.println("strings = " + strings);
    }

    private static List<String> readBinaryWatch(int num) {
        List<String> time = new ArrayList<>();
        for(int h = 0; h<12; h++){
            for(int m = 0; m<60; m++){
                if(Integer.bitCount(h)+Integer.bitCount(m)==num){
                    time.add(h+":"+ (m<10?"0"+m:m));
                }
            }
        }
        return time;
    }
}
