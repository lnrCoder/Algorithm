package com.liang.leetcode.reservoirSampling;

import java.util.Random;

/**
 * 随机数索引
 *
 * @author LiaNg
 * @date 2020/5/26 17:52
 */
public class L398 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 3, 3};
        L398 l398 = new L398(nums);
        System.out.println("l398.pick(3) = " + l398.pick(3));
        System.out.println("l398.pick(3) = " + l398.pick(3));
        System.out.println("l398.pick(3) = " + l398.pick(2));
        System.out.println("l398.pick(3) = " + l398.pick(1));
    }

    /**
     * 给定一个可能含有重复元素的整数数组，要求随机输出给定的数字的索引。 您可以假设给定的数字一定存在于数组中。
     * 注意：
     * 数组大小可能非常大。 使用太多额外空间的解决方案将不会通过测试。
     * 示例:
     * int[] nums = new int[] {1,2,3,3,3};
     * Solution solution = new Solution(nums);
     * // pick(3) 应该返回索引 2,3 或者 4。每个索引的返回概率应该相等。
     * solution.pick(3);
     * // pick(1) 应该返回 0。因为只有nums[0]等于1。
     * solution.pick(1);
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/random-pick-index
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    private int[] nums;

    public L398(int[] nums) {
        this.nums = nums;
    }

    public int pick(int target) {

        Random random = new Random();

        int index = 0;
        int n = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                n++;
                if (random.nextInt() % n == 0) {
                    index = i;
                }
            }
        }

        return index;
    }
}
