package com.liang.leetcode.breadthFirstSearch;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName: L1298
 * @Description: 你能从盒子里获得的最大糖果数
 * @Author: LiaNg
 * @Date: 2020/3/9 15:05
 */
public class L1298 {

    public static void main(String[] args) {
        L1298 l1298 = new L1298();
        int[] status = new int[]{1, 0, 1, 0};
        int[] candies = new int[]{7, 5, 4, 100};
        int[][] keys = new int[][]{{}, {}, {1}, {}};
        int[][] containedBoxes = new int[][]{{1, 2}, {3}, {}, {}};
        int[] initialBoxes = {0};
        System.out.println("l1298.maxCandies(status,candies,keys,containedBoxes,initialBoxes) = " + l1298.maxCandies(status, candies, keys, containedBoxes, initialBoxes));
    }

    /**
     * 给你 n 个盒子，每个盒子的格式为 [status, candies, keys, containedBoxes] ，其中：
     * 状态字 status[i]：整数，如果 box[i] 是开的，那么是 1 ，否则是 0 。
     * 糖果数 candies[i]: 整数，表示 box[i] 中糖果的数目。
     * 钥匙 keys[i]：数组，表示你打开 box[i] 后，可以得到一些盒子的钥匙，每个元素分别为该钥匙对应盒子的下标。
     * 内含的盒子 containedBoxes[i]：整数，表示放在 box[i] 里的盒子所对应的下标。
     * 给你一个 initialBoxes 数组，表示你现在得到的盒子，你可以获得里面的糖果，也可以用盒子里的钥匙打开新的盒子，还可以继续探索从这个盒子里找到的其他盒子。
     * 请你按照上述规则，返回可以获得糖果的 最大数目 。
     *  
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/maximum-candies-you-can-get-from-boxes
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {

        int result = 0;

        HashSet<Integer> havaBox = new HashSet<>();

        HashSet<Integer> havaKey = new HashSet<>();

        boolean[] openBox = new boolean[status.length];

        Queue<Integer> queue = new LinkedList<>();

        for (int initialBox : initialBoxes) {
            havaBox.add(initialBox);
            if (openBox[initialBox]) {
                continue;
            }
            if (status[initialBox] == 1) {
                openBox[initialBox] = true;
                queue.offer(initialBox);
            }
        }

        while (!queue.isEmpty()) {
            int num = queue.poll();
            result += candies[num];

            for (int key : keys[num]) {
                havaKey.add(key);
                if (openBox[key]) {
                    continue;
                }
                if (havaBox.contains(key)) {
                    openBox[key] = true;
                    queue.offer(key);
                }
            }

            for (int containedBox : containedBoxes[num]) {
                havaBox.add(containedBox);
                if (openBox[containedBox]) {
                    continue;
                }

                if (!openBox[containedBox] && (status[containedBox] == 1 || (havaKey.contains(containedBox)))) {
                    openBox[containedBox] = true;
                    queue.offer(containedBox);
                }
            }
        }

        return result;
    }
}
