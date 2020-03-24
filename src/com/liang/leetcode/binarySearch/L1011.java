package com.liang.leetcode.binarySearch;

/**
 * @ClassName: L1011
 * @Description: 在 D 天内送达包裹的能力
 * @Author: LiaNg
 * @Date: 2020/3/24 21:07
 */
public class L1011 {

    public static void main(String[] args) {
        L1011 l1011 = new L1011();
        int[] weight = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int D = 5;
        System.out.println("l1011.shipWithinDays(weight,D) = " + l1011.shipWithinDays(weight, D));
    }

    /**
     * 传送带上的包裹必须在 D 天内从一个港口运送到另一个港口。
     * 传送带上的第 i 个包裹的重量为 weights[i]。每一天，我们都会按给出重量的顺序往传送带上装载包裹。我们装载的重量不会超过船的最大运载重量。
     * 返回能在 D 天内将传送带上的所有包裹送达的船的最低运载能力。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/capacity-to-ship-packages-within-d-days
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int shipWithinDays(int[] weights, int D) {
        int left = 0;
        int right = 50000 * 500;

        int m;

        while (left < right) {
            m = left + (right - left) / 2;

            if (isShip(weights, D, m)) {
                right = m;
            } else {
                left = m + 1;
            }
        }

        return left;
    }

    public boolean isShip(int[] weights, int D, int k) {

        int current = 0;
        int i = 0;

        while (i < weights.length) {
            if (weights[i] > k) {
                return false;
            }
            if (current + weights[i] <= k) {
                current += weights[i];
                i++;
            } else {
                D--;
                current = 0;
            }
        }

        return D > 0;
    }
}
