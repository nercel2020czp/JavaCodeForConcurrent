/**
 * 
 */
/**
 * @author 15753
 *
 */
package ��06��_����ģ��֮����.s04_ԭ������.c04_ABA���⼰���.c02_AtomicStampedReference;
/*

���Ϊ:
	15:41:34.891 c.Test36 [main] - main start...
	15:41:34.894 c.Test36 [main] - �汾 0
	15:41:34.956 c.Test36 [t1] - change A->B true
	15:41:34.956 c.Test36 [t1] - ���°汾Ϊ 1
	15:41:35.457 c.Test36 [t2] - change B->A true
	15:41:35.457 c.Test36 [t2] - ���°汾Ϊ 2
	15:41:36.457 c.Test36 [main] - change A->C false

AtomicStampedReference ���Ը�ԭ�����ü��ϰ汾�ţ�׷��ԭ�����������ı仯���̣��磺 A -> B -> A ->
C ��ͨ��AtomicStampedReference�����ǿ���֪�������ñ�����;�������˼��Ρ�

������ʱ�򣬲����������ñ��������˼��Σ�ֻ�ǵ����Ĺ����Ƿ���Ĺ������Ծ�����
AtomicMarkableReference

*/