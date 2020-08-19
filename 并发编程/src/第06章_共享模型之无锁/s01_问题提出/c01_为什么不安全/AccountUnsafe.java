package 第06章_共享模型之无锁.s01_问题提出.c01_为什么不安全;

//有如下需求，保证 account.withdraw 取款方法的线程安全
//该实现并不是线程安全的
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
