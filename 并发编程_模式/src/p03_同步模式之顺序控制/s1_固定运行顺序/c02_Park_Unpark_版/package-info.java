/**
 * 
 */
/**
 * @author 15753
 *
 */
package p03_同步模式之顺序控制.s1_固定运行顺序.c02_Park_Unpark_版;
/*
1.2 Park Unpark 版
可以看到，实现上很麻烦：
首先，需要保证先 wait 再 notify，否则 wait 线程永远得不到唤醒。因此使用了『运行标记』来判断该不该
wait
第二，如果有些干扰线程错误地 notify 了 wait 线程，条件不满足时还要重新等待，使用了 while 循环来解决
此问题
最后，唤醒对象上的 wait 线程需要使用 notifyAll，因为『同步对象』上的等待线程可能不止一个
可以使用 LockSupport 类的 park 和 unpark 来简化上面的题目：


park 和 unpark 方法比较灵活，他俩谁先调用，谁后调用无所谓。并且是以线程为单位进行『暂停』和『恢复』，
不需要『同步对象』和『运行标记』
*/