package com.liang.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName L216
 * @description combination-sum-iii
 * @Author LiaNg
 * @Date 2018/11/9
 */
public class L216 {

    public static void main(String[] args) {

        int n = 9, k = 3;

        L216 l = new L216();
        System.out.println(l.combinationSum3(k, n));
    }

    /**
     * @description 找出所有相加之和为 n 的 k 个数的组合。
     * 组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        loop(k, n, 0, list, resultList, 0);
        return resultList;
    }

    public void loop(int k, int n, int sum, List<Integer> list, List<List<Integer>> resultList, int lastValue) {

        if (list.size() == k) {
            return;
        }
        for (int i = 1; i <= 9; i++) {
            if (!list.contains(i)) {
                if (i < lastValue) {
                    continue;
                }
                if (sum + i < n && list.size() < k) {
                    list.add(i);
                    loop(k, n, sum + i, list, resultList, i);
                    list.remove(list.size() - 1);
                } else if (sum + i == n && list.size() == k - 1) {
                    list.add(i);
                    resultList.add(new ArrayList<>(list));
                    list.remove(list.size() - 1);
                }
            }
        }
    }
}
