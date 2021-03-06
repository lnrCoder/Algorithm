package com.liang.leetcode.daily.history;

import java.util.*;

/**
 * 等式方程的可满足性
 *
 * @author LiaNg
 * @date 2020/6/8 9:21
 */
public class L990 {

    public static void main(String[] args) {
        L990 l990 = new L990();
        String[] equations = new String[]{};
        System.out.println("l990.equationsPossible(equations) = " + l990.equationsPossible(equations));
    }

    /**
     * 给定一个由表示变量之间关系的字符串方程组成的数组，每个字符串方程 equations[i] 的长度为 4，并采用两种不同的形式之一："a==b" 或 "a!=b"。在这里，a 和 b 是小写字母（不一定不同），表示单字母变量名。
     * 只有当可以将整数分配给变量名，以便满足所有给定的方程时才返回 true，否则返回 false。 
     * 示例 1：
     * 输入：["a==b","b!=a"]
     * 输出：false
     * 解释：如果我们指定，a = 1 且 b = 1，那么可以满足第一个方程，但无法满足第二个方程。没有办法分配变量同时满足这两个方程。
     * 示例 2：
     * 输出：["b==a","a==b"]
     * 输入：true
     * 解释：我们可以指定 a = 1 且 b = 1 以满足满足这两个方程。
     * 示例 3：
     * 输入：["a==b","b==c","a==c"]
     * 输出：true
     * 示例 4：
     * 输入：["a==b","b!=c","c==a"]
     * 输出：false
     * 示例 5：
     * 输入：["c==c","b==d","x!=z"]
     * 输出：true
     * 提示：
     * 1 <= equations.length <= 500
     * equations[i].length == 4
     * equations[i][0] 和 equations[i][3] 是小写字母
     * equations[i][1] 要么是 '='，要么是 '!'
     * equations[i][2] 是 '='
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/satisfiability-of-equality-equations
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public boolean equationsPossible(String[] equations) {
        List<Integer>[] graph = new ArrayList[26];
        for (int i = 0; i < 26; i++) {
            graph[i] = new ArrayList();
        }

        for (String s : equations) {
            if (s.charAt(1) == '!') {
                continue;
            }
            int l = s.charAt(0) - 'a';
            int r = s.charAt(3) - 'a';
            graph[l].add(r);
            graph[r].add(l);
        }

        int[] colors = new int[26];
        int color = 1;
        for (int i = 0; i < 26; i++) {
            if (colors[i] != 0) {
                continue;
            }
            bfs(i, color++, colors, graph);
        }

        //check unequal
        for (String s : equations) {
            if (s.charAt(1) == '=') {
                continue;
            }
            int l = s.charAt(0) - 'a';
            int r = s.charAt(3) - 'a';
            if (colors[l] == colors[r]) {
                return false;
            }
        }

        return true;
    }

    public void bfs(int node, int color, int[] colors, List<Integer>[] graph) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            int cur = queue.remove();
            colors[cur] = color;
            visited.add(cur);
            for (Integer nbr : graph[cur]) {
                if (!visited.contains(nbr)) {
                    queue.add(nbr);
                }
            }
        }
    }
}
