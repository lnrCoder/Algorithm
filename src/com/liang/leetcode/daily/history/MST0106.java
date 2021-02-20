package com.liang.leetcode.daily.history;

/**
 * @ClassName: MST0106
 * @Description: 字符串压缩
 * @Author: LiaNg
 * @Date: 2020/3/16 12:58
 */
public class MST0106 {
    public static void main(String[] args) {

        String s = "aabcccccaaa";
        MST0106 mst0106 = new MST0106();
        System.out.println("mst0106.compressString(s) = " + mst0106.compressString(s));
    }

    /**
     * 字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。比如，字符串 aabcccccaaa 会变为 a2b1c5a3。若 “压缩” 后的字符串没有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a 至 z）。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/compress-string-lcci
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public String compressString(String S) {

        if (S.length() <= 2) {
            return S;
        }

        StringBuilder stringBuilder = new StringBuilder();
        int count = 1;
        char[] charArray = S.toCharArray();
        stringBuilder.append(charArray[0]);
        for (int i = 1; i < charArray.length; i++) {
            if (charArray[i] == charArray[i - 1]) {
                count++;
            } else {
                stringBuilder.append(count);
                count = 1;
                stringBuilder.append(charArray[i]);
            }
        }
        stringBuilder.append(count);

        return stringBuilder.length() > S.length() ? S : stringBuilder.toString();
    }
}
