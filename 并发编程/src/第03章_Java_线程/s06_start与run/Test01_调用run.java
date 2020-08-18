package 第03章_Java_线程.s06_start与run;
//程序仍在 main 线程运行， FileReader.read() 方法调用还是同步的
import utils.Utils;

public class Test01_调用run {

	public static void main(String[] args) {

		Thread t1 = new Thread("t1") {
			@Override
			public void run() {
				Utils.log("");
//				FileReader.read(Constants.MP4_FULL_PATH);
				//FileReader.read() 方法调用还是同步的
			}
		};
		t1.run();
		Utils.log("do other things ...");
	}

}
