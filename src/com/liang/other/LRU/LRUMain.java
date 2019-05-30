package com.liang.other.LRU;

/**
 * @ClassName LRUMain
 * @description LRU
 * @Author LiaNg
 * @Date 2019-05-30
 */
public class LRUMain {

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(5);

        lruCache.put("1", "1");
        lruCache.put("2", "2");
        lruCache.put("3", "3");
        lruCache.put("4", "4");
        lruCache.put("5", "5");
        lruCache.map.forEach((k,v)-> System.out.print(k));
        lruCache.get("1");
        lruCache.put("6", "6");
        lruCache.put("7", "7");
        System.out.println();
        lruCache.map.forEach((k,v)-> System.out.print(k));

    }

}
