package com.liang.leetcode.twoPointers;

/**
 * @ClassName: L925
 * @Description: 长按键入
 * @Author: LiaNg
 * @Date: 2020/3/18 22:48
 */
public class L925 {

    public static void main(String[] args) {
        L925 l925 = new L925();
        String name = "alex";
        String typed = "aaleex";
        System.out.println("l925.isLongPressedName(name, typed) = " + l925.isLongPressedName(name, typed));
    }

    /**
     * 你的朋友正在使用键盘输入他的名字 name。偶尔，在键入字符 c 时，按键可能会被长按，而字符可能被输入 1 次或多次。
     * 你将会检查键盘输入的字符 typed。如果它对应的可能是你的朋友的名字（其中一些字符可能被长按），那么就返回 True。
     * 提示：
     * name.length <= 1000
     * typed.length <= 1000
     * name 和 typed 的字符都是小写字母。
     */
    public boolean isLongPressedName(String name, String typed) {

        int slow = 0;
        int fast = 0;

        char[] nameArr = name.toCharArray();
        char[] typedArr = typed.toCharArray();

        while (slow < name.length() && fast < typed.length()) {
            if (nameArr[slow] == typedArr[fast]) {
                slow++;
                fast++;
            } else {
                fast++;
            }
        }
        return slow == nameArr.length;
    }
}
