package ��06��_����ģ��֮����.s04_ԭ������;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public interface DecimalAccount {
	// ��ȡ���
	BigDecimal getBalance();

	// ȡ��
	void withdraw(BigDecimal amount);

	/**
	 * �����ڻ����� 1000 ���̣߳�ÿ���߳��� -10 Ԫ �Ĳ��� 
	 * �����ʼ���Ϊ 10000 ��ô��ȷ�Ľ��Ӧ���� 0
	 */
	static void demo(DecimalAccount account) {
		List<Thread> ts = new ArrayList<>();
		for (int i = 0; i < 1000; i++) {
			ts.add(new Thread(() -> {
				account.withdraw(BigDecimal.TEN);
			}));
		}
		ts.forEach(Thread::start);
		ts.forEach(t -> {
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		System.out.println(account.getBalance());
	}
}
