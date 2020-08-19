/**
 * 
 */
/**
 * @author 15753
 *
 */
package 第06章_共享模型之无锁.s07_原子累加器.c02_源码之LongAdder;
/*
性能提升的原因很简单，就是在有竞争时，设置多个累加单元，Therad-0 累加 Cell[0]，而 Thread-1 累加
Cell[1]... 最后将结果汇总。这样它们在累加时操作的不同的 Cell 变量，因此减少了 CAS 重试失败，从而提高性
能。

LongAdder 是并发大师 @author Doug Lea （大哥李）的作品，设计的非常精巧
LongAdder 类有几个关键域

// 累加单元数组, 懒惰初始化
transient volatile Cell[] cells;
// 基础值, 如果没有竞争, 则用 cas 累加这个域
transient volatile long base;
// 在 cells 创建或扩容时, 置为 1, 表示加锁
transient volatile int cellsBusy;



*/