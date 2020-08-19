package ��06��_����ģ��֮����.s04_ԭ������.c01_����ȫʵ��;

import java.math.BigDecimal;

import ��06��_����ģ��֮����.s04_ԭ������.DecimalAccount;

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
