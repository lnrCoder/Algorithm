package com.liang.leetcode.daily;

import java.util.Arrays;

/**
 * 解码异或后的排列
 *
 * @author LiaNg
 * @date 2021/5/11 11:24
 */
public class L1734 {

    /**
     * 给你一个整数数组 perm ，它是前 n 个正整数的排列，且 n 是个 奇数 。
     * 它被加密成另一个长度为 n - 1 的整数数组 encoded ，满足 encoded[i] = perm[i] XOR perm[i + 1] 。比方说，如果 perm = [1,3,2] ，那么 encoded = [2,1] 。
     * 给你 encoded 数组，请你返回原始数组 perm 。题目保证答案存在且唯一。
     *  
     * 示例 1：
     * 输入：encoded = [3,1]
     * 输出：[1,2,3]
     * 解释：如果 perm = [1,2,3] ，那么 encoded = [1 XOR 2,2 XOR 3] = [3,1]
     * 示例 2：
     * 输入：encoded = [6,5,4,6]
     * 输出：[2,4,1,5,3]
     *  
     * 提示：
     * 3 <= n < 105
     * n 是奇数。
     * encoded.length == n - 1
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/decode-xored-permutation
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int[] decode(int[] encoded) {

        int length = encoded.length;
        int[] decode = new int[length + 1];

        int allXOR = 0;
        for (int i = 0; i < length; i += 2) {
            allXOR = allXOR ^ encoded[i];
        }

        int twoStepXOR = 0;
        for (int i = 1; i <= length + 1; i++) {
            twoStepXOR = twoStepXOR ^ i;
        }

        decode[length] = allXOR ^ twoStepXOR;
        for (int i = length - 1; i >= 0; i--) {
            decode[i] = encoded[i] ^ decode[i + 1];
        }

        return decode;
    }

    public static void main(String[] args) {
        L1734 l1734 = new L1734();
        int[] encoded = new int[]{6, 5, 4, 6};
        System.out.println("l1734.decode(encoded) = " + Arrays.toString(l1734.decode(encoded)));
    }
}
