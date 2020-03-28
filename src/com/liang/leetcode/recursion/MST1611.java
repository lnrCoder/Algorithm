package com.liang.leetcode.recursion;

import java.util.Arrays;

/**
 * @ClassName: MST1611
 * @Description: 跳水板
 * @Author: LiaNg
 * @Date: 2020/3/28 16:06
 */
public class MST1611 {

    public static void main(String[] args) {
        MST1611 mst1611 = new MST1611();
        int shorter = 1;
        int longer = 2;
        int k = 5;
        System.out.println("mst1611.divingBoard(shorter,longer,k) = " + Arrays.toString(mst1611.divingBoard(shorter, longer, k)));
    }

    /**
     * 你正在使用一堆木板建造跳水板。有两种类型的木板，其中长度较短的木板长度为 shorter，长度较长的木板长度为 longer。你必须正好使用 k 块木板。编写一个方法，生成跳水板所有可能的长度。
     * 返回的长度需要从小到大排列。
     * 提示：
     * 0 < shorter <= longer
     * 0 <= k <= 100000
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/diving-board-lcci
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int[] divingBoard(int shorter, int longer, int k) {
        int[] result;

        if (k == 0) {
            result = new int[0];
            return result;
        }

        if (shorter == longer) {
            result = new int[]{k * shorter};
            return result;
        }

        if (k == 1) {
            result = new int[]{shorter, longer};
            return result;
        }

        result = new int[k + 1];
        for (int i = 0; i <= k; i++) {
            int res = shorter * (k - i) + longer * i;
            result[i] = res;
        }

        return result;
    }
}
