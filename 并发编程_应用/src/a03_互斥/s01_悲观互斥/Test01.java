package a03_互斥.s01_悲观互斥;
/*1. 悲观互斥
	互斥实际是悲观锁的思想
	例如，有下面取款的需求*/

import java.util.ArrayList;
import java.util.List;

interface Account {
	// 获取余额
	Integer getBalance();

	// 取款
	void withdraw(Integer amount);

	/**
	 * 方法内会启动 1000 个线程，每个线程做 -10 元 的操作 如果初始余额为 10000 那么正确的结果应当是 0
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
