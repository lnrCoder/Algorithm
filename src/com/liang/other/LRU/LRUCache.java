package com.liang.other.LRU;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName LRUCache
 * @description Least recently used
 * @Author LiaNg
 * @Date 2019-05-30
 */
class LRUNode {

    String key;
    Object value;
    LRUNode next;
    LRUNode pre;

    LRUNode(String key, Object value) {
        this.key = key;
        this.value = value;
    }

}

public class LRUCache {

    public Map<String, LRUNode> map = new HashMap<>();
    LRUNode head;
    LRUNode tail;

    //缓存最大容量，（大于1）
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public void put(String key, Object value) {
        if (head == null) {
            head = new LRUNode((key), value);
            tail = head;
            map.put(key, head);
            return;
        }

        LRUNode node = map.get(key);
        if (node != null) {
            // 存在则更新数据
            node.value = value;
            // 从链表中删除并插入到头结点
            removeAndInsert(node);
        }else{
            LRUNode tmp = new LRUNode(key, value);
            // 如果数据溢出
            if (map.size() >= capacity) {
                // 从哈希表删除 && 删除尾部节点
                map.remove(tail.key);
                tail = tail.pre;
                tail.next = null;
            }
            map.put(key, tmp);
            // 插入
            tmp.next =head;
            head.pre = tmp;
            head = tmp;
        }
    }

    public Object get(String key) {
        LRUNode node = map.get(key);

        if (node != null) {
            // 节点存在则删除该节点并插入到头部
            removeAndInsert(node);
            return node.value;
        }

        return null;
    }

    private void removeAndInsert(LRUNode node) {
        // 判断是否头结点或者尾节点
        if (node == head) {
            return;
        } else if (node == tail) {
            tail = node.pre;
            tail.next = null;
        }else{
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }

        // 数据插入头结点
        node.next = head;
        node.pre = null;
        head.pre = node;
        head = node;
    }
}




