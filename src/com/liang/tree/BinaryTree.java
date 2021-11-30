package com.liang.tree;

import com.liang.leetcode.bean.TreeNode;

import java.util.LinkedList;

/**
 * 二叉树遍历
 *
 * @author LiaNg
 * @date 2021/5/19 14:26
 */
public class BinaryTree {

    /**
     * 二叉树前序遍历
     */
    public void preorderTraversal(TreeNode root) {
        if (root != null) {
            System.out.print(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
    }

    /**
     * 二叉树中序遍历
     */
    public void inorderTraversal(TreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.val);
            inorderTraversal(root.right);
        }
    }

    /**
     * 二叉树后序遍历
     */
    public void postorderTraversal(TreeNode root) {
        if (root != null) {
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            System.out.print(root.val);
        }
    }

    /**
     * 二叉树前序遍历
     */
    public void preorderTraversal1(TreeNode root) {

        LinkedList<TreeNode> stack = new LinkedList<>();

        TreeNode currentNode = root;

        while (currentNode != null || !stack.isEmpty()) {

            if (currentNode != null) {
                System.out.print(currentNode.val);
                stack.push(currentNode);
                currentNode = currentNode.left;
            } else {
                currentNode = stack.pop().right;
            }
        }
    }

    /**
     * 二叉树中序遍历
     */
    public void inorderTraversal1(TreeNode root) {

        LinkedList<TreeNode> stack = new LinkedList<>();

        TreeNode currentNode = root;

        while (currentNode != null || !stack.isEmpty()) {

            if (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            } else {
                TreeNode node = stack.pop();
                System.out.print(node.val);
                currentNode = node.right;
            }



        }
    }

    /**
     * 二叉树后序遍历
     */
    public void postorderTraversal1(TreeNode root) {
        if (root != null) {

        }
    }

    /**
     * 广东有限遍历
     */
    public void binaryTreeBFS(TreeNode root) {

        if (root == null) {
            return;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            TreeNode node = queue.poll();
            System.out.println(node.val);

            if (node.left != null) {
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }
}
