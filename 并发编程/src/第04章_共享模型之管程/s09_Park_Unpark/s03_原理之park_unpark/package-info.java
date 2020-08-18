/**
 * 
 */
/**
 * @author 15753
 *
 */
package 第04章_共享模型之管程.s09_Park_Unpark.s03_原理之park_unpark;
/*

每个线程都有自己的一个 Parker 对象，由三部分组成 _counter ， _cond 和 _mutex 打个比喻

	1.线程就像一个旅人，Parker 就像他随身携带的背包，条件变量就好比背包中的帐篷。_counter 就好比背包中
	     的备用干粮（0 为耗尽，1 为充足）
    2.调用 park 就是要看需不需要停下来歇息
    	2.1 如果备用干粮耗尽，那么钻进帐篷歇息
    	2.2 如果备用干粮充足，那么不需停留，继续前进
	3.调用 unpark，就好比令干粮充足
		3.1 如果这时线程还在帐篷，就唤醒让他继续前进
		3.2 如果这时线程还在运行，那么下次他调用 park 时，仅是消耗掉备用干粮，不需停留继续前进
			3.2.1 因为背包空间有限，多次调用 unpark 仅会补充一份备用干粮

c01_调用park_如果备用干粮耗尽_那么钻进帐篷歇息.png
	1. 当前线程调用 Unsafe.park() 方法
	2. 检查 _counter ，本情况为 0，这时，获得 _mutex 互斥锁
	3. 线程进入 _cond 条件变量阻塞
	4. 设置 _counter = 0

c02_调用park_如果还有备用干粮_那么不需停留_继续前进.png
	1. 当前线程调用 Unsafe.park() 方法
	2. 检查 _counter ，本情况为 1，不需停留【无需阻塞】
	3. 继续前进
	4. 设置 _counter = 0
	
c03_调用unpark_如果这时线程还在帐_就唤醒让他继续前进.png
	1. 调用 Unsafe.unpark(Thread_0) 方法，设置 _counter 为 1
	2. 唤醒 _cond 条件变量中的 Thread_0
	3. Thread_0 恢复运行
	4. 设置 _counter 为 0
	
c04_调用unpark_如果这时线程还在运行_那么下次他调用park时_仅是消耗掉备用干粮_不需停留继续前进.png
	1. 调用 Unsafe.unpark(Thread_0) 方法，设置 _counter 为 1
	2. 当前线程调用 Unsafe.park() 方法
	3. 检查 _counter ，本情况为 1，这时线程无需阻塞，继续运行
	4. 设置 _counter 为 0
	


*/