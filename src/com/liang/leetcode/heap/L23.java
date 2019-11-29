package com.liang.leetcode.heap;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName L23
 * @description 合并K个排序链表
 * @Author LiaNg
 * @Date 2019-11-29
 */
public class L23 {

    public static void main(String[] args) {
        ListNode listNode0 = new ListNode(1);
        listNode0.next = new ListNode(4);
        listNode0.next.next = new ListNode(5);

        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(3);
        listNode1.next.next = new ListNode(4);

        ListNode listNode2 = new ListNode(2);
        listNode2.next = new ListNode(6);

        ListNode[] lists = new ListNode[3];
        lists[0] = listNode0;
        lists[1] = listNode1;
        lists[2] = listNode2;

        L23 l23 = new L23();
        ListNode listNode = l23.mergeKLists(lists);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
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

        List<Integer> allNums = new ArrayList<>();

        for (int i = 0; i < lists.length; i++) {
            ListNode now = lists[i];
            while (now != null) {
                allNums.add(now.val);
                now = now.next;
            }
        }
        if (allNums.isEmpty()) {
            return null;
        }
        allNums.sort((o1, o2) -> o1 - o2);

        ListNode result = new ListNode(allNums.get(0));
        ListNode index = result;
        for (int i = 1; i < allNums.size(); i++) {
            index.next = new ListNode(allNums.get(i));
            index = index.next;
        }
        return result;
    }

    /**
     * LeetCode 耗时最短解答
     */
    public ListNode mergeKLists1(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        int left = 0, right = lists.length - 1;
        while (right > 0) {
            left = 0;
            while (left < right) {
                lists[left] = merge(lists[left], lists[right]);
                left++;
                right--;
            }

        }
        return lists[0];
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if (l1 != null) {
            cur.next = l1;
        }
        if (l2 != null) {
            cur.next = l2;
        }
        return dummy.next;
    }
}

class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}