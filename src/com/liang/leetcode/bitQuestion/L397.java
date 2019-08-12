package com.liang.leetcode.bitQuestion;

/**
 * @ClassName L397
 * @description integer-replacement 整数替换
 * @Author LiaNg
 * @Date 2019-08-12
 */
public class L397 {

    public static void main(String[] args) {

        int n = 15;
        int i = integerReplacement(n);
        System.out.println("i = " + i);
    }

    private static int integerReplacement(int n) {
        int count = 0;
        long m = n;
        while(m!=1){
            if(m%2 == 0){
                m>>=1;
            }
            else if(m==3){
                return count+2;
            }
            else if((m&2)==2){
                m+=1;
            }else{
                m-=1;
            }
            count++;
            System.out.println("m = " + m);
        }
        return count;
    }
}
