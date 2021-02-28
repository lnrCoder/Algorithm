package com.liang.leetcode.daily.Feb21;

/**
 * 单调数列
 *
 * @author LiaNg
 * @date 2021/2/28 11:34
 */
public class L896 {

    public static void main(String[] args) {
        L896 l896 = new L896();
        int[] A1 = new int[]{1, 2, 2, 3};
        int[] A2 = new int[]{6, 5, 4, 4};
        System.out.println("l896.isMonotonic(A1) = " + l896.isMonotonic(A1));
        System.out.println("l896.isMonotonic(A2) = " + l896.isMonotonic(A2));
    }

    /**
     * 如果数组是单调递增或单调递减的，那么它是单调的。
     * 如果对于所有 i <= j，A[i] <= A[j]，那么数组 A 是单调递增的。 如果对于所有 i <= j，A[i]> = A[j]，那么数组 A 是单调递减的。
     * 当给定的数组 A 是单调数组时返回 true，否则返回 false。
     *  
     * 示例 1：
     * 输入：[1,2,2,3]
     * 输出：true
     * 示例 2：
     * 输入：[6,5,4,4]
     * 输出：true
     * 示例 3：
     * 输入：[1,3,2]
     * 输出：false
     * 示例 4：
     * 输入：[1,2,4,5]
     * 输出：true
     * 示例 5：
     * 输入：[1,1,1]
     * 输出：true
     *  
     * 提示：
     * 1 <= A.length <= 50000
     * -100000 <= A[i] <= 100000
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/monotonic-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public boolean isMonotonic(int[] A) {

        if (A.length <= 2) {
            return true;
        }

        int m = 0;
        int s = 0;

        for (int i = 1; i < A.length; i++) {

            if (A[i] == A[i - 1]) {
                continue;
            }

            if (A[i] > A[i - 1]) {
                m++;
            } else {
                s++;
            }

            if (s != 0 && m != 0) {
                return false;
            }
        }

        return true;
    }
}
