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

        int[] numbers = {0};
        System.out.println(l.hIndex(numbers));
    }

    /**
     * H指数 II
     */
    public int hIndex(int[] citations) {

        //论文总数
        int length = citations.length;

        if(length == 0 ){
            return 0;
        }

        for (int i = 0; i < citations.length; i++) {
            if(citations[i]>=length-i){
                return length-i;
            }
        }

        int left = 0;
        int right = length-1;

        while (left <= right) {
            int mid =  (left + right)/2;
            if (citations[mid] == length - mid) {
                return length - mid;
            }
            else if (citations[mid] >= length - mid) {
                right = mid - 1;
            } else{
                left = mid + 1;
            }
        }
        return left-1;
    }
}
