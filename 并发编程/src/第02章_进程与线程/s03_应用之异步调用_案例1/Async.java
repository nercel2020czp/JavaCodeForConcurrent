package ��02��_�������߳�.s03_Ӧ��֮�첽����_����1;

import utils.Utils;

public class Async {
	final static String MP4_FULL_PATH = "D:\\WPF_JJDown_v1.212.1\\[WPF]JJDown\\Download\\Hello-art--Adele--art.mp4";

/*	2. ����ȴ����
	��ʱ�����ʹ���첽������
	1. ��ͨ�߳�ʵ��*/
	
	//ʹ�����̺߳󣬷����ĵ���ʱ�첽�ģ�
	public static void main(String[] args) {
		new Thread(() -> FileReader.read(MP4_FULL_PATH)).start();
		Utils.log("do other things ...");
	}
}
