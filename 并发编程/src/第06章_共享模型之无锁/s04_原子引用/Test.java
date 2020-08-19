package 第06章_共享模型之无锁.s04_原子引用;

import java.math.BigDecimal;

import 第06章_共享模型之无锁.s04_原子引用.c01_不安全实现.DecimalAccountUnsafe;
import 第06章_共享模型之无锁.s04_原子引用.c02_安全实现_synchronized.DecimalAccountSafeLock_synchronized;
import 第06章_共享模型之无锁.s04_原子引用.c03_安全实现_CAS.DecimalAccountSafeLock_CAS;

public class Test {
	
	public static void main(String[] args) {
		DecimalAccount.demo(new DecimalAccountUnsafe(new BigDecimal("10000")));
		DecimalAccount.demo(new DecimalAccountSafeLock_synchronized(new BigDecimal("10000")));
		DecimalAccount.demo(new DecimalAccountSafeLock_CAS(new BigDecimal("10000")));
	}

}
