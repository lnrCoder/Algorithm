package com.liang.algorithm4;

/**
 * 计时器
 *
 * @author LiaNg
 * @date 2021/4/5 11:22
 */
public class StopWatch {

    private final long start;

    public StopWatch() {
        start = System.currentTimeMillis();
    }

    public double slapsedTime() {
        long now = System.currentTimeMillis();
        return (now - start) / 1000.0;
    }
}
