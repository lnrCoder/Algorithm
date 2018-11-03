package com.liang.leetcode.Interface.L83;

/**
 * @ClassName ListNode
 * @description listnode
 * @Author LiaNg
 * @Date 2018/11/3
 */
public class ListNode {

    public int val;
    public ListNode next;

    ListNode(int x) {
        val = x;
    }

    public static ListNode buildListNode(int[] input) {
        ListNode first = null, last = null, newNode;
        if (input.length > 0) {
            for (int i = 0; i < input.length; i++) {
                newNode = new ListNode(input[i]);
                newNode.next = null;
                if (first == null) {
                    first = newNode;
                    last = newNode;
                } else {
                    last.next = newNode;
                    last = newNode;
                }
            }
        }
        return first;
    }
}
