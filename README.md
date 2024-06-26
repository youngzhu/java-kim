# 应该牢记的代码/值得背诵的代码（keep-in-mind）

早就有这样的想法，整理一些精妙的值得背诵的代码。一直拖着。  
直到《算法之美》这本书，让我付出了行动。

## 基础知识
### volatile
只能保证可见性，不保证原子性，参见

## 排序
- [x] [冒泡排序](src/main/java/com/youngzy/sort/BubbleSort.java)
- [x] [插入排序](src/main/java/com/youngzy/sort/InsertSort.java)
- [x] [比较计数排序](src/main/java/com/youngzy/sort/CompareCountSort.java)
    + 定义：每个排序对象都会与其他对象做比较，从而统计出比该排序对象小的对象一共有多少个。这个数字可以直接表示该排序对象的排名。
    + 优点：容错能力强。对应到比赛中就是公平。不会有输掉一局就输掉整个比赛的问题。
- [ ] 合并排序
    + 特点：分治。
- [ ] 合并排序（并行）
- [ ] 桶排序（这不是精确的排序，更像是一种分类）
    + 定义：将n个对象放到m个桶里。时间O(mn)，m较小时就是O(n)，线性时间。难点在于m的选择。常用于大型的图书馆系统整理图书。m就是某个楼层或者书架。

## 其他
- [约瑟夫环（优雅的解法）](src/main/java/com/youngzy/Josephus.java)

