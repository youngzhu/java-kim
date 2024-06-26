package com.youngzy.kim.sort;

/**
 * 冒泡排序
 *
 * 时间复杂度：O(N^2)
 */
public class BubbleSort implements ISort {
    /*
    冒泡：将数组顺时针旋转90度，想象成一个水桶，越小的气泡（数字）越快往上浮

         ****   /\
    a[0] *  *   ||
         ****   ||
         *  *   ||
         ****   ||
         *  *   ||
         ****   ||
    a[n] *  *   ||
         ****
     */
    @Override
    public void sort(int[] a) {
        for (int i = 0; i < a.length; i++) { // 为 a[i] 找到正确的元素
            for (int j = a.length - 1; j > i; j--) {
                if (a[j] < a[j -1]) {
                    swap(a, j, j - 1);
                }
            }
        }
    }

    private void swap(int[] a, int j, int i) {
        int t = a[j];
        a[j] = a[i];
        a[i] = t;
    }
}
