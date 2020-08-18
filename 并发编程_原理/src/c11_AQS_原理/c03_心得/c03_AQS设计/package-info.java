/**
 * 
 */
/**
 * @author 15753
 *
 */
package c11_AQS_原理.c03_心得.c03_AQS设计;

/*
AQS 的基本思想其实很简单
获取锁的逻辑

	while(state 状态不允许获取) {
		if(队列中还没有此线程) {
		入队并阻塞
		}
	}
	当前线程出队

释放锁的逻辑:
	if(state 状态允许了) {
		恢复阻塞的线程(s)
	}
	
要点
	原子维护 state 状态
	阻塞及恢复线程
	维护队列

1) state 设计
	state 使用 volatile 配合 cas 保证其修改时的原子性
	state 使用了 32bit int 来维护同步状态，因为当时使用 long 在很多平台下测试的结果并不理想
	
2) 阻塞恢复设计
	早期的控制线程暂停和恢复的 api 有 suspend 和 resume，但它们是不可用的，因为如果先调用的 resume
	那么 suspend 将感知不到
	解决方法是使用 park & unpark 来实现线程的暂停和恢复，具体原理在之前讲过了，先 unpark 再 park 也没问题
	park & unpark 是针对线程的，而不是针对同步器的，因此控制粒度更为精细
	park 线程还可以通过 interrupt 打断
	
3) 队列设计
	使用了 FIFO 先入先出队列，并不支持优先级队列
	设计时借鉴了 CLH 队列，它是一种单向无锁队列

*/