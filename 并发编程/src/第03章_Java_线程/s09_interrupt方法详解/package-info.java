/**
 * 
 */
/**
 * @author 15753
 *
 */
package ��03��_Java_�߳�.s09_interrupt�������;
/*
https://www.cnblogs.com/gosaint/p/9111189.html
����֮�߳��Լ��̵߳��ж�״̬�����ǳ���Ҫ��
https://www.cnblogs.com/gosaint/p/9111189.html
	�������������Ƿֱ�����˲�ͬ���̵߳Ĳ�ͬ״̬�¶����ж�����ķ�Ӧ��NEW��TERMINATED�����жϲ������������εģ�
	RUNNABLE��BLOCKED���ƣ������жϲ���ֻ�������жϱ�־λ��û��ǿ����ֹ�̣߳������̵߳���ֹȨ����Ȼ�ڳ������С�
	WAITING/TIMED_WAITING״̬�µ��̶߳����жϲ��������еģ����ǻ��׳��쳣������жϱ�־λ��


��Core Java��������һ�仰��
"û���κ����Է��������Ҫ��һ�����жϵĳ���Ӧ����ֹ��
�ж�һ���߳�ֻ��Ϊ��������̵߳�ע�⣬���ж��߳̿��Ծ������Ӧ���ж� "��
�ú������仰�ĺ��壬��������Ĵ��룺
//Interrupted�ľ���ʹ�ô���    

public void run(){    
    try{    
         ....    
         while(!Thread.currentThread().isInterrupted() && more work to do){    
             // do more work;    
         }    
    } catch(InterruptedException e){    
             // thread was interrupted during sleep or wait    
    } finally {    
             // cleanup, if required    
    }    
}    

      ����Ȼ������������У�whileѭ����һ���������ؾ�����Ҫ��ͣ�ļ���Լ����ж�״̬��
      ���ⲿ�̵߳��ø��̵߳�interrupt ʱ��ʹ���ж�״̬��λ�����Ǹ��߳̽���ֹѭ��������ִ��ѭ���е�do more work�ˡ�

      ��˵��: interrupt�жϵ����̵߳�ĳһ����ҵ���߼���ǰ�����߳���Ҫ����Լ����ж�״̬(isInterrupted())��

      ���ǵ�th1��������ʱ�򣬱��类Object.wait, Thread.join��Thread.sleep���ַ���֮һ����ʱ��
      ��������interrput()�����������֪��û��ռ��CPU���е��߳��ǲ��� �ܸ��Լ����ж�״̬��λ�ġ�
      ��ͻ����һ��InterruptedException�쳣��

*/