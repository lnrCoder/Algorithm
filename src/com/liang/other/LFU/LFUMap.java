package com.liang.other.LFU;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName LFUMap
 * @description Least Frequently Used
 * @Author LiaNg
 * @Date 2019-05-30
 */
public class LFUMap<K, V> extends HashMap<K, V> {

    private static final int DEFAULT_MAX_SIZE = 3;
    private int maxSize = DEFAULT_MAX_SIZE;
    Map<K, HitRate> km = new HashMap<K, HitRate>();

    public LFUMap() {
        this(DEFAULT_MAX_SIZE);
    }

    public LFUMap(int maxSize) {
        super(maxSize);
        this.maxSize = maxSize;
    }

    @Override
    public V get(Object key) {
        V v = super.get(key);
        if (v != null) {
            HitRate hitRate = km.get(key);
            hitRate.hitCount += 1;
            hitRate.atime = System.nanoTime();
        }
        return v;
    }

    @Override
    public V put(K key, V value) {
        while (km.size() >= maxSize) {
            K k = getLFU();
            km.remove(k);
            this.remove(k);
        }
        V v = super.put(key, value);
        km.put(key, new HitRate(key, 1, System.nanoTime()));
        return v;
    }

    private K getLFU() {
        HitRate min = Collections.min(km.values());
        return min.key;
    }

    class HitRate implements Comparable<HitRate> {

        K key;
        Integer hitCount;
        Long atime;

        public HitRate(K Key, Integer hitCount, Long atime) {
            this.key = Key;
            this.hitCount = hitCount;
            this.atime = atime;
        }

        @Override
        public int compareTo(HitRate o) {
            int hr = hitCount.compareTo(o.hitCount);
            return hr != 0 ? hr : atime.compareTo(o.atime);
        }
    }

    public static void main(String[] args) {
        LFUMap<String, String> cache = new LFUMap<>();
        cache.put("a", "a");
        cache.put("b", "b");
        cache.put("c", "c");
        
        cache.keySet().forEach(System.out::print);
        System.out.println();

        cache.get("a");

        cache.put("d", "d");

        cache.keySet().forEach(System.out::print);
        System.out.println();

        cache.get("d");

        cache.put("e", "e");

        cache.keySet().forEach(System.out::print);
    }
}


