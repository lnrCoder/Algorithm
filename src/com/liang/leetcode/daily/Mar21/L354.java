package com.liang.leetcode.daily.Mar21;

import java.util.Arrays;

/**
 * 俄罗斯套娃信封问题
 *
 * @author LiaNg
 * @date 2021/3/4 9:25
 */
public class L354 {

    public static void main(String[] args) {
        L354 l354 = new L354();
        int[][] envelopes = new int[][]{{5, 4}, {6, 4}, {6, 7}, {2, 3}};
        int[][] envelopes1 = new int[][]{{1, 2}, {2, 3}, {3, 4}, {3, 5}, {4, 5}, {5, 5}, {5, 6}, {6, 7}, {7, 8}};
        int[][] envelopes2 = new int[][]{{2, 100}, {3, 200}, {4, 300}, {5, 500}, {5, 400}, {5, 250}, {6, 370}, {6, 360}, {7, 380}};
        System.out.println("l354.maxEnvelopes(envelopes) = " + l354.maxEnvelopes(envelopes));
        System.out.println("l354.maxEnvelopes(envelopes1) = " + l354.maxEnvelopes(envelopes1));
        System.out.println("l354.maxEnvelopes(envelopes2) = " + l354.maxEnvelopes(envelopes2));

        System.out.println("l354.maxEnvelopes1(envelopes) = " + l354.maxEnvelopes1(envelopes));
        System.out.println("l354.maxEnvelopes1(envelopes1) = " + l354.maxEnvelopes1(envelopes1));
        System.out.println("l354.maxEnvelopes1(envelopes2) = " + l354.maxEnvelopes1(envelopes2));
    }

    /**
     * 给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 (w, h) 出现。当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
     * 请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
     * 说明:
     * 不允许旋转信封。
     * 示例:
     * 输入: envelopes = [[5,4],[6,4],[6,7],[2,3]]
     * 输出: 3
     * 解释: 最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/russian-doll-envelopes
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int maxEnvelopes(int[][] envelopes) {

        Arrays.sort(envelopes, (o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]);

        int res = 0;

        int[] dp = new int[envelopes.length];
        Arrays.fill(dp, 1);

        for (int i = 0; i < dp.length; i++) {

            for (int j = 0; j < i; j++) {

                if (envelopes[j][0] < envelopes[i][0] && envelopes[j][1] < envelopes[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            res = Math.max(dp[i], res);
        }

        return res;
    }

    public int maxEnvelopes1(int[][] envelopes) {

        int length = envelopes.length;
        if (length == 0) {
            return 0;
        }

        Arrays.sort(envelopes, (o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]);

        int[] dp = new int[length + 1];
        dp[0] = -1;
        int res = 0;
        for (int i = 0; i < length; i++) {
            int num = envelopes[i][1];
            if (num > dp[res]) {
                res++;
                dp[res] = num;
            } else {
                int left = 0;
                int right = res;
                while (left < right) {
                    int mid = (left + right) >>> 1;
                    if (dp[mid] < num) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }

                dp[left] = Math.min(dp[left], num);
            }
        }

        return res;
    }
}
