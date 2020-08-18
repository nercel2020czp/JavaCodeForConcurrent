/**
 * 
 */
/**
 * @author 15753
 *
 */
package 第04章_共享模型之管程.s13_ReentrantLock.c05_条件变量;
/*条件变量
synchronized 中也有条件变量，就是我们讲原理时那个 waitSet 休息室，
当条件不满足时进入 waitSet 等待ReentrantLock 的条件变量比 synchronized 强大之处在于，
它是支持多个条件变量的，这就好比synchronized 是那些不满足条件的线程都在一间休息室等消息
而 ReentrantLock 支持多间休息室，有专门等烟的休息室、专门等早餐的休息室、唤醒时也是按休息室来唤醒

使用要点：
	await 前需要获得锁
	await 执行后，会释放锁，进入 conditionObject 等待
	await 的线程被唤醒（或打断、或超时）取重新竞争 lock 锁
	竞争 lock 锁成功后，从 await 后继续执行

输出
18:52:27.680 [main] c.TestCondition - 送早餐来了
18:52:27.682 [Thread-1] c.TestCondition - 等到了它的早餐
18:52:28.683 [main] c.TestCondition - 送烟来了
18:52:28.683 [Thread-0] c.TestCondition - 等到了它的烟
*/