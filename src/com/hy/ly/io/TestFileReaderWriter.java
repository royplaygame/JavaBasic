package com.hy.ly.io;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

public class TestFileReaderWriter {

	@Test
	public void testFileReader() {
		File file = new File("D:\\tmp\\customer1.sql");
		FileReader fr = null;

		try {
			fr = new FileReader(file);

			char[] c = new char[1024];
			int len;
			while ((len = fr.read(c)) != -1) {
				String str = new String(c, 0, len);
				System.out.println(str);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fr != null) {
				try {
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	@Test
	public void testFileWriter() {

		File file = new File("D:\\tmp\\good.txt");
		FileWriter fw = null;
		try {
			fw = new FileWriter(file);
			fw.write(new String("this is good for my card").toCharArray());
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (fw != null) {
				try {
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Test
	public void testFileReaderWriter() {
		File source = new File("D:\\tmp\\work.txt");
		File dest = new File("D:\\tmp\\task.txt");

		FileReader fr = null;
		FileWriter fw = null;
		try {
			fr = new FileReader(source);
			fw = new FileWriter(dest);

			char[] c = new char[100];
			int len;
			while ((len = fr.read(c)) != -1) {
				fw.write(c, 0, len);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (fr != null) {
				try {
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fw != null) {
				try {
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public void copyFile(String source, String dest) {
		FileReader fr = null;
		FileWriter fw = null;
		try {
			fr = new FileReader(new File(source));
			fw = new FileWriter(new File(dest));

			char[] c = new char[100];
			int len;
			while ((len = fr.read(c)) != -1) {
				fw.write(c, 0, len);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (fr != null) {
				try {
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fw != null) {
				try {
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Test
	public void testReader() throws IOException {
		File file = new File("pet.txt");
		Cat cat = new Cat("汤姆猫", "波斯猫", "汤姆斯");
		FileReader fr = new FileReader(file);
		char[] ch = new char[1024];
		int len;
		while ((len = fr.read(ch)) != -1) {
			String str = new String(ch, 0, len);
			str = str.replace("{name}", cat.getName());
			str = str.replace("{type}", cat.getType());
			str = str.replace("{master}", cat.getMaster());
			System.out.println(str);
		}

		fr.close();
	}
}
