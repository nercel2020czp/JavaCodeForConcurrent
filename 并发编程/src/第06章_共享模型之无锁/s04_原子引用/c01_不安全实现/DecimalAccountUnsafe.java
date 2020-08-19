package 第06章_共享模型之无锁.s04_原子引用.c01_不安全实现;

import java.math.BigDecimal;

import 第06章_共享模型之无锁.s04_原子引用.DecimalAccount;

public class DecimalAccountUnsafe implements DecimalAccount {
	BigDecimal balance;

	public DecimalAccountUnsafe(BigDecimal balance) {
		this.balance = balance;
	}

	@Override
	public BigDecimal getBalance() {
		return balance;
	}

	@Override
	public void withdraw(BigDecimal amount) {
		BigDecimal balance = this.getBalance();
		this.balance = balance.subtract(amount);
	}
}
