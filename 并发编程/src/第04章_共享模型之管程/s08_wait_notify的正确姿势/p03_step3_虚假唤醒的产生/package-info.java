/**
 * 
 */
/**
 * @author 15753
 *
 */
package 第04章_共享模型之管程.s08_wait_notify的正确姿势.p03_step3_虚假唤醒的产生;

/*
notify 只能随机唤醒一个 WaitSet 中的线程，这时如果有其它线程也在等待，
那么就可能唤醒不了正确的线程，称之为【虚假唤醒】

解决方法，改为 notifyAll

*/