package ��06��_����ģ��֮����.s04_ԭ������;

import java.math.BigDecimal;

import ��06��_����ģ��֮����.s04_ԭ������.c01_����ȫʵ��.DecimalAccountUnsafe;
import ��06��_����ģ��֮����.s04_ԭ������.c02_��ȫʵ��_synchronized.DecimalAccountSafeLock_synchronized;
import ��06��_����ģ��֮����.s04_ԭ������.c03_��ȫʵ��_CAS.DecimalAccountSafeLock_CAS;

public class Test {
	
	public static void main(String[] args) {
		DecimalAccount.demo(new DecimalAccountUnsafe(new BigDecimal("10000")));
		DecimalAccount.demo(new DecimalAccountSafeLock_synchronized(new BigDecimal("10000")));
		DecimalAccount.demo(new DecimalAccountSafeLock_CAS(new BigDecimal("10000")));
	}

}
