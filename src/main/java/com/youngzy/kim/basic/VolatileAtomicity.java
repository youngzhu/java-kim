package com.youngzy.kim.basic;

/**
 * volatile 不能保证原子性
 * 最终 counter < 20000
 *
 * @author youngzy
 * @since 2023-04-28
 */
public class VolatileAtomicity {
    private static volatile int counter = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                counter++;
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                counter++;
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("counter: " + counter);
    }
}
