package com.liang.leetcode.daily.history;

/**
 * @ClassName: L876
 * @Description: 链表的中间结点
 * @Author: LiaNg
 * @Date: 2020/3/23 10:07
 */
public class L876 {

    /**
     * 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
     * 如果有两个中间结点，则返回第二个中间结点。
     * 提示：
     * 给定链表的结点数介于 1 和 100 之间。
     */
    public ListNode middleNode(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                fast = null;
            }
        }

        return slow;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
