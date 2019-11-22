package com.liang.leetcode.stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @ClassName L739
 * @description 每日温度
 * @Author LiaNg
 * @Date 2019-11-21
 */
public class L739 {

    public static void main(String[] args) {
        int[] T = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        L739 l739 = new L739();
        System.out.println("l739.dailyTemperatures(T) = " + Arrays.toString(l739.dailyTemperatures(T)));
    }

    public int[] dailyTemperatures(int[] T) {

        int[] result = new int[T.length];

        Stack<String> stack = new Stack<>();

        Map<String, Integer> mapIndex = new HashMap<>();
        Map<String, String> map = new HashMap<>();

        for (int i = 0; i < T.length; i++) {
            mapIndex.put(T[i] + "-" + i, i);
            while (!stack.empty() && T[i] > Integer.valueOf(stack.peek().split("-")[0])) {
                map.put(stack.pop(), T[i] + "-" + i);
            }
            stack.push(T[i] + "-" + i);
        }

        for (int j = 0; j < T.length; j++) {
            if (map.containsKey(T[j] + "-" + j)) {
                result[j] = mapIndex.get(map.get(T[j] + "-" + j)) - mapIndex.get(T[j] + "-" + j);
            } else {
                result[j] = 0;
            }
        }

        return result;
    }

    /**
     * 作者：li_fz
     * 链接：https://leetcode-cn.com/problems/daily-temperatures/solution/mei-ri-wen-du-java-yi-bian-bian-li-by-li_fz/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int[] dailyTemperatures1(int[] T) {
        int[] r = new int[T.length];
        r[T.length - 1] = 0;
        for (int i = T.length - 2; i >= 0; i--) {
            int j = i + 1;
            while (true) {
                if (T[i] < T[j]) {
                    r[i] = j - i;
                    break;
                } else if (j < T.length - 1) {
                    j++;
                } else {
                    r[i] = 0;
                    break;
                }
            }
        }
        return r;
    }

    /**
     * LeetCode 耗时最短解答
     */
    public int[] dailyTemperatures2(int[] T) {
        int[] predict = new int[T.length];

        for (int i = T.length - 1; i >= 0; i--) {
            for (int j = i + 1; j < T.length; j++) {
                if (T[j] > T[i]) {
                    predict[i] = j - i;
                    break;
                } else if (predict[j] == 0) {
                    break;
                } else {
                    j += predict[j] - 1;
                }
            }
        }

        return predict;
    }

}
