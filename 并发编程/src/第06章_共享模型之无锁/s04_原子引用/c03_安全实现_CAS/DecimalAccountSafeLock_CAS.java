package 第06章_共享模型之无锁.s04_原子引用.c03_安全实现_CAS;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicReference;

import 第06章_共享模型之无锁.s04_原子引用.DecimalAccount;

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