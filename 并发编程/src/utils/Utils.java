package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
	public static void log(String str) {
		Date now=new Date();    //创建一个Date对象，获取当前时间
        //指定格式化格式
        SimpleDateFormat f=new SimpleDateFormat("yyyy年MM月dd日  - HH:mm:ss.SSS");
        String time = f.format(now);
        String threadName = Thread.currentThread().getName();
        System.out.println(time + " - " + threadName + " - " + str);    //将当前时间袼式化为指定的格式
	}
}
