package com.youngzy.kim.basic;

/**
 * Lazy Initialization Holder Class 惯用法
 *
 * 由 Java 规范保证：
 * - Class Loading 懒加载
 * - 初始化过程线程安全
 *
 * @author youngzy
 * @since 2023-04-28
 */
public class Singleton {
    private final static class SingletonHolder {
        // 在 SingletonHolder.<clinit> 中初始化
        private static Singleton instance = new Singleton();
    }

    public static Singleton instance() {
        return SingletonHolder.instance;
    }
}
