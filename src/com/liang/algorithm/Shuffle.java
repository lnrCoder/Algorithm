package com.liang.algorithm;

import java.util.Arrays;
import java.util.Random;

/**
 * 洗牌算法
 *
 * @author LiaNg
 * @date 2020/5/29 18:26
 */
public class Shuffle {

    public static void main(String[] args) {
        int[] cards = new int[54];
        for (int i = 0; i < cards.length; i++) {
            cards[i] = i;
        }

        System.out.println("洗牌前 = " + Arrays.toString(cards));
        Shuffle shuffle = new Shuffle();
        shuffle.shuffle(cards);
        System.out.println("洗牌后 = " + Arrays.toString(cards));
    }

    /**
     * 洗牌算法
     */
    public void shuffle(int[] cards) {

        Random random = new Random();
        for (int i = cards.length - 1; i >= 0; i--) {
            swap(cards, i, random.nextInt(i + 1));
        }
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
