/**
 * 
 */
/**
 * @author 15753
 *
 */
package ��06��_����ģ��֮����.s01_�������.c01_Ϊʲô����ȫ;

/*
withdraw ����

	public void withdraw(Integer amount) {
		balance -= amount;
	}
	
��Ӧ���ֽ���
	ALOAD 0 // <- this
	ALOAD 0
	GETFIELD cn/itcast/AccountUnsafe.balance : Ljava/lang/Integer; // <- this.balance
	INVOKEVIRTUAL java/lang/Integer.intValue ()I // ����
	ALOAD 1 // <- amount
	INVOKEVIRTUAL java/lang/Integer.intValue ()I // ����
	ISUB // ����
	INVOKESTATIC java/lang/Integer.valueOf (I)Ljava/lang/Integer; // ���װ��
	PUTFIELD cn/itcast/AccountUnsafe.balance : Ljava/lang/Integer; // -> this.balance
	
���߳�ִ������
	ALOAD 0 // thread-0 <- this
	ALOAD 0
	GETFIELD cn/itcast/AccountUnsafe.balance // thread-0 <- this.balance
	INVOKEVIRTUAL java/lang/Integer.intValue // thread-0 ����
	ALOAD 1 // thread-0 <- amount
	INVOKEVIRTUAL java/lang/Integer.intValue // thread-0 ����
	ISUB // thread-0 ����
	INVOKESTATIC java/lang/Integer.valueOf // thread-0 ���װ��
	PUTFIELD cn/itcast/AccountUnsafe.balance // thread-0 -> this.balance
	ALOAD 0 // thread-1 <- this
	ALOAD 0
	GETFIELD cn/itcast/AccountUnsafe.balance // thread-1 <- this.balance
	INVOKEVIRTUAL java/lang/Integer.intValue // thread-1 ����
	ALOAD 1 // thread-1 <- amount
	INVOKEVIRTUAL java/lang/Integer.intValue // thread-1 ����
	ISUB // thread-1 ����
	INVOKESTATIC java/lang/Integer.valueOf // thread-1 ���װ��
	PUTFIELD cn/itcast/AccountUnsafe.balance // thread-1 -> this.balance
	
���˵�ָ���
��˵�ָ���



*/