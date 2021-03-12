package com.liang.leetcode.daily.Mar21;

/**
 * 验证二叉树的前序序列化
 *
 * @author LiaNg
 * @date 2021/3/12 9:01
 */
public class L331 {

    /**
     * 序列化二叉树的一种方法是使用前序遍历。当我们遇到一个非空节点时，我们可以记录下这个节点的值。如果它是一个空节点，我们可以使用一个标记值记录，例如 #。
     * _9_
     * /   \
     * 3     2
     * / \   / \
     * 4   1  #  6
     * / \ / \   / \
     * # # # #   # #
     * 例如，上面的二叉树可以被序列化为字符串 "9,3,4,#,#,1,#,#,2,#,6,#,#"，其中 # 代表一个空节点。
     * 给定一串以逗号分隔的序列，验证它是否是正确的二叉树的前序序列化。编写一个在不重构树的条件下的可行算法。
     * 每个以逗号分隔的字符或为一个整数或为一个表示 null 指针的 '#' 。
     * 你可以认为输入格式总是有效的，例如它永远不会包含两个连续的逗号，比如 "1,,3" 。
     * 示例 1:
     * 输入: "9,3,4,#,#,1,#,#,2,#,6,#,#"
     * 输出: true
     * 示例 2:
     * 输入: "1,#"
     * 输出: false
     * 示例 3:
     * 输入: "9,#,#,1"
     * 输出: false
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/verify-preorder-serialization-of-a-binary-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public boolean isValidSerialization(String preorder) {

        if ("#".equals(preorder)) {
            return true;
        }

        String[] strArray = preorder.split(",");

        // 出度 - 非空节点出度为 2，空节点出度为 0
        int out = 0;
        // 入度 - 根节点入度为0，其他节点入度为 1
        int in = 0;

        for (int i = 0; i < strArray.length; i++) {

            if (i == 0) {
                if ("#".equals(strArray[i])) {
                    return false;
                }
                out += 2;
                continue;
            }

            if ("#".equals(strArray[i])) {
                // 空节点入度 +1
                in++;
            } else {
                // 非空阶段入度 +1
                in++;
                // 非空阶段出度 +2
                out += 2;
            }

            if (i != strArray.length - 1 && in >= out) {
                return false;
            }
        }

        return in == out;
    }

    public static void main(String[] args) {
        L331 l331 = new L331();
        String preorder = "9,3,4,#,#,1,#,#,2,#,6,#,#";
        System.out.println("l331.isValidSerialization(preorder) = " + l331.isValidSerialization(preorder));
    }
}
