package com.liang.other;

import com.google.common.util.concurrent.RateLimiter;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName RateLimiterDemo
 * @description guava 限流工具测试
 * @Author LiaNg
 * @Date 2019-09-25
 */
public class RateLimiterDemo {

    public static void main(String[] args) {
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("thread-call-runner-%d").build();
        ExecutorService executorService = new ThreadPoolExecutor(2, 3, 0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(), namedThreadFactory);

        final RateLimiter rateLimiter = RateLimiter.create(3.0);

        for (int i = 0; i < 100; i++) {
            final int no =i;
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        rateLimiter.acquire();
                        System.out.println("Accessing: " + no + ",time:"
                                + new SimpleDateFormat("yy-MM-dd HH:mm:ss").format(new Date()) + Thread.currentThread().getName() );

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            };
            executorService.execute(runnable);
        }
        executorService.shutdown();
    }

}
