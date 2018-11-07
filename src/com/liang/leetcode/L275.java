package com.liang.leetcode;

import java.util.Calendar;

/**
 * @ClassName L275
 * @description h-index-ii
 * @Author levo
 * @Date 2018/11/7
 */
public class L275 {

    public static void main(String[] args) {
        L275 l = new L275();

        int[] numbers = {0,1,3,5,6};
        System.out.println(l.hIndex(numbers));
    }

    /**
     * H指数 II
     */
    public int hIndex(int[] citations) {

        //论文总数
        int length = citations.length;

        for (int i = 0; i < citations.length; i++) {
            if(citations[i]>=length-i){
                return length-i;
            }
        }

        return 0;
    }
}
