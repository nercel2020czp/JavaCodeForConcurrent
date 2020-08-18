package 第04章_共享模型之管程.s02_synchronized解决方案;
/*

思考:
	synchronized 实际是用对象锁保证了临界区内代码的原子性，临界区内的代码对外是不可分割的，
	不会被线程切换所打断。
	为了加深理解，请思考下面的问题
		1.如果把 synchronized(obj) 放在 for 循环的外面，如何理解？-- 原子性
		2.如果 t1 synchronized(obj1) 而 t2 synchronized(obj2) 会怎样运作？-- 锁对象
		3.如果 t1 synchronized(obj) 而 t2 没有加会怎么样？如何理解？-- 锁对象


*/
public class Test03_思考 {

}
