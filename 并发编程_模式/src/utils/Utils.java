package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
	public static void log(String str) {
		Date now=new Date();    //����һ��Date���󣬻�ȡ��ǰʱ��
        //ָ����ʽ����ʽ
        SimpleDateFormat f=new SimpleDateFormat("yyyy��MM��dd��  - HH:mm:ss.SSS");
        String time = f.format(now);
        String threadName = Thread.currentThread().getName();
        System.out.println(time + " - " + threadName + " - " + str);    //����ǰʱ����ʽ��Ϊָ���ĸ�ʽ
	}
}
