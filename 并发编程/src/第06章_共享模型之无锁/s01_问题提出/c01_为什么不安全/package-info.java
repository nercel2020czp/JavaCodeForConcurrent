/**
 * 
 */
/**
 * @author 15753
 *
 */
package 第06章_共享模型之无锁.s01_问题提出.c01_为什么不安全;

/*
withdraw 方法

	public void withdraw(Integer amount) {
		balance -= amount;
	}
	
对应的字节码
	ALOAD 0 // <- this
	ALOAD 0
	GETFIELD cn/itcast/AccountUnsafe.balance : Ljava/lang/Integer; // <- this.balance
	INVOKEVIRTUAL java/lang/Integer.intValue ()I // 拆箱
	ALOAD 1 // <- amount
	INVOKEVIRTUAL java/lang/Integer.intValue ()I // 拆箱
	ISUB // 减法
	INVOKESTATIC java/lang/Integer.valueOf (I)Ljava/lang/Integer; // 结果装箱
	PUTFIELD cn/itcast/AccountUnsafe.balance : Ljava/lang/Integer; // -> this.balance
	
多线程执行流程
	ALOAD 0 // thread-0 <- this
	ALOAD 0
	GETFIELD cn/itcast/AccountUnsafe.balance // thread-0 <- this.balance
	INVOKEVIRTUAL java/lang/Integer.intValue // thread-0 拆箱
	ALOAD 1 // thread-0 <- amount
	INVOKEVIRTUAL java/lang/Integer.intValue // thread-0 拆箱
	ISUB // thread-0 减法
	INVOKESTATIC java/lang/Integer.valueOf // thread-0 结果装箱
	PUTFIELD cn/itcast/AccountUnsafe.balance // thread-0 -> this.balance
	ALOAD 0 // thread-1 <- this
	ALOAD 0
	GETFIELD cn/itcast/AccountUnsafe.balance // thread-1 <- this.balance
	INVOKEVIRTUAL java/lang/Integer.intValue // thread-1 拆箱
	ALOAD 1 // thread-1 <- amount
	INVOKEVIRTUAL java/lang/Integer.intValue // thread-1 拆箱
	ISUB // thread-1 减法
	INVOKESTATIC java/lang/Integer.valueOf // thread-1 结果装箱
	PUTFIELD cn/itcast/AccountUnsafe.balance // thread-1 -> this.balance
	
单核的指令交错
多核的指令交错



*/