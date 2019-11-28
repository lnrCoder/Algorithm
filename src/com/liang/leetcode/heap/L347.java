package com.liang.leetcode.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @ClassName L347
 * @description 前 K 个高频元素
 * @Author LiaNg
 * @Date 2019-11-28
 */
public class L347 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
        int k = 2;
        L347 l347 = new L347();
        System.out.println("l347.topKFrequent(nums,k) = " + l347.topKFrequent(nums, k));
    }

    /**
     * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/top-k-frequent-elements
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(k, (o1, o2) -> map.get(o1) - map.get(o2));

        for (Integer integer : map.keySet()) {
            queue.offer(integer);
            if (queue.size() > k) {
                queue.poll();
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            result.add(queue.poll());
        }
        Collections.reverse(result);

        return result;
    }

    /**
     * LeetCode 耗时最短解答
     */
    public List<Integer> topKFrequent1(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new ArrayList();
        }
        ArrayList<Integer> countList = new ArrayList<Integer>();

        List<Integer> res = new ArrayList();
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        if (nums.length == 1) {
            res.add(nums[0]);
            return res;
        }

        Arrays.sort(nums);

        int count = 1;
        int start = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (start != nums[i]) {

                ArrayList<Integer> itemList = map.get(count);
                if (itemList == null) {
                    countList.add(count);
                    ArrayList<Integer> numberList = new ArrayList<Integer>();
                    numberList.add(start);
                    map.put(count, numberList);
                } else {
                    itemList.add(start);
                }
                start = nums[i];
                count = 0;
            }
            count++;
        }
        ArrayList<Integer> itemList = map.get(count);
        if (itemList == null) {
            countList.add(count);
            ArrayList<Integer> numberList = new ArrayList<Integer>();
            numberList.add(start);
            map.put(count, numberList);
        } else {
            itemList.add(start);
        }
        countList.sort(null);
        int idx = countList.size() - 1;
        while (k > 0) {
            for (int j : map.get(countList.get(idx))) {
                res.add(j);
                k--;
                if (k <= 0) {
                    break;
                }
            }
            idx--;
        }

        return res;
    }

}
