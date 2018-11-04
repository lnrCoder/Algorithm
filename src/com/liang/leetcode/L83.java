package com.liang.leetcode;

import com.liang.leetcode.Interface.L83.ListNode;

/**
 * @ClassName L83
 * @description remove-duplicates-from-sorted-list
 * @Author LiaNg
 * @Date 2018/11/3
 */
public class L83 {

    public static void main(String[] args) {
        int[] input = new int[]{1, 1, 2, 3, 3};
        ListNode listNode = ListNode.buildListNode(input);

        L83 l = new L83();
        l.deleteDuplicates(listNode);

        while (listNode != null) {
            System.out.println("val:" + listNode.val);
            listNode = listNode.next;
        }
    }

    /**
     * 删除排序链表中的重复元素
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode now = head;
        if (now == null) {
            return null;
        }
        while (now.next != null) {
            if (now.val == now.next.val) {
                now.next = now.next.next;
            } else {
                now = now.next;
            }
        }
        return head;
    }
}
