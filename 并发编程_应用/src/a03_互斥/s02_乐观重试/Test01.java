package a03_����.s02_�ֹ�����;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


//����һ�����ֹ���˼�룬����ʵ���ǻ���

interface Account {
	// ��ȡ���
	Integer getBalance();

	// ȡ��
	void withdraw(Integer amount);

	/**
	 * �����ڻ����� 1000 ���̣߳�ÿ���߳��� -10 Ԫ �Ĳ��� �����ʼ���Ϊ 10000 ��ô��ȷ�Ľ��Ӧ���� 0
	 */
	static void demo(Account account) {
		List<Thread> ts = new ArrayList<>();
		for (int i = 0; i < 1000; i++) {
			ts.add(new Thread(() -> {
				account.withdraw(10);
			}));
		}
		long start = System.nanoTime();
		ts.forEach(Thread::start);
		ts.forEach(t -> {
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		long end = System.nanoTime();
		System.out.println(account.getBalance() + " cost: " + (end - start) / 1000_000 + " ms");
	}
}

class AccountCas implements Account {
	private AtomicInteger balance;

	public AccountCas(int balance) {
		this.balance = new AtomicInteger(balance);
	}

	@Override
	public Integer getBalance() {
		return balance.get();
	}

	@Override
	public void withdraw(Integer amount) {
		while (true) {
			// ��ȡ��������ֵ
			int prev = balance.get();
			// Ҫ�޸ĵ����
			int next = prev - amount;
			// �����޸�
			if (balance.compareAndSet(prev, next)) {
				break;
			}
		}
	}
}

public class Test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account.demo(new AccountCas(10000));
	}

}
