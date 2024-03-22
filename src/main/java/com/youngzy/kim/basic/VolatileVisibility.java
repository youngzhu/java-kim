package com.youngzy.kim.basic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * volatile 的可见性
 *
 * 偶尔 counter: 10001
 * 怎么保证可见性的？而且用 != 容易陷入死循环
 *
 * 是因为做了比较？直接用布尔值试试
 * 还是不行
 *
 * 想到达“计数达到10000就停止”的效果，计数器就要保证原子性。
 * 所以 volatile int counter 是不行的
 *
 * @author youngzy
 * @since 2023-04-28
 */
public class VolatileVisibility {
    private static volatile boolean done = false;
//    private static volatile int counter = 0;
    static AtomicInteger counter = new AtomicInteger();

    static int c1 = 0, c2 = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            while (!done){
                counter.incrementAndGet();
                c1++;
            }
        });
        Thread t2 = new Thread(() -> {
            while (!done){
                counter.incrementAndGet();
                c2++;
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        while (!done) {
            done = (10000 == counter.get());
            System.out.println(counter.get());
        }

        /*
        这结果就离谱。。
        counter: 10000
        c1: -35326988, c2: 35336988
         */
        System.out.println("counter: " + counter);
        System.out.printf("c1: %d, c2: %d", c1, c2);
    }

    /* 计数器的原子性
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                counter.incrementAndGet();
                c1++;
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                counter.incrementAndGet();
                c2++;
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("counter: " + counter);
        System.out.printf("c1: %d, c2: %d", c1, c2);
    }

     */

    /*
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
//            while (counter != 10000) {
            while (counter < 10000) {
                counter++;
                c1++;
            }
        });
        Thread t2 = new Thread(() -> {
//            while (counter != 10000) {
            while (counter < 10000) {
                counter++;
                c2++;
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("counter: " + counter);
        System.out.printf("c1: %d, c2: %d", c1, c2);
    }

     */
}
