package com.liang.leetcode.bitQuestion;

import java.util.Arrays;

/**
 * @ClassName L338
 * @description counting-bits 比特位计数
 * @Author LiaNg
 * @Date 2019-08-12
 */
public class L338 {

    public static void main(String[] args) {
        int num = 5;
        int[] countBits = countBits2(num);
        System.out.println("countBits = " + Arrays.toString(countBits));
    }

    private static int[] countBits(int num) {

        int[] result = new int[num+1];
        for(int i=0; i<=num;i++){
            int count =0;
            int j = i;
            while (j!=0){
                j = j & (j-1);
                count+=1;
            }
            result[i] = count;
        }
        return result;
    }

    private static int[] countBits2(int num) {
        int[] counts = new int[num+1];
        for (int i = 1; i <= num; i++) {
            counts[i] = counts[i & (i - 1)] + 1;
        }
        return counts;
    }
}
