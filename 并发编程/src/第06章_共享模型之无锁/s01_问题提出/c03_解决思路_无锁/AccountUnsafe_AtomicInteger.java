package ��06��_����ģ��֮����.s01_�������.c03_���˼·_����;

//���������󣬱�֤ account.withdraw ȡ������̰߳�ȫ
//��ʵ�ֲ������̰߳�ȫ��
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

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
		long start = System.nanoTime();
		for (int i = 0; i < 10000; i++) {
			ts.add(new Thread(() -> {
				account.withdraw(10);
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
		long end = System.nanoTime();
		System.out.println(account.getBalance() + " cost: " + (end - start) / 1000_000 + " ms");
	}
}

public class AccountUnsafe_AtomicInteger implements Account {
	private AtomicInteger balance;

	public AccountUnsafe_AtomicInteger(Integer balance) {
		this.balance = new AtomicInteger(balance);
	}

	@Override
	public Integer getBalance() {
		return balance.get();
	}

	@Override
	public void withdraw(Integer amount) {
		while (true) {
			int prev = balance.get();
			int next = prev - amount;
			if (balance.compareAndSet(prev, next)) {
				break;
			}
		}
		// ���Լ�Ϊ����ķ���
		// balance.addAndGet(-1 * amount);
	}

	public static void main(String[] args) {
		Account.demo(new AccountUnsafe_AtomicInteger(100000));
	}
}
