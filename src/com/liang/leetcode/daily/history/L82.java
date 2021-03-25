package com.liang.leetcode.daily.history;

/**
 * 删除排序链表中的重复元素 II
 *
 * @author LiaNg
 * @date 2021/3/25 10:44
 */
public class L82 {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode();
        ListNode listNode2 = new ListNode();
        ListNode listNode3 = new ListNode();
        ListNode listNode4 = new ListNode();
        ListNode listNode5 = new ListNode();
        ListNode listNode6 = new ListNode();
        ListNode listNode7 = new ListNode();

        listNode1.val = 1;
        listNode2.val = 2;
        listNode3.val = 3;
        listNode4.val = 3;
        listNode5.val = 4;
        listNode6.val = 4;
        listNode7.val = 5;

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;

        L82 l82 = new L82();
        System.out.println("l82.deleteDuplicates(listNode1) = " + l82.deleteDuplicates(listNode1));
    }

    /**
     * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中 没有重复出现 的数字。
     * 返回同样按升序排列的结果链表。
     *  
     * 示例 1：
     * 输入：head = [1,2,3,3,4,4,5]
     * 输出：[1,2,5]
     * 示例 2：
     * 输入：head = [1,1,1,2,3]
     * 输出：[2,3]
     *  
     * 提示：
     * 链表中节点数目在范围 [0, 300] 内
     * -100 <= Node.val <= 100
     * 题目数据保证链表已经按升序排列
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public ListNode deleteDuplicates(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        if (head.val != head.next.val) {
            head.next = deleteDuplicates(head.next);
        }else{
            ListNode move = head.next;
            while (move!=null && head.val == move.val) {
                move = move.next;
            }
            return deleteDuplicates(move);
        }

        return head;
    }

}
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
