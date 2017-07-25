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

	// ��Ӳ���ж�ȡһ���ļ�,Ҫ��ȡ���ļ�һ��Ҫ����
	@Test
	public void testFileInputStream() throws IOException {
		// 1. ����File����
		File file = new File("hello.txt");

		// 2. ����һ��FileInputStream��Ķ���
		FileInputStream fis = new FileInputStream(file);

		// 3. ���õ�FileInputStream������ʵ��file�ļ��Ķ�ȡ
		// read()�Ӵ��������ж�ȡһ������ֽ�,����ѵ����ļ�ĩβ���򷵻� -1��
		/*
		 * int b=fis.read(); while(b!=-1){ System.out.print((char)b);
		 * b=fis.read(); }
		 */

		int b;
		while ((b = fis.read()) != -1) {
			System.out.print((char) b);
		}

		// 4.�ر���Ӧ����
		fis.close();

	}

	@Test
	public void testFileInputStream2() {
		// 2. ����һ��FileInputStream��Ķ���
		FileInputStream fis = null;
		try {
			// 1. ����File����
			File file = new File("hello.txt");

			fis = new FileInputStream(file);

			// 3. ���õ�FileInputStream������ʵ��file�ļ��Ķ�ȡ
			int b;
			while ((b = fis.read()) != -1) {
				System.out.print((char) b);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 4.�ر���Ӧ����
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
		byte[] b = new byte[10]; // Ҫ��ȡ�������Ҫд�������
		int len = -1; // ÿ�ζ��뵽byte�е��ֽڵĳ���
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
		byte[] b = new byte[10]; // Ҫ��ȡ�������Ҫд�������
		int len = -1; // ÿ�ζ��뵽byte�е��ֽڵĳ���
		while ((len = fis.read(b)) != -1) {
			String str = new String(b, 0, len);
			System.out.print(str);
		}
		fis.close();
	}

	// д���ļ�
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

	// ��Ӳ�̶�ȡһ���ļ���д�뵽��һ���ļ�
	@Test
	public void testFileInputOutputStream() {
		// File file1 = new File("hello.txt");
		// File file2 = new File("hello4.txt");
		File file1 = new File("D:\\background.jpg");
		File file2 = new File("D:\\bgirl.jpg");

		// ��
		FileInputStream fis = null;
		FileOutputStream fos = null;

		try {
			fis = new FileInputStream(file1);
			fos = new FileOutputStream(file2);

			// ����
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
		// ��
		FileInputStream fis = null;
		FileOutputStream fos = null;

		try {
			fis = new FileInputStream(file1);
			fos = new FileOutputStream(file2);
			// ����
			byte[] b = new byte[1024];
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
		String source = "D:\\tmp\\runuiautomator.jar";   
		String dest = "D:\\tmp\\1.jar";
		long start = System.currentTimeMillis();
		TestInputOutputStream.copyFile(source, dest);
		long end = System.currentTimeMillis();
		System.out.println(end - start);  //173
	}
	
	
	
}
