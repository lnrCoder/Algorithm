package com.liang.other;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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

        for (int i = 0; i < 100; ) {
            bf.addElement(i);
            i = i + 2;
            System.out.println("i = " + i);
        }

        for (int i = 0; i < 100; i++) {
            System.out.println("bf = " + bf.check(i));
        }
    }

    private int getHash(Integer msg, int n) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("md5");
            String message = msg + String.valueOf(n);
            byte[] bytes = message.getBytes();
            md5.update(bytes);
            BigInteger bi = new BigInteger(md5.digest());

            return Math.abs(bi.intValue()) % NUM_SLOTS;
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
        return -1;
    }

    private void addElement(Integer message) {
        for (int i = 0; i < NUM_HASH; i++) {
            int hashcode = getHash(message, i);
            if (!bitmap.testBit(hashcode)) {
                bitmap = bitmap.or(new BigInteger("1").shiftLeft(hashcode));
            }
        }
    }

    private boolean check(Integer message) {
        for (int i = 0; i < NUM_HASH; i++) {
            int hashcode = getHash(message, i);
            if (!this.bitmap.testBit(hashcode)) {
                return false;
            }
        }
        return true;
    }
}
