package ch14;

import java.io.File;

public class FileCounter {

	public static void main(String[] args) throws Exception {
		System.out.println(
				"Ŀ¼�¹���" + count(new File("c:\\myweb")) + "���ļ�");
	}

	public static int count(File file) throws Exception {
		if (file.exists()) {
			if (file.isDirectory()) {
				String[] files = file.list();
				if (files.length == 0) {
					return 0;
				} else {
					int filenum = 0;
					for (int i = 0; i < files.length; i++) {
						filenum += count(new File(file, files[i]));
					}
					return filenum;
				}
			} else {
				return 1;
			}
		} else {
			return 0;
		}
	}
}
