/**
 * 
 */
/**
 * @author 15753
 *
 */
package c11_AQS_原理.c03_心得.c02_AQS目标;

/*
AQS 要实现的功能目标
	1.阻塞版本获取锁 acquire 和非阻塞的版本尝试获取锁 tryAcquire
	2.获取锁超时机制
	3.通过打断取消机制
	4.独占机制及共享机制
	5.条件不满足时的等待机制
	
要实现的性能目标
Instead, the primary performance goal here is scalability: to predictably maintain efficiency even, or
especially, when synchronizers are contended.


相反，此处的主要性能目标是可伸缩性：即使在竞争同步器的情况下，也可预测地保持效率。



*/