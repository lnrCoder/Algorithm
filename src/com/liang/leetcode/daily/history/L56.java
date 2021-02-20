package com.liang.leetcode.daily.history;

import java.util.Arrays;

/**
 * @ClassName: L56
 * @Description: 合并区间
 * @Author: LiaNg
 * @Date: 2020/4/16 18:56
 */
public class L56 {

    public static void main(String[] args) {
        L56 l56 = new L56();
        int[][] intervals = new int[][]{
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18}
        };
        System.out.println("l56.merge(intervals) = " + Arrays.deepToString(l56.merge(intervals)));
    }

    /**
     * 给出一个区间的集合，请合并所有重叠的区间。
     * 示例 1:
     * 输入: [[1,3],[2,6],[8,10],[15,18]]
     * 输出: [[1,6],[8,10],[15,18]]
     * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
     * 示例 2:
     * 输入: [[1,4],[4,5]]
     * 输出: [[1,5]]
     * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/merge-intervals
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0 || intervals[0].length == 0) {
            return intervals;
        }

        Arrays.sort(intervals, (o1, o2) -> (o1[0] - o2[0]));
        int[][] result = new int[intervals.length][intervals[0].length];

        int index = 0;
        int end = 0;
        for (int i = 0; i < intervals.length; i++) {

            int[] curr = new int[2];

            curr[0] = intervals[i][0];
            end = intervals[i][1];
            while (i+1 < intervals.length && end > intervals[i+1][0]){
                i++;
                end = Math.max(intervals[i][1], end);
            }

            curr[1] = end;

            result[index++] = curr;
        }


        return Arrays.copyOfRange(result, 0, index);
    }
}
