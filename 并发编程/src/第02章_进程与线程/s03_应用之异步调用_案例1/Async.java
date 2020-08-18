package 第02章_进程与线程.s03_应用之异步调用_案例1;

import utils.Utils;

public class Async {
	final static String MP4_FULL_PATH = "D:\\WPF_JJDown_v1.212.1\\[WPF]JJDown\\Download\\Hello-art--Adele--art.mp4";

/*	2. 不需等待结果
	这时最好是使用异步来处理
	1. 普通线程实现*/
	
	//使用了线程后，方法的调用时异步的：
	public static void main(String[] args) {
		new Thread(() -> FileReader.read(MP4_FULL_PATH)).start();
		Utils.log("do other things ...");
	}
}
