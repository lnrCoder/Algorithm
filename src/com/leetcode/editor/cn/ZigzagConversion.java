package com.leetcode.editor.cn;

//将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。 
//
// 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下： 
//
// 
//P   A   H   N
//A P L S I I G
//Y   I   R 
//
// 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。 
//
// 请你实现这个将字符串进行指定行数变换的函数： 
//
// 
//string convert(string s, int numRows); 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "PAYPALISHIRING", numRows = 3
//输出："PAHNAPLSIIGYIR"
// 
//示例 2：
//
// 
//输入：s = "PAYPALISHIRING", numRows = 4
//输出："PINALSIGYAHRPI"
//解释：
//P     I    N
//A   L S  I G
//Y A   H R
//P     I
// 
//
// 示例 3： 
//
// 
//输入：s = "A", numRows = 1
//输出："A"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 由英文字母（小写和大写）、',' 和 '.' 组成 
// 1 <= numRows <= 1000 
// 
// Related Topics 字符串 👍 1569 👎 0


/**
 * 6 Z 字形变换
 * @date 2022-03-01 22:26:00
 * @author shang.liang
 */
 public class ZigzagConversion{
    public static void main(String[] args){
        Solution soution = new ZigzagConversion().new Solution();
        String s = "AB";
        int numRows = 14;
        System.out.println("soution.convert(s, numRows) = " + soution.convert(s, numRows));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String convert(String s, int numRows) {

        if (numRows > s.length() || numRows == 1) {
            return s;
        }

        StringBuilder[] sb = new StringBuilder[numRows];

        for (int i = 0; i < numRows; i++) {
            sb[i] = new StringBuilder();
        }

        int index = 0;
        boolean down = true;
        for (int i = 0; i < s.length(); i++) {

            sb[index].append(s.charAt(i));

            if (down) {
                if (index < numRows - 1) {
                    index++;
                } else {
                    index--;
                    down = false;
                }
            } else {

                if (index > 0) {
                    index--;
                } else {
                    index++;
                    down = true;
                }

            }
        }

        for (int i = 1; i < sb.length; i++) {
            sb[0].append(sb[i]);
        }

        return sb[0].toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

 }
