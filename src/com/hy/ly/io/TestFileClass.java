package com.hy.ly.io;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

import org.junit.Test;

public class TestFileClass {

	@Test
	public void testFile() throws IOException {
		File file = new File("D:\\tmp");
		File file1 = new File("hello.txt");
		// 访问文件名的方法
		System.out.println(file.getName());
		System.out.println(file.getAbsolutePath()); // 返回String
		System.out.println(file.getAbsoluteFile()); // 返回File
		System.out.println(file.getParent()); // 返回String
		System.out.println(file.getParentFile());// 返回File
		boolean b = file.renameTo(file1);
		System.out.println(b);
		// 文件检测方法
		System.out.println(file.exists() + " " + file1.exists());
		System.out.println(file.canWrite() + " " + file1.canRead());
		System.out.println(file.isDirectory() + " " + file1.isDirectory());
		System.out.println(file1.isFile() + " " + file1.isFile());
		System.out.println(file.isAbsolute() + " " + file1.isAbsolute());

		// 获取常规信息
		System.out.println(file1.lastModified());
		System.out.println(file1.length());

		// 文件操作
		File file2 = new File("hello4.txt");
		if (!file2.exists()) {
			file2.createNewFile();
		} else {
			file2.delete();
		}
	}

	@Test
	public void testFile2() throws IOException, InterruptedException {
		// 默认路径下创建一个文件
		// File f=File.createTempFile("myfile", ".zip");
		// System.out.println(f.getAbsolutePath());

		// 指定路径下创建一个文件
		// File file=new File("D:\\tmp");
		// File f2= File.createTempFile("myfile", ".tar", file);
		// System.out.println(f2.getAbsolutePath());

		File f3 = new File("D:\\tmp\\myfile6219248173874379584.tar");
		f3.deleteOnExit();
		System.out.println("sleep 10");
		Thread.sleep(10000);
		System.out.println(" sleep end");
	}

	// 文件目录操作
	@Test
	public void testDirectory() {
		File file = new File("D:\\tmp\\qq");
		if (!file.exists()) {
			file.mkdir();
		} else {
			file.delete();
		}

		// File file2 = new File("D:\\tmp");
		// 列出文件File下的所有子文件名和路径
		/*
		 * String [] files=file2.list(); for(String s:files){
		 * System.out.println(s); }
		 */

		System.out.println("================");
		// []fs=file2.listFiles();

		//
		File[] fis = File.listRoots();
		for (File f : fis) {
			System.out.println(f);

		}
	}

	@Test
	public void testFile5() {
		File file = new File("D:\\tmp");

		String[] files = file.list(new JavaFilter());
		for (String s : files) {
			System.out.println(s);
		}
	}

	public void listDirectory(File file) {
		File[] files = file.listFiles();
		for (File f : files) {
			if (f.isDirectory()) {
				listDirectory(f);
			} else {
				System.out.println(f.getName());
			}
		}
	}

	@Test
	public void testListFile() {
		File file = new File("D:\\tmp\\");
		this.listDirectory(file);
	}

	// FilenameFilter使用匿名内部类的方式
	@Test
	public void testListFilter() {
		File file = new File("D:\\tmp");

		FilenameFilter filter = new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith(".java");
			}
		};
		// 查找满足条件的文件
		String[] files = file.list(filter);
		for (String f : files) {
			System.out.println(f);
		}
		System.out.println("");
		// 使用用方式二：
		String[] files1 = file.list(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith(".txt");
			}
		});

		for (String f : files1) {
			System.out.println(f);
		}
	}
}
