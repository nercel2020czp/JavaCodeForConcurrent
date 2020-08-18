package ��02��_�������߳�.s03_Ӧ��֮�첽����_����1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import utils.Utils;

public class FileReader {
	public static void read(String filename) {
		int idx = filename.lastIndexOf(File.separator);
		String shortName = filename.substring(idx + 1);
		try (FileInputStream in = new FileInputStream(filename)) {
			long start = System.currentTimeMillis();
			Utils.log("read [" + shortName + "] start ...");
			byte[] buf = new byte[1024];
			int n = -1;
			do {
				n = in.read(buf);
			} while (n != -1);
			long end = System.currentTimeMillis();
			Utils.log("read [" + shortName + "] end ... cost: " + (end - start) + " ms" );
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
