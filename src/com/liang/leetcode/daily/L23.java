package com.liang.leetcode.daily;

import java.util.PriorityQueue;

/**
 * 合并K个排序链表
 *
 * @author LiaNg
 * @date 2020/4/26 10:17
 */
public class L23 {

    public static void main(String[] args) {

    }

    /**
     * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
     * 示例:
     * 输入:
     * [
     *   1->4->5,
     *   1->3->4,
     *   2->6
     * ]
     * 输出: 1->1->2->3->4->4->5->6
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public ListNode mergeKLists(ListNode[] lists) {

        int length = lists.length;
        if (length == 0) {
            return null;
        }

        PriorityQueue<ListNode> queue = new PriorityQueue<>(length,
                                                            (o1, o2) -> Integer.compare(o1.val, o2.val));
        for (ListNode node : lists) {
            if (node != null) {
                queue.add(node);
            }
        }

        ListNode result = new ListNode(0);
        ListNode curr = result;

        while (!queue.isEmpty()) {
            curr.next = queue.poll();
            curr = curr.next;

            if (curr.next != null) {
                queue.add(curr.next);
            }
        }

        return result.next;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
