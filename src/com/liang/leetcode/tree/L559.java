package com.liang.leetcode.tree;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: L559
 * @Description: N叉树的最大深度
 * @Author: LiaNg
 * @Date: 2020/2/5 17:57
 */
public class L559 {

    /**
     * 给定一个 N 叉树，找到其最大深度。
     * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int maxDepth(Node root) {

        if (root == null) {
            return 0;
        }
        if (root.children.isEmpty()) {
            return 1;
        }

        List<Integer> heights = new LinkedList<>();
        for (Node child : root.children) {
            heights.add(maxDepth(child));
        }

        return Collections.max(heights) + 1;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
