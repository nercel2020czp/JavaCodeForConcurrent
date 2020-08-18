package p03_ͬ��ģʽ֮˳�����.s2_�������.s1_wait_notify_��;


public class CrossOutput {
	final static Object obj = new Object();//������ 
	static int flag = 1;
	
	static void print(String str, int cur) {
		for(char c : str.toCharArray()) {
			synchronized (obj) {
				while(flag != cur) {
					try {
						//����ط���Ҫ�������޵ȴ�
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
