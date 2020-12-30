package com.liang.leetcode.other;

/**
 * 同数包夹
 *
 * @author LiaNg
 * @date 2020/12/30 9:41
 */
public class Q53 {

    public static void main(String[] args) {
        Q53 q53 = new Q53();
        System.out.println("q53.cardPermutation(11) = " + q53.cardPermutation(11));
    }

    int n;
    int[] cards;
    int ans = 0;

    /**
     * 这里有分别标了数字 1~n 的两副牌，共 2n 张。把这些牌排成一排，然后两张 1 的中间放一张牌，两张 2 的中间放两张牌……两张 n 的中间放 n 张牌。举个例子，当 n = 3 的时候，有如 图 1 所示的两种排列方法。
     * 图 1　当 n =3 时
     * 提问：求当 n = 11 时共有多少种排列方法？
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode-cn.com/circle/discuss/FxkmqT/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int cardPermutation(int n) {
        this.n = n;
        this.cards = new int[n * 2];
        dfs(1);
        return ans;
    }

    public void dfs(int num) {
        if (num == n + 1) {
            ++ans;
            return;
        }

        for (int i = 0; i + num + 1 < n * 2; ++i) {
            // 枚举两张数字为 num 的牌的放入空位，它们的间隔为 num
            if (cards[i] == 0 && cards[i + num + 1] == 0) {
                cards[i] = cards[i + num + 1] = num;
                dfs(num + 1);
                cards[i] = cards[i + num + 1] = 0;
            }
        }
    }
}
