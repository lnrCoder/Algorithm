package com.liang.other;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

/**
 * @Author LiaNg
 * @ClassName BloomFilter
 * @Date 2019-03-27
 * @Description 布隆过滤器
 */
public class BloomFilter {

    private static final int NUM_SLOTS = 1024 * 1024 * 8;
    private static final int NUM_HASH = 8;

    private BigInteger bitmap = new BigInteger("0");

    public static void main(String[] args) {
        //测试代码
        BloomFilter bf = new BloomFilter();

        ArrayList<String> list = new ArrayList<>();
        list.add("www.baidu.com");
        list.add("www.qq.com");
        list.add("www.163.com");
        list.add("www.sina.com");
        list.add("www.google.com");
        for (String value : list) {
            bf.addElement(value);
        }

        list.add("www.facebook.com");
        list.add("www.youtube.com");

        for (String s : list) {
            System.out.println(s + " = " + bf.check(s));
        }
    }

    private int getHash(String msg, int n) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("md5");
            String message = msg + n;
            byte[] bytes = message.getBytes();
            md5.update(bytes);
            BigInteger bi = new BigInteger(md5.digest());

            return Math.abs(bi.intValue()) % NUM_SLOTS;
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
        return -1;
    }

    private void addElement(String message) {
        for (int i = 0; i < NUM_HASH; i++) {
            int hashcode = getHash(message, i);
            if (!bitmap.testBit(hashcode)) {
                bitmap = bitmap.or(new BigInteger("1").shiftLeft(hashcode));
            }
        }
    }

    private boolean check(String message) {
        for (int i = 0; i < NUM_HASH; i++) {
            int hashcode = getHash(message, i);
            if (!this.bitmap.testBit(hashcode)) {
                return false;
            }
        }
        return true;
    }
}
