/**
 * 
 */
/**
 * @author 15753
 *
 */
package 第06章_共享模型之无锁.s02_CAS与volatile.c02_volatile;

/*

volatile
	获取共享变量时，为了保证该变量的可见性，需要使用 volatile 修饰。
	它可以用来修饰成员变量和静态成员变量，他可以避免线程从自己的工作缓存中查找变量的值，必须到主存中获取
	它的值，线程操作 volatile 变量都是直接操作主存。即一个线程对 volatile 变量的修改，对另一个线程可见。
	注意
	volatile 仅仅保证了共享变量的可见性，让其它线程能够看到最新值，但不能解决指令交错问题（不能保证原子性）
	CAS 必须借助 volatile 才能读取到共享变量的最新值来实现【比较并交换】的效果


*/