/**
 * 
 */
/**
 * @author 15753
 *
 */
package 第04章_共享模型之管程.s08_wait_notify的正确姿势.p04_step4_虚假唤醒的解决;

/*

notify 只能随机唤醒一个 WaitSet 中的线程，这时如果有其它线程也在等待，那么就可能唤醒不了正确的线
程，称之为【虚假唤醒】
解决方法，改为 notifyAll

输出:
	20:55:23.978 [小南] c.TestCorrectPosture - 有烟没？[false]
	20:55:23.982 [小南] c.TestCorrectPosture - 没烟，先歇会！
	20:55:23.982 [小女] c.TestCorrectPosture - 外卖送到没？[false]
	20:55:23.982 [小女] c.TestCorrectPosture - 没外卖，先歇会！
	20:55:24.979 [送外卖的] c.TestCorrectPosture - 外卖到了噢！
	20:55:24.979 [小女] c.TestCorrectPosture - 外卖送到没？[true]
	20:55:24.980 [小女] c.TestCorrectPosture - 可以开始干活了
	20:55:24.980 [小南] c.TestCorrectPosture - 有烟没？[false]
	20:55:24.980 [小南] c.TestCorrectPosture - 没干成活...
	
用 notifyAll 仅解决某个线程的唤醒问题，但使用 if + wait 判断仅有一次机会，一旦条件不成立，就没有重新
判断的机会了
解决方法，用 while + wait，当条件不成立，再次 wait

*/