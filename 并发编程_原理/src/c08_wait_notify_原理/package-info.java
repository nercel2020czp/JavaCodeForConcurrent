/**
 * 
 */
/**
 * @author 15753
 *
 */
package c08_wait_notify_原理;
/*
1.Owner 线程发现条件不满足，调用 wait 方法，即可进入 WaitSet 变为 WAITING 状态
2.BLOCKED 和 WAITING 的线程都处于阻塞状态，不占用 CPU 时间片
3.BLOCKED 线程会在 Owner 线程释放锁时唤醒
4.WAITING 线程会在 Owner 线程调用 notify 或 notifyAll 时唤醒，但唤醒后并不意味者立刻获得锁，仍需进入
  EntryList 重新竞争



*/