package com.hy.ly.io;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class TestFile {

	@Test
	public void test1() throws IOException {
		File file = new File("D:\\app\\testfile\\hello.txt");
		File file1 = new File("hello.txt");

		if (!file.exists()) {
			file.createNewFile();
		}

		if (!file1.exists()) {
			file1.createNewFile();
		}

		File.createTempFile("myfile", ".zip", new File("D:\\app\\testfile"));

		File f = File.createTempFile("java", ".rar");
		System.out.println(f);

		System.out.println(file.getName());
		System.out.println(file.getPath());
		System.out.println(file.getAbsolutePath());
		System.out.println(file.getAbsoluteFile());
		System.out.println(file.getParent());

		File fileNew = new File("D:\\app\\testfile\\helloNew.txt");
		file.renameTo(fileNew);

		File readFile = new File("D:\\app\\testfile\\read.txt");

		if (file.canWrite()) {
			System.out.println("canWrite");
		}
		if (readFile.canRead()) {
			System.out.println("canRead");
		}

		File fileDr = new File("D:\\app\\testfile1");
		if (!fileDr.exists()) {
			fileDr.mkdir();
		}

		File filemd = new File("D:\\app\\testfile2\\good\\book");
		if (!filemd.exists()) {
			filemd.mkdirs();
		}

		System.out.println(file.lastModified());
	}

	@Test
	public void test2() throws IOException {
		File file = new File("D:\\app");
		for (int i = 0; i < file.list().length; i++) {
			System.out.println(file.list()[i]);
		}
		System.out.println("===============================");
		for (int i = 0; i < file.listFiles().length; i++) {
			System.out.println(file.listFiles()[i].getName());
		}
	}

	@Test
	public void test3() throws IOException {
		File file = new File("D:\\tmp\\IO.txt");
		if (!file.exists()) {
			file.createNewFile();
			System.out.println("File create Successfully!");
		}
		// 设置成只读
		file.setReadOnly();
		boolean flag = file.setReadable(false);
		System.out.println(flag + "=====" + file.canRead());
		// file.setWritable(true);

		// 判断读写
		boolean f = file.setWritable(true);
		boolean r = file.setReadable(true);
		System.out.println(f + "=======" + file.canWrite());
		System.out.println(r + "========" + file.canRead());
		
		//输出修改时间
		System.out.println(file.lastModified());
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(sdf.format(new Date(file.lastModified())));
		file.setLastModified(150123123123L);
		System.out.println(sdf.format(new Date(file.lastModified())));
	}
}
