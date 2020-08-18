package 第04章_共享模型之管程.s01_共享带来的问题;
/*
1.一个程序运行多个线程本身是没有问题的:

2.问题出在多个线程访问共享资源:
	2.1 多个线程读共享资源其实也没有问题
	2.2 在多个线程对共享资源读写操作时发生指令交错，就会出现问题
	
3.一段代码块内如果存在对共享资源的多线程读写操作，称这段代码块为临界区

例如，下面代码中的临界区

	static int counter = 0;
	static void increment()// 临界区
	{
	counter++;
	}
	static void decrement()// 临界区
	{
	counter--;
	}




*/
public class Test04_临界区Critical_Section {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
