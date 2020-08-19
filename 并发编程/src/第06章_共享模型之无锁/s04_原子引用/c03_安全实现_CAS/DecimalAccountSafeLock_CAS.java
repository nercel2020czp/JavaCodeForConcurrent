package ��06��_����ģ��֮����.s04_ԭ������.c03_��ȫʵ��_CAS;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicReference;

import ��06��_����ģ��֮����.s04_ԭ������.DecimalAccount;

public class DecimalAccountSafeLock_CAS implements DecimalAccount {
	AtomicReference<BigDecimal> ref;

	public DecimalAccountSafeLock_CAS(BigDecimal balance) {
		ref = new AtomicReference<>(balance);
	}

	@Override
	public BigDecimal getBalance() {
		return ref.get();
	}

	@Override
	public void withdraw(BigDecimal amount) {
		while (true) {
			BigDecimal prev = ref.get();
			BigDecimal next = prev.subtract(amount);
			if (ref.compareAndSet(prev, next)) {
				break;
			}
		}
	}
}