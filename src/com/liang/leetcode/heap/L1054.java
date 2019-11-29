package com.liang.leetcode.heap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @ClassName L1054
 * @description 距离相等的条形码
 * @Author LiaNg
 * @Date 2019-11-29
 */
public class L1054 {

    public static void main(String[] args) {
        int[] barcodes = new int[]{1, 1, 1, 1, 2, 2, 3, 3, 1};
        L1054 l1054 = new L1054();
        System.out.println("l1054.rearrangeBarcodes(barcodes) = " + Arrays.toString(l1054.rearrangeBarcodes(barcodes)));
    }

    /**
     * 在一个仓库里，有一排条形码，其中第 i 个条形码为 barcodes[i]。
     * 请你重新排列这些条形码，使其中两个相邻的条形码 不能 相等。 你可以返回任何满足该要求的答案，此题保证存在答案。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/distant-barcodes
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int[] rearrangeBarcodes(int[] barcodes) {
        int[] result = new int[barcodes.length];

        Map<Integer, Integer> map = new HashMap<>();
        for (int barcode : barcodes) {
            map.put(barcode, map.getOrDefault(barcode, 0) + 1);
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(map.size(), (o1, o2) -> map.get(o2) - map.get(o1));
        for (Integer integer : map.keySet()) {
            queue.offer(integer);
        }

        int index = 0;
        while (index < barcodes.length) {
            if (map.get(queue.peek()) > 0) {
                result[index] = queue.peek();
            } else {
                queue.poll();
                result[index] = queue.peek();
            }
            map.put(queue.peek(), map.getOrDefault(queue.peek(), 0) - 1);
            index += 2;
        }
        index = 1;
        while (index < barcodes.length) {
            if (map.get(queue.peek()) > 0) {
                result[index] = queue.peek();
            } else {
                queue.poll();
                result[index] = queue.peek();
            }
            map.put(queue.peek(), map.getOrDefault(queue.peek(), 0) - 1);
            index += 2;
        }

        return result;
    }

    /**
     * LeetCode 耗时最短解答
     */
    public int[] rearrangeBarcodes1(int[] barcodes) {
        int[] cnt = new int[10001];
        int max = 0;
        for (int i : barcodes) {
            cnt[i]++;
            if (cnt[i] > cnt[max]) {
                max = i;
            }
        }
        int[] res = new int[barcodes.length];
        int idx = 0;
        for (int i = 0; i < cnt[max]; i++) {
            res[idx] = max;
            idx += 2;
        }
        cnt[max] = 0;
        for (int i = 0; i < 10001; ) {
            if (cnt[i] == 0) {
                i++;
                continue;
            }
            if (idx >= barcodes.length) {
                idx = 1;
            }
            res[idx] = i;
            cnt[i]--;
            idx += 2;
        }
        return res;
    }
}
