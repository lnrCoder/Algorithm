package com.liang.other.LFU;

/**
 * @ClassName LFUMain
 * @description LFU
 * @Author LiaNg
 * @Date 2019-05-30
 */
public class LFUMain {

    public static void main(String[] args) {
        LFUMap<String, String> cache = new LFUMap<>();
        cache.put("a", "a");
        cache.put("b", "b");
        cache.put("c", "c");

        System.out.println("==================");
        cache.keySet().forEach(System.out::print);
        System.out.println("==================");

        cache.get("a");
        cache.put("d", "d");

        System.out.println("==================");
        cache.keySet().forEach(System.out::print);
        System.out.println("==================");

        cache.get("d");
        cache.put("e", "e");

        System.out.println("==================");
        cache.keySet().forEach(System.out::print);
        System.out.println("==================");
    }

}
