package a03_����.s01_���ۻ���;
/*1. ���ۻ���
	����ʵ���Ǳ�������˼��
	���磬������ȡ�������*/

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

class AccountSync implements Account {
	private Integer balance;

	public AccountSync(Integer balance) {
		this.balance = balance;
	}

	@Override
	public Integer getBalance() {
		synchronized (this) {
			return this.balance;
		}
	}

	@Override
	public void withdraw(Integer amount) {
		synchronized (this) {
			this.balance -= amount;
		}
	}
}

public class Test01 {

	public static void main(String[] args) {
		
		Account.demo(new AccountSync(10000));

	}

}
