package com.liang.leetcode.sort;

/**
 * @ClassName: L148
 * @Description: 排序链表
 * @Author: LiaNg
 * @Date: 2019/12/19 14:28
 */
public class L148 {

    /**
     * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/sort-list
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        return sort(head);
    }

    public ListNode sort(ListNode head) {

        if (head.next == null) {
            return head;
        }

        ListNode fast = head.next;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        fast = slow.next;
        slow.next = null;

        head = sort(head);
        fast = sort(fast);
        return merge(head, fast);
    }

    public ListNode merge(ListNode node1, ListNode node2) {
        ListNode head;
        if (node1.val > node2.val) {
            head = node2;
            node2 = node2.next;
        } else {
            head = node1;
            node1 = node1.next;
        }
        ListNode temp = head;
        while (node1 != null && node2 != null) {
            if (node1.val > node2.val) {
                temp.next = node2;
                node2 = node2.next;
                temp = temp.next;
            } else {
                temp.next = node1;
                node1 = node1.next;
                temp = temp.next;
            }
        }

        if (node1 != null) {
            temp.next = node1;
        } else {
            temp.next = node2;
        }

        return head;
    }

    /**
     * LeetCode 耗时最短解答
     */
    public ListNode sortList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode left = null, right = null, mid = head;
        int leftLength = 0, rightLength = 0, midLength = 0;
        head = head.next;

        mid.next = null;

        while (head != null) {
            if (head.val < mid.val) {
                if (left == null) {
                    ListNode newHead = head.next;
                    left = head;
                    left.next = null;
                    head = newHead;
                } else {
                    ListNode newHead = head.next;
                    head.next = left;
                    left = head;
                    head = newHead;
                }
                leftLength++;
            } else if (head.val > mid.val) {
                if (right == null) {
                    ListNode newHead = head.next;
                    right = head;
                    right.next = null;
                    head = newHead;
                } else {
                    ListNode newHead = head.next;
                    head.next = right;
                    right = head;
                    head = newHead;
                }
                rightLength++;
            } else {
                ListNode newHead = head.next;
                head.next = mid;
                mid = head;
                head = newHead;
                midLength++;
            }
        }
        ListNode current = mid;
        ListNode newHead = mid;

        if (leftLength > 0) {
            current = sortList1(left);
            newHead = current;
            while (current.next != null) {
                current = current.next;
            }
            current.next = mid;
        }

        while (current.next != null) {
            current = current.next;
        }
        current.next = sortList1(right);
        return newHead;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
