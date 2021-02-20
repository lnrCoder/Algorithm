package com.liang.leetcode.daily.history;

import java.util.HashSet;

/**
 * 快乐数
 *
 * @author LiaNg
 * @date 2020/4/30 0:18
 */
public class L202 {

    public static void main(String[] args) {
        L202 l202 = new L202();
        int n = 19;
        System.out.println("l202.isHappy(n) = " + l202.isHappy(n));
    }

    HashSet<Integer> set = new HashSet<>();

    /**
     * 编写一个算法来判断一个数 n 是不是快乐数。
     * 「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。如果 可以变为  1，那么这个数就是快乐数。
     * 如果 n 是快乐数就返回 True ；不是，则返回 False 。
     *  
     * 示例：
     * 输入：19
     * 输出：true
     * 解释：
     * 12 + 92 = 82
     * 82 + 22 = 68
     * 62 + 82 = 100
     * 12 + 02 + 02 = 1
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/happy-number
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public boolean isHappy(int n) {

        int sum = n;
        while (sum != 1 && !set.contains(sum)) {
            set.add(sum);
            sum = getSum(sum);
        }

        return sum == 1;
    }

    public Integer getSum(int n) {
        int sum = 0;

        while (n != 0) {
            sum += Math.pow(n % 10, 2);
            n /= 10;
        }

        return sum;
    }
}
