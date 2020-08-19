package ��06��_����ģ��֮����.s01_�������.c01_Ϊʲô����ȫ;

//���������󣬱�֤ account.withdraw ȡ������̰߳�ȫ
//��ʵ�ֲ������̰߳�ȫ��
import java.util.ArrayList;
import java.util.List;

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
		for (int i = 0; i < 1000; i++) {
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

public class AccountUnsafe implements Account {
	private Integer balance;

	public AccountUnsafe(Integer balance) {
		this.balance = balance;
	}

	@Override
	public synchronized Integer getBalance() {
		return balance;
	}

	@Override
	public synchronized void withdraw(Integer amount) {
		balance -= amount;
	}

	public static void main(String[] args) {
		Account.demo(new AccountUnsafe(10000));
	}
}
