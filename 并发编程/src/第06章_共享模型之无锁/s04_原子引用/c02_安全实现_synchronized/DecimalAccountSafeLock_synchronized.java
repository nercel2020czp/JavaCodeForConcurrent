package 第06章_共享模型之无锁.s04_原子引用.c02_安全实现_synchronized;

import java.math.BigDecimal;

import 第06章_共享模型之无锁.s04_原子引用.DecimalAccount;

public class DecimalAccountSafeLock_synchronized implements DecimalAccount {
	private final Object lock = new Object();
	BigDecimal balance;

	public DecimalAccountSafeLock_synchronized(BigDecimal balance) {
		this.balance = balance;
	}

	@Override
	public BigDecimal getBalance() {
		return balance;
	}

	@Override
	public void withdraw(BigDecimal amount) {
		synchronized (lock) {
			BigDecimal balance = this.getBalance();
			this.balance = balance.subtract(amount);
		}
	}
}
