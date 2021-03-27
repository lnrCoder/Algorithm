package com.liang.leetcode.bean;

/**
 * ListNode
 *
 * @author LiaNg
 * @date 2021/3/27 21:20
 */
public class ListNode {

    public int val;

    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
