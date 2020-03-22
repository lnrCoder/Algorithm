package com.liang.leetcode.binarySearch;

/**
 * @ClassName: L744
 * @Description: 寻找比目标字母大的最小字母
 * @Author: LiaNg
 * @Date: 2020/3/22 22:15
 */
public class L744 {

    public static void main(String[] args) {
        L744 l744 = new L744();
        char[] letters = {'m', 'z', 'c', 'f', 'j'};
        char target = 'n';
        System.out.println("l744.nextGreatestLetter1(letters, target) = " + l744.nextGreatestLetter1(letters, target));
        System.out.println("l744.nextGreatestLetter2(letters, target) = " + l744.nextGreatestLetter2(letters, target));
        // 有序数据用二分查找正确，用题目中举的例子就不对了
        System.out.println("l744.nextGreatestLetter3(letters, target) = " + l744.nextGreatestLetter3(letters, target));
    }

    /**
     * 给定一个只包含小写字母的有序数组 letters 和一个目标字母 target，寻找有序数组里面比目标字母大的最小字母。
     * 在比较时，数组里字母的是循环有序的。举个例子：
     * 如果目标字母 target = 'z' 并且有序数组为 letters = ['a', 'b']，则答案返回 'a'。
     * 如果目标字母 target = 'n' 并且有序数组为 letters = ['m', 'z', 'c', 'f', 'j'] ，则答案返回 'z' 。
     */
    public char nextGreatestLetter1(char[] letters, char target) {
        boolean[] seen = new boolean[26];
        for (char c : letters) {
            seen[c - 'a'] = true;
        }

        while (true) {
            target++;
            if (target > 'z') {
                target = 'a';
            }
            if (seen[target - 'a']) {
                return target;
            }
        }
    }

    public char nextGreatestLetter2(char[] letters, char target) {
        for (char c : letters) {
            if (c > target) {
                return c;
            }
        }
        return letters[0];
    }

    public char nextGreatestLetter3(char[] letters, char target) {
        int lo = 0, hi = letters.length;
        while (lo < hi) {
            int mi = lo + (hi - lo) / 2;
            if (letters[mi] <= target) {
                lo = mi + 1;
            } else {
                hi = mi;
            }
        }
        return letters[lo % letters.length];
    }
}
