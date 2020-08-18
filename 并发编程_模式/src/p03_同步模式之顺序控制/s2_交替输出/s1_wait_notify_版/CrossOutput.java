package p03_同步模式之顺序控制.s2_交替输出.s1_wait_notify_版;


public class CrossOutput {
	final static Object obj = new Object();//锁对象 
	static int flag = 1;
	
	static void print(String str, int cur) {
		for(char c : str.toCharArray()) {
			synchronized (obj) {
				while(flag != cur) {
					try {
						//这个地方不要设置无限等待
						obj.wait(100);
						break;
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.print(c);
				flag = (cur == 1 ? 2 : 1);
				obj.notifyAll();
			}
		}
	}
	
	public static void main(String[] args) {
		String str1 = "123456789", str2 = "ABCDE";
		new Thread(() -> print(str1, 1)).start();
		new Thread(() -> print(str2, 2)).start();
	}

}
