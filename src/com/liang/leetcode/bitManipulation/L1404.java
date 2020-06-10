package com.liang.leetcode.bitManipulation;

/**
 * 将二进制表示减到 1 的步骤数
 *
 * @author LiaNg
 * @date 2020/6/10 11:34
 */
public class L1404 {

    public static void main(String[] args) {
        L1404 l1404 = new L1404();
        String s = "1101";
        System.out.println("l1404.numSteps(s) = " + l1404.numSteps(s));
    }

    /**
     * 给你一个以二进制形式表示的数字 s 。请你返回按下述规则将其减少到 1 所需要的步骤数：
     * 如果当前数字为偶数，则将其除以 2 。
     * 如果当前数字为奇数，则将其加上 1 。
     * 题目保证你总是可以按上述规则将测试用例变为 1 。
     *  
     * 示例 1：
     * 输入：s = "1101"
     * 输出：6
     * 解释："1101" 表示十进制数 13 。
     * Step 1) 13 是奇数，加 1 得到 14 
     * Step 2) 14 是偶数，除 2 得到 7
     * Step 3) 7  是奇数，加 1 得到 8
     * Step 4) 8  是偶数，除 2 得到 4 
     * Step 5) 4  是偶数，除 2 得到 2 
     * Step 6) 2  是偶数，除 2 得到 1 
     * 示例 2：
     * 输入：s = "10"
     * 输出：1
     * 解释："10" 表示十进制数 2 。
     * Step 1) 2 是偶数，除 2 得到 1
     * 示例 3：
     * 输入：s = "1"
     * 输出：0
     *  
     * 提示：
     * 1 <= s.length <= 500
     * s 由字符 '0' 或 '1' 组成。
     * s[0] == '1'
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/number-of-steps-to-reduce-a-number-in-binary-representation-to-one
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int numSteps(String s) {
        int res = 0;
        // 是否进位标记
        boolean flag = false;

        for (int i = s.length() - 1; i > 0; i--) {
            if (flag) {
                if (s.charAt(i) == '0') {
                    res += 2;
                } else {
                    res += 1;
                }
            } else {
                if (s.charAt(i) == '0') {
                    res += 1;
                } else {
                    res += 2;
                    flag = true;
                }
            }
        }

        if (flag) {
            res++;
        }

        return res;
    }
}
