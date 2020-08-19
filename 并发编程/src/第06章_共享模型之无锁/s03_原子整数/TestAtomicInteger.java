package ��06��_����ģ��֮����.s03_ԭ������;

import java.util.concurrent.atomic.AtomicInteger;

public class TestAtomicInteger {

	public static void main(String[] args) {
		AtomicInteger i = new AtomicInteger(0);
		
		// ��ȡ��������i = 0, ��� i = 1, ���� 0���������� i++
		System.out.println(i.getAndIncrement());
		
		// ��������ȡ��i = 1, ��� i = 2, ���� 2���������� ++i
		System.out.println(i.incrementAndGet());
		
		// �Լ�����ȡ��i = 2, ��� i = 1, ���� 1���������� --i
		System.out.println(i.decrementAndGet());
		
		// ��ȡ���Լ���i = 1, ��� i = 0, ���� 1���������� i--
		System.out.println(i.getAndDecrement());
		
		// ��ȡ����ֵ��i = 0, ��� i = 5, ���� 0��
		System.out.println(i.getAndAdd(5));
		
		// ��ֵ����ȡ��i = 5, ��� i = 0, ���� 0��
		System.out.println(i.addAndGet(-5));
		
		// ��ȡ�����£�i = 0, p Ϊ i �ĵ�ǰֵ, ��� i = -2, ���� 0��
		// ���к����еĲ����ܱ�֤ԭ�ӣ���������Ҫ�޸�����
		System.out.println(i.getAndUpdate(p -> p - 2));
		
		// ���²���ȡ��i = -2, p Ϊ i �ĵ�ǰֵ, ��� i = 0, ���� 0��
		// ���к����еĲ����ܱ�֤ԭ�ӣ���������Ҫ�޸�����
		System.out.println(i.updateAndGet(p -> p + 2));
		
		// ��ȡ�����㣨i = 0, p Ϊ i �ĵ�ǰֵ, x Ϊ����1, ��� i = 10, ���� 0��
		// ���к����еĲ����ܱ�֤ԭ�ӣ���������Ҫ�޸�����
		// getAndUpdate ����� lambda ���������ⲿ�ľֲ�������Ҫ��֤�þֲ������� final ��
		// getAndAccumulate ����ͨ�� ����1 �������ⲿ�ľֲ�����������Ϊ�䲻�� lambda ����˲����� final
		System.out.println(i.getAndAccumulate(10, (p, x) -> p + x));
		
		// ���㲢��ȡ��i = 10, p Ϊ i �ĵ�ǰֵ, x Ϊ����1, ��� i = 0, ���� 0��
		// ���к����еĲ����ܱ�֤ԭ�ӣ���������Ҫ�޸�����
		System.out.println(i.accumulateAndGet(-10, (p, x) -> p + x));
	}

}
