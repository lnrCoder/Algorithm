package com.liang.leetcode.breadthFirstSearch;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: L429
 * @Description: N 叉树的层序遍历
 * @Author: LiaNg
 * @Date: 2020/3/8 21:14
 */
public class L429 {

    List<List<Integer>> result = new ArrayList<>();

    /**
     * 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
     * 说明:
     * 树的深度不会超过 1000。
     * 树的节点总数不会超过 5000。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public List<List<Integer>> levelOrder(Node root) {
        bfs(0, root);
        return result;
    }

    public void bfs(int k, Node node) {
        if (node == null) {
            return;
        }

        List<Integer> ans;
        if (result.size() > k) {
            ans = result.get(k);
            ans.add(node.val);
        } else {
            ans = new ArrayList<>();
            ans.add(node.val);
            result.add(ans);
        }
        for (Node child : node.children) {
            bfs(k + 1, child);
        }
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
