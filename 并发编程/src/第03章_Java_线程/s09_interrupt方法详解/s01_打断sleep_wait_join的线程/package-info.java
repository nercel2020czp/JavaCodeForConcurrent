/**
 * 
 */
/**
 * @author 15753
 *
 */
package ��03��_Java_�߳�.s09_interrupt�������.s01_���sleep_wait_join���߳�;
/*
��� sleep��wait��join ���߳�
	�⼸�������������߳̽�������״̬
	��� sleep ���߳�, ����մ��״̬���� sleep Ϊ��

���:
	java.lang.InterruptedException: sleep interrupted
	at java.lang.Thread.sleep(Native Method)
	at java.lang.Thread.sleep(Thread.java:340)
	at java.util.concurrent.TimeUnit.sleep(TimeUnit.java:386)
	at cn.itcast.n2.util.Sleeper.sleep(Sleeper.java:8)
	at cn.itcast.n4.TestInterrupt.lambda$test1$3(TestInterrupt.java:59)
	at java.lang.Thread.run(Thread.java:745)
	21:18:10.374 [main] c.TestInterrupt - ���״̬: false

*/