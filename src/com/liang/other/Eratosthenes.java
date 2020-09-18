package com.liang.other;

/**
 * 埃拉托斯特尼筛法，简称埃氏筛或爱氏筛
 *
 * @author LiaNg
 * @date 2020/9/18 9:09
 */
public class Eratosthenes {

    /**
     * 要得到自然数n以内的全部素数，必须把不大于 的所有素数的倍数剔除，剩下的就是素数。
     * 给出要筛数值的范围n，找出以内的素数。先用2去筛，即把2留下，把2的倍数剔除掉；
     * 再用下一个质数，也就是3筛，把3留下，把3的倍数剔除掉；
     * 接下去用下一个质数5筛，把5留下，把5的倍数剔除掉；不断重复下去......。
     */
    public static void main(String[] args) {
        int aa[] = new int[101];
        aa[2] = 0;
        int k = 2, tt = 0;
        while (tt < 101) {
            for (int i = 0; i < aa.length; i++) {
                if (i % k == 0 && i != k) {
                    aa[i] = 1;
                }
            }
            for (int i = 0; i < aa.length; i++) {
                if (i > k & aa[i] == 0) {
                    k = i;
                    break;
                }
            }
            tt++;
        }
        for (int i = 0; i < aa.length; i++) {
            if (aa[i] == 0) {
                System.out.printf(" %d ", i);
            }
        }
    }
}
