/**
 * 
 */
/**
 * @author 15753
 *
 */
package ��06��_����ģ��֮����.s04_ԭ������.c04_ABA���⼰���.c03_AtomicMarkableReference;

/*
AtomicStampedReference ���Ը�ԭ�����ü��ϰ汾�ţ�׷��ԭ�����������ı仯���̣��磺 A -> B -> A ->
C ��ͨ��AtomicStampedReference�����ǿ���֪�������ñ�����;�������˼��Ρ�

������ʱ�򣬲����������ñ��������˼��Σ�ֻ�ǵ����Ĺ����Ƿ���Ĺ������Ծ�����
AtomicMarkableReference

���
2019-10-13 15:30:09.264 [main] ���߳� start...
2019-10-13 15:30:09.270 [main] cn.itcast.GarbageBag@5f0fd5a0 װ��������
2019-10-13 15:30:09.293 [Thread-1] ��ɨ�������߳� start...
2019-10-13 15:30:09.294 [Thread-1] cn.itcast.GarbageBag@5f0fd5a0 ��������
2019-10-13 15:30:10.294 [main] ���߳��뻻һֻ����������
2019-10-13 15:30:10.294 [main] ����ô��false
2019-10-13 15:30:10.294 [main] cn.itcast.GarbageBag@5f0fd5a0 ��������
����ע�͵���ɨ�����̴߳��룬�ٹ۲����
*/