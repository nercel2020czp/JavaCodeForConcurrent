package 第04章_共享模型之管程.s08_wait_notify的正确姿势.p06_同步模式之保护性暂停;
/*join 原理
是调用者轮询检查线程 alive 状态

t1.join();

//等价于下面的代码:

	synchronized (t1) {
		// 调用者线程进入 t1 的 waitSet 等待, 直到 t1 运行结束
		while (t1.isAlive()) {
			t1.wait(0);
		}
	}

注意
join 体现的是【保护性暂停】模式，请参考之

*/
public class Test05_原理之join {

}
