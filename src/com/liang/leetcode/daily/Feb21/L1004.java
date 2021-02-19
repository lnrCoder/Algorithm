package com.liang.leetcode.daily.Feb21;

/**
 * 最大连续1的个数 III
 *
 * @author LiaNg
 * @date 2021/2/19 14:17
 */
public class L1004 {
    public static void main(String[] args) {
        L1004 l1004 = new L1004();
        int[] A = new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
        int K = 3;
        System.out.println("l1004.longestOnes(A,K) = " + l1004.longestOnes(A, K));
    }

    /**
     * 给定一个由若干 0 和 1 组成的数组 A，我们最多可以将 K 个值从 0 变成 1 。
     * 返回仅包含 1 的最长（连续）子数组的长度。
     *  
     * 示例 1：
     * 输入：A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
     * 输出：6
     * 解释：
     * [1,1,1,0,0,1,1,1,1,1,1]
     * 粗体数字从 0 翻转到 1，最长的子数组长度为 6。
     * 示例 2：
     * 输入：A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
     * 输出：10
     * 解释：
     * [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
     * 粗体数字从 0 翻转到 1，最长的子数组长度为 10。
     *  
     * 提示：
     * 1 <= A.length <= 20000
     * 0 <= K <= A.length
     * A[i] 为 0 或 1 
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/max-consecutive-ones-iii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int longestOnes(int[] A, int K) {

        int length = A.length;
        int left = 0;
        int right = 0;
        int zeroNum = 0;
        int result = 0;

        while (right < length) {

            if (A[right] == 0) {
                zeroNum++;
            }

            while (zeroNum > K) {
                if (A[left++] == 0) {
                    zeroNum--;
                }
            }

            result = Math.max(result, right - left + 1);
            right++;
        }

        return result;
    }
}
