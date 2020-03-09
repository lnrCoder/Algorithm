package com.liang.leetcode.depthFirstSearch;

/**
 * @ClassName: L108
 * @Description: 将有序数组转换为二叉搜索树
 * @Author: LiaNg
 * @Date: 2020/3/9 15:51
 */
public class L108 {

    /**
     * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
     * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(0, nums.length - 1, nums);
    }

    public TreeNode dfs(int left, int right, int[] nums) {
        if (left > right) {
            return null;
        }
        int p = (left + right) / 2;

        TreeNode root = new TreeNode(nums[p]);
        root.left = dfs(left, p - 1, nums);
        root.right = dfs(p + 1, right, nums);
        return root;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
