package com.hy.ly.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;

/**
 * 
 * @author zhangsq
 *
 */

public class TestInputOutputStream {

	// 从硬盘中读取一个文件,要读取的文件一定要存在
	@Test
	public void testFileInputStream() throws IOException {
		// 1. 创建File对象
		File file = new File("hello.txt");

		// 2. 创建一个FileInputStream类的对象
		FileInputStream fis = new FileInputStream(file);

		// 3. 调用的FileInputStream方法，实现file文件的读取
		// read()从此输入流中读取一个数据字节,如果已到达文件末尾，则返回 -1。
		/*
		 * int b=fis.read(); while(b!=-1){ System.out.print((char)b);
		 * b=fis.read(); }
		 */

		int b;
		while ((b = fis.read()) != -1) {
			System.out.print((char) b);
		}

		// 4.关闭相应的流
		fis.close();

	}

	@Test
	public void testFileInputStream2() {
		// 2. 创建一个FileInputStream类的对象
		FileInputStream fis = null;
		try {
			// 1. 创建File对象
			File file = new File("hello.txt");

			fis = new FileInputStream(file);

			// 3. 调用的FileInputStream方法，实现file文件的读取
			int b;
			while ((b = fis.read()) != -1) {
				System.out.print((char) b);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 4.关闭相应的流
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	@Test
	public void testFileInputStream3() throws IOException {
		File file = new File("hello.txt");
		FileInputStream fis = new FileInputStream(file);
		byte[] b = new byte[10]; // 要读取到的数据要写入的数组
		int len = -1; // 每次读入到byte中的字节的长度
		while ((len = fis.read(b)) != -1) {
			for (int i = 0; i < len; i++) {
				System.out.print((char) b[i]);
			}
			// System.out.println();
		}
		fis.close();
	}

	@Test
	public void testFileInputStream4() throws IOException {
		File file = new File("hello.txt");
		FileInputStream fis = new FileInputStream(file);
		byte[] b = new byte[10]; // 要读取到的数据要写入的数组
		int len = -1; // 每次读入到byte中的字节的长度
		while ((len = fis.read(b)) != -1) {
			String str = new String(b, 0, len);
			System.out.print(str);
		}
		fis.close();
	}

	// 写入文件
	@Test
	public void testFileOutputStream() {

		File file = new File("hello3.txt");

		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(file);
			fos.write(new String("I love China, and I love you").getBytes());
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	// 从硬盘读取一个文件并写入到另一个文件
	@Test
	public void testFileInputOutputStream() {
		// File file1 = new File("hello.txt");
		// File file2 = new File("hello4.txt");
		File file1 = new File("D:\\background.jpg");
		File file2 = new File("D:\\bgirl.jpg");

		// 流
		FileInputStream fis = null;
		FileOutputStream fos = null;

		try {
			fis = new FileInputStream(file1);
			fos = new FileOutputStream(file2);

			// 复制
			byte[] b = new byte[100];
			int len;
			while ((len = fis.read(b)) != -1) {
				fos.write(b, 0, len);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
	}

	public static void copyFile(String source, String dest) {
		File file1 = new File(source);
		File file2 = new File(dest);
		// 流
		FileInputStream fis = null;
		FileOutputStream fos = null;

		try {
			fis = new FileInputStream(file1);
			fos = new FileOutputStream(file2);
			// 复制
			byte[] b = new byte[100];
			int len;
			while ((len = fis.read(b)) != -1) {
				fos.write(b, 0, len);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
	}

	public static void main(String[] args) {
		String source = "D:\\app\\testfile1\\apache-maven-3.3.9-bin.zip";   
		String dest = "D:\\app\\testfile1\\new.zip";
		long start = System.currentTimeMillis();
		TestInputOutputStream.copyFile(source, dest);
		long end = System.currentTimeMillis();
		System.out.println(end - start);  //337
	}
}
