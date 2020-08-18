package a03_互斥.s02_乐观重试;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


//另外一种是乐观锁思想，它其实不是互斥

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
			// 获取余额的最新值
			int prev = balance.get();
			// 要修改的余额
			int next = prev - amount;
			// 真正修改
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
