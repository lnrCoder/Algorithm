package com.liang.leetcode.daily;

import java.util.HashMap;
import java.util.Map;

/**
 * LRU 缓存机制
 *
 * @author LiaNg
 * @date 2020/5/25 9:16
 */
public class LRUCache {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(1);

        cache.put(2, 1);
        System.out.println(cache.get(2));
        cache.put(3, 2);
        System.out.println(cache.get(2));
    }

    Node head;
    Node tail;
    int capacity;
    int count = 0;
    Map<Integer, Node> cache = new HashMap<Integer, Node>();

    /**
     * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
     * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
     * 写入数据 put(key, value) - 如果密钥已经存在，则变更其数据值；如果密钥不存在，则插入该组「密钥/数据值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
     *  
     * 进阶:
     * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
     *  
     * 示例:
     * LRUCache cache = new LRUCache(2);// 缓存容量
     * cache.put(1,1);
     * cache.put(2,2);
     * cache.get(1);       // 返回  1
     * cache.put(3,3);    // 该操作会使得密钥 2 作废
     * cache.get(2);       // 返回 -1 (未找到)
     * cache.put(4,4);    // 该操作会使得密钥 1 作废
     * cache.get(1);       // 返回 -1 (未找到)
     * cache.get(3);       // 返回  3
     * cache.get(4);       // 返回  4
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/lru-cache
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {

        if (cache.get(key) == null) {
            return -1;
        }

        Node node = cache.get(key);
        int val = node.val;

        node.pre.next = node.next;
        node.next.pre = node.pre;

        node.next = head.next;
        node.pre = head;
        head.next.pre = node;
        head.next = node;

        return val;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);

        if (node != null) {
            node.val = value;
            node.pre.next = node.next;
            node.next.pre = node.pre;

            node.next = head.next;
            node.pre = head;
            head.next.pre = node;
            head.next = node;

            return;
        }
        Node newNode = new Node(key, value, null, null);
        if (capacity == count) {
            cache.remove(tail.pre.key);
            tail.pre.pre.next = tail;
            tail.pre = tail.pre.pre;
            count--;
        }

        newNode.next = head.next;
        newNode.pre = head;
        head.next.pre = newNode;
        head.next = newNode;

        count++;
        cache.put(key, newNode);
    }

    class Node {

        int val;
        int key;

        Node next;
        Node pre;

        Node() {
        }

        Node(int key, int val, Node next, Node pre) {
            this.val = val;
            this.key = key;
            this.next = next;
            this.pre = pre;
        }
    }
}
