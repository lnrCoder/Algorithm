package com.liang.leetcode.daily;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName: L994
 * @Description: 腐烂的橘子 每日一练-2020.3.4
 * @Author: LiaNg
 * @Date: 2020/3/4 18:52
 */
public class L994 {

    public static void main(String[] args) {
        L994 l994 = new L994();

        int[][] grid = new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        System.out.println("l994.orangesRotting(grid) = " + l994.orangesRotting(grid));
    }

    public static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    /**
     * 在给定的网格中，每个单元格可以有以下三个值之一：
     * 值 0 代表空单元格；
     * 值 1 代表新鲜橘子；
     * 值 2 代表腐烂的橘子。
     * 每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。
     * 返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1。
     *  
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/rotting-oranges
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int orangesRotting(int[][] grid) {

        int R = grid.length;
        int C = grid[0].length;
        int result = 0;
        int count = 0;

        Queue<int[]> queue = new LinkedList<>();

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (grid[r][c] == 1) {
                    count++;
                } else if (grid[r][c] == 2) {
                    queue.add(new int[]{r, c});
                }
            }
        }

        while (count > 0 && !queue.isEmpty()) {
            result++;
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                int[] now = queue.poll();
                int r = now[0];
                int c = now[1];
                for (int[] ints : dir) {
                    if (0 <= r + ints[0] && r + ints[0] < R && 0 <= c + ints[1] && c + ints[1] < C) {
                        if (grid[r + ints[0]][c + ints[1]] == 1) {
                            grid[r + ints[0]][c + ints[1]] = 2;
                            count--;
                            queue.add(new int[]{r + ints[0], c + ints[1]});
                        }
                    }
                }
            }
        }

        if (count > 0) {
            return -1;
        }else{
            return result;
        }
    }
}
