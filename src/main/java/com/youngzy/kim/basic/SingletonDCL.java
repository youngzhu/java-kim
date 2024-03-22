package com.youngzy.kim.basic;

/**
 * DCL: Double-Checked Locking
 *
 * Java 1.5 之后的内存模型才能保证正确工作
 *
 * @author youngzy
 * @since 2023-04-28
 */
public class SingletonDCL {
    private static volatile SingletonDCL instance = null;

    private SingletonDCL() {}

    public static SingletonDCL getInstance() {
        if (instance == null) {
            synchronized (SingletonDCL.class) {
                if (instance == null) {
                    instance = new SingletonDCL();
                }
            }
        }
        return instance;
    }
}
