package com.liang.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: L589
 * @Description: N叉树的前序遍历
 * @Author: LiaNg
 * @Date: 2020/1/29 18:35
 */
public class L589 {

    /**
     * 给定一个 N 叉树，返回其节点值的前序遍历。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public List<Integer> preorder(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        get(root, list);
        return list;
    }

    private List<Integer> get(Node node, List<Integer> list) {
        if (node == null) {
            return list;
        }

        list.add(node.val);

        for (Node child : node.children) {
            get(child, list);
        }
        return list;
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
