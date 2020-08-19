package ��06��_����ģ��֮����.s04_ԭ������.c02_��ȫʵ��_synchronized;

import java.math.BigDecimal;

import ��06��_����ģ��֮����.s04_ԭ������.DecimalAccount;

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
