package 第02章_进程与线程.s03_应用之异步调用_案例1;
//没有用线程时，方法的调用是同步的：
import utils.Utils;

public class Sync {
	//没有用线程时，方法的调用是同步的：
	public static void main(String[] args) {
		String fullPath = "D:\\WPF_JJDown_v1.212.1\\[WPF]JJDown\\Download\\Hello-art--Adele--art.mp4";
		FileReader.read(fullPath);
		Utils.log("do other things ...");
	}
}
