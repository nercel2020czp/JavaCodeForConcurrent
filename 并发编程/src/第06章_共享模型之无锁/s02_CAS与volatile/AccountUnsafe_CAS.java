package 第06章_共享模型之无锁.s02_CAS与volatile;

//有如下需求，保证 account.withdraw 取款方法的线程安全
//该实现并不是线程安全的
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

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

public class AccountUnsafe_CAS implements Account {
	private AtomicInteger balance;

	public AccountUnsafe_CAS(Integer balance) {
		this.balance = new AtomicInteger(balance);
	}

	@Override
	public Integer getBalance() {
		return balance.get();
	}

	@Override
	public void withdraw(Integer amount) {
		while (true) {
			// 需要不断尝试，直到成功为止
			while (true) {
				// 比如拿到了旧值 1000
				int prev = balance.get();
				// 在这个基础上 1000-10 = 990
				int next = prev - amount;
				/*
				compareAndSet 正是做这个检查，在 set 前，先比较 prev 与当前值
				- 不一致了，next 作废，返回 false 表示失败
				比如，别的线程已经做了减法，当前值已经被减成了 990
				那么本线程的这次 990 就作废了，进入 while 下次循环重试
				- 一致，以 next 设置为新值，返回 true 表示成功
				*/
				if (balance.compareAndSet(prev, next)) {
					break;
				}
			}
		}
	}

	public static void main(String[] args) {
		Account.demo(new AccountUnsafe_CAS(100000));
	}
}
