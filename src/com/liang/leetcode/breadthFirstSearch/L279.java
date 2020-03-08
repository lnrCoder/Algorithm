package com.liang.leetcode.breadthFirstSearch;

/**
 * @ClassName: L279
 * @Description: 完全平方数
 * @Author: LiaNg
 * @Date: 2020/3/8 23:04
 */
public class L279 {

    public static void main(String[] args) {
        L279 l279 = new L279();
        int n = 10;

        System.out.println("l279.numSquares(n) = " + l279.numSquares(n));
    }

    int ans = Integer.MAX_VALUE;

    /**
     * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/perfect-squares
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int numSquares(int n) {

        int x = (int) Math.sqrt(n);
        int[] nums = new int[x + 1];
        for (int i = 0; i <= Math.sqrt(n); i++) {
            nums[i] = i * i;
        }

        checkNum(nums, n, x, 0);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public void checkNum(int[] nums, int n, int index, int count) {

        if (index < 0) {
            return;
        }

        for (int i = n / nums[index]; i >= 0; i--) {
            int nn = n - i * nums[index];
            int nc = count + i;
            if (nn == 0) {
                ans = Math.min(ans, nc);
                break;
            }
            if (nc + 1 >= ans) {
                break;
            }
            checkNum(nums, nn, index - 1, nc);
        }
    }
}
