package com.liang.leetcode.daily.APR21;

/**
 * 平方数之和
 *
 * @author LiaNg
 * @date 2021/4/28 9:08
 */
public class L633 {

    /**
     * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c 。
     *  
     * 示例 1：
     * 输入：c = 5
     * 输出：true
     * 解释：1 * 1 + 2 * 2 = 5
     * 示例 2：
     * 输入：c = 3
     * 输出：false
     * 示例 3：
     * 输入：c = 4
     * 输出：true
     * 示例 4：
     * 输入：c = 2
     * 输出：true
     * 示例 5：
     * 输入：c = 1
     * 输出：true
     *  
     * 提示：
     * 0 <= c <= 231 - 1
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/sum-of-square-numbers
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public boolean judgeSquareSum(int c) {
        int left = 0;
        int right = (int) Math.sqrt(c);

        int sum;
        while (left <= right) {
            sum = left * left + right * right;
            if (sum == c) {
                return true;
            }
            if (sum > c) {
                right--;
            }else{
                left++;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        L633 l633 = new L633();
        int c = 25;
        System.out.println("l633.judgeSquareSum(c) = " + l633.judgeSquareSum(c));
    }
}
