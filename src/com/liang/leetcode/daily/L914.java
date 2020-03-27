package com.liang.leetcode.daily;

/**
 * @ClassName: L914
 * @Description: 卡牌分组
 * @Author: LiaNg
 * @Date: 2020/3/27 8:52
 */
public class L914 {

    public static void main(String[] args) {
        L914 l914 = new L914();
        int[] deck = new int[]{1, 2, 3, 4, 4, 3, 2, 1};
        System.out.println("l914.hasGroupsSizeX(deck) = " + l914.hasGroupsSizeX(deck));
    }

    /**
     * 给定一副牌，每张牌上都写着一个整数。
     * 此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：
     * 每组都有 X 张牌。
     * 组内所有的牌上都写着相同的整数。
     * 仅当你可选的 X >= 2 时返回 true。
     * 提示：
     * 1 <= deck.length <= 10000
     * 0 <= deck[i] < 10000
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/x-of-a-kind-in-a-deck-of-cards
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public boolean hasGroupsSizeX(int[] deck) {
        int[] check = new int[1000];

        for (int i : deck) {
            check[i]++;
        }

        int gcd = check[0];

        for (int i = 1; i < 1000; i++) {
            if (check[i] > 0) {
                gcd = gcd(gcd, check[i]);
            }
        }

        return gcd > 1;
    }

    public int gcd(int x, int y) {
        return x == 0 ? y : gcd(y % x, x);
    }
}
