package com.liang.leetcode.minimax;

/**
 * @ClassName: L292
 * @Description: Nim 游戏
 * @Author: LiaNg
 * @Date: 2020/3/24 21:04
 */
public class L292 {

    public static void main(String[] args) {
        L292 l292 = new L292();
        int n = 4;
        System.out.println("l292.canWinNim(n) = " + l292.canWinNim(n));
    }

    /**
     * 你和你的朋友，两个人一起玩 Nim 游戏：桌子上有一堆石头，每次你们轮流拿掉 1 - 3 块石头。 拿掉最后一块石头的人就是获胜者。你作为先手。
     * 你们是聪明人，每一步都是最优解。 编写一个函数，来判断你是否可以在给定石头数量的情况下赢得游戏。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/nim-game
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public boolean canWinNim(int n) {
        return (n % 4 != 0);
    }
}
