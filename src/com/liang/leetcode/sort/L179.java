package com.liang.leetcode.sort;

import java.util.Arrays;

/**
 * @ClassName: L179
 * @Description: 最大数
 * @Author: LiaNg
 * @Date: 2020/1/6 12:03
 */
public class L179 {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 30, 34, 5, 9};
        L179 l179 = new L179();
        System.out.println("l179.largestNumber(nums) = " + l179.largestNumber(nums));
    }

    private StringBuilder res;

    /**
     * 给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/largest-number
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public String largestNumber(int[] nums) {
        res = new StringBuilder();
        Arrays.stream(nums).boxed().map(x -> x.toString()).sorted((x, y) -> (y + x).compareTo(x + y)).forEach(x -> res.append(x));
        return res.charAt(0) == '0' ? "0" : res.toString();
    }
}
