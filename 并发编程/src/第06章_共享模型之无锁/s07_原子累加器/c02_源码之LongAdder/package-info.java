/**
 * 
 */
/**
 * @author 15753
 *
 */
package ��06��_����ģ��֮����.s07_ԭ���ۼ���.c02_Դ��֮LongAdder;
/*
����������ԭ��ܼ򵥣��������о���ʱ�����ö���ۼӵ�Ԫ��Therad-0 �ۼ� Cell[0]���� Thread-1 �ۼ�
Cell[1]... ��󽫽�����ܡ������������ۼ�ʱ�����Ĳ�ͬ�� Cell ��������˼����� CAS ����ʧ�ܣ��Ӷ������
�ܡ�

LongAdder �ǲ�����ʦ @author Doug Lea ����������Ʒ����Ƶķǳ�����
LongAdder ���м����ؼ���

// �ۼӵ�Ԫ����, �����ʼ��
transient volatile Cell[] cells;
// ����ֵ, ���û�о���, ���� cas �ۼ������
transient volatile long base;
// �� cells ����������ʱ, ��Ϊ 1, ��ʾ����
transient volatile int cellsBusy;



*/