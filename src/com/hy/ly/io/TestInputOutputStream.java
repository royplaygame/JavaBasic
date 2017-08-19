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

	// 从磁盘存在的一个文件中读取内容，读取到程序中。
	@Test
	public void testFileInputStream() throws IOException {
		// 1.创建一个File类的对象
		File file = new File("hello.txt");

		// 2.创建一个FileInputStream类的对象
		FileInputStream fis = new FileInputStream(file);

		// 3. 调用FileInputStream方法,实现文件的读取
		// read()  读取文件当读取到末尾时，返回-1。
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
		// 2. 创建一个FileInputStream输入流
		FileInputStream fis = null;
		try {
			// 1. 创建一个文件对象
			File file = new File("hello.txt");

			fis = new FileInputStream(file);

			// 3. .创建一个FileInputStream类的对象
			int b;
			while ((b = fis.read()) != -1) {
				System.out.print((char) b);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 4.关闭输入流
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
		byte[] b = new byte[10]; // 创建一个byte数组
		int len = -1; // 每次读取到byte中的数据的长度。
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
		byte[] b = new byte[10]; // 创建一个byte数组
		int len = -1; // 每次读取到byte中的数据的长度。
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

	// 文件输入输出流
	@Test
	public void testFileInputOutputStream() {
		// File file1 = new File("hello.txt");
		// File file2 = new File("hello4.txt");
		File file1 = new File("D:\\background.jpg");
		File file2 = new File("D:\\bgirl.jpg");

		// 创建流
		FileInputStream fis = null;
		FileOutputStream fos = null;

		try {
			fis = new FileInputStream(file1);
			fos = new FileOutputStream(file2);

			// 创建一个btye数组
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
		// 创建流
		FileInputStream fis = null;
		FileOutputStream fos = null;

		try {
			fis = new FileInputStream(file1);
			fos = new FileOutputStream(file2);
			// 创建一个byte数组
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
	
	@Test
	public void testInputStream() throws IOException{
		FileInputStream fis=new FileInputStream(new File("hello.txt"));
		fis.available();
		int i=fis.read();
		while(i!=-1){
			System.out.print((char)i);
			i=fis.read();
		}
		fis.close();
	}
	@Test
	public void testInputStream2() throws IOException{
		FileInputStream fis=new FileInputStream(new File("hello.txt"));
		byte []b=new byte[1024];
		int len;
		while((len=fis.read(b))!=-1){
			String str=new String(b,0,len);
			System.out.println(str);
		}
		fis.close();
	}
	@Test
	public void testInputStream3() throws IOException{
		FileInputStream fis=new FileInputStream(new File("hello.txt"));
		byte []b=new byte[5];
		int len;
		while((len=fis.read(b))!=-1){
			for(int i=0;i<len;i++){
				System.out.print((char)b[i]);
			}
		}
		fis.close();
	}
	
	@Test
	public void testFileOutputStream1() throws IOException{
		FileOutputStream fos=new FileOutputStream(new File("out.txt"));
		String str="this is my new outputStream test";
		fos.write(str.getBytes());
		fos.close();
	}
	
}
