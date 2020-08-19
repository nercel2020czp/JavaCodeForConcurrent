package ��06��_����ģ��֮����.s02_CAS��volatile;

//���������󣬱�֤ account.withdraw ȡ������̰߳�ȫ
//��ʵ�ֲ������̰߳�ȫ��
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

interface Account {
	// ��ȡ���
	Integer getBalance();

	// ȡ��
	void withdraw(Integer amount);

	/**
	 * �����ڻ����� 1000 ���̣߳�ÿ���߳��� -10 Ԫ �Ĳ��� �����ʼ���Ϊ 10000 ��ô��ȷ�Ľ��Ӧ���� 0
	 */
	static void demo(Account account) {
		List<Thread> ts = new ArrayList<>();
		long start = System.nanoTime();
		for (int i = 0; i < 10000; i++) {
			ts.add(new Thread(() -> {
				account.withdraw(10);
			}));
		}
		ts.forEach(Thread::start);
		ts.forEach(t -> {
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		long end = System.nanoTime();
		System.out.println(account.getBalance() + " cost: " + (end - start) / 1000_000 + " ms");
	}
}

public class AccountUnsafe_CAS implements Account {
	private AtomicInteger balance;

	public AccountUnsafe_CAS(Integer balance) {
		this.balance = new AtomicInteger(balance);
	}

	@Override
	public Integer getBalance() {
		return balance.get();
	}

	@Override
	public void withdraw(Integer amount) {
		while (true) {
			// ��Ҫ���ϳ��ԣ�ֱ���ɹ�Ϊֹ
			while (true) {
				// �����õ��˾�ֵ 1000
				int prev = balance.get();
				// ����������� 1000-10 = 990
				int next = prev - amount;
				/*
				compareAndSet �����������飬�� set ǰ���ȱȽ� prev �뵱ǰֵ
				- ��һ���ˣ�next ���ϣ����� false ��ʾʧ��
				���磬����߳��Ѿ����˼�������ǰֵ�Ѿ��������� 990
				��ô���̵߳���� 990 �������ˣ����� while �´�ѭ������
				- һ�£��� next ����Ϊ��ֵ������ true ��ʾ�ɹ�
				*/
				if (balance.compareAndSet(prev, next)) {
					break;
				}
			}
		}
	}

	public static void main(String[] args) {
		Account.demo(new AccountUnsafe_CAS(100000));
	}
}
