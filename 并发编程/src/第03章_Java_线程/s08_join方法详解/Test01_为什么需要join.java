package 第03章_Java_线程.s08_join方法详解;
/*分析
	因为主线程和线程 t1 是并行执行的，t1 线程需要 1 秒之后才能算出 r=10
	而主线程一开始就要打印 r 的结果，所以只能打印出 r=0
	
解决方法
	用 sleep 行不行？为什么？
		不太好，不行，因为你不知道子线程要执行多长时间，那么主线程要等多久？
	用 join，加在 t1.start() 之后即可

join()
	等待线程运行结束
join(long n)
	等待线程运行结束,最多等待 n毫秒
*/
import utils.Utils;

public class Test01_为什么需要join {
	static int r = 0;

	public static void main(String[] args) throws InterruptedException {
		test1();
	}

	private static void test1() throws InterruptedException {
		Utils.log("开始");
		Thread t1 = new Thread(() -> {
			Utils.log("开始");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Utils.log("结束");
			r = 10;
		}, "t1");
		t1.start();
/*		join()
			等待线程运行结束
		join(long n)
			等待线程运行结束,最多等待 n毫秒*/
		t1.join();
//		Thread.sleep(2000);
		Utils.log("结果为:" + r);
		Utils.log("结束");
	}
}
