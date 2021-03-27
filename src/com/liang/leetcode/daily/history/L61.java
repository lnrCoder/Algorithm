package com.liang.leetcode.daily.history;

import com.liang.leetcode.bean.ListNode;

/**
 * 旋转链表
 *
 * @author LiaNg
 * @date 2021/3/27 21:19
 */
public class L61 {

    /**
     * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
     *  
     * 示例 1：
     * 输入：head = [1,2,3,4,5], k = 2
     * 输出：[4,5,1,2,3]
     * 示例 2：
     * 输入：head = [0,1,2], k = 4
     * 输出：[2,0,1]
     *  
     * 提示：
     * 链表中节点的数目在范围 [0, 500] 内
     * -100 <= Node.val <= 100
     * 0 <= k <= 2 * 109
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/rotate-list
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public ListNode rotateRight(ListNode head, int k) {

        if (head == null) {
            return head;
        }

        int length = 1;

        ListNode cur = head;

        while (cur.next != null) {
            length++;
            cur = cur.next;
        }

        cur.next = head;

        int nodeNum = length - (k % length) - 1;

        while (nodeNum > 0) {
            head = head.next;
            nodeNum--;
        }

        ListNode newHead = head.next;

        head.next = null;

        return newHead;
    }
}
