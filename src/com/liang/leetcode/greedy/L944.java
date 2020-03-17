package com.liang.leetcode.greedy;

/**
 * @ClassName: L944
 * @Description: 删列造序
 * @Author: LiaNg
 * @Date: 2020/3/17 16:10
 */
public class L944 {

    public static void main(String[] args) {
        String[] A = new String[]{"cba", "daf", "ghi"};
        L944 l944 = new L944();
        System.out.println("l944.minDeletionSize(A) = " + l944.minDeletionSize(A));
    }

    /**
     * 给定由 N 个小写字母字符串组成的数组 A，其中每个字符串长度相等。
     * 删除 操作的定义是：选出一组要删掉的列，删去 A 中对应列中的所有字符，形式上，第 n 列为 [A[0][n], A[1][n], ..., A[A.length-1][n]]）。
     * 比如，有 A = ["abcdef", "uvwxyz"]，
     * 要删掉的列为 {0, 2, 3}，删除后 A 为 ["bef", "vyz"]， A 的列分别为 ["b","v"], ["e","y"], ["f","z"]。
     * 你需要选出一组要删掉的列 D，对 A 执行删除操作，使 A 中剩余的每一列都是 非降序 排列的，然后请你返回 D.length 的最小可能值。
     *  
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/delete-columns-to-make-sorted
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int minDeletionSize(String[] A) {
        int ans = 0;

        for (int c = 0; c < A[0].length(); ++c) {
            for (int r = 0; r < A.length - 1; ++r) {
                if (A[r].charAt(c) > A[r + 1].charAt(c)) {
                    ans++;
                    break;
                }
            }
        }

        return ans;
    }
}
