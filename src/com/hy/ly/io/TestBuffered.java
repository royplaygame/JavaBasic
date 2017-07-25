package com.hy.ly.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestBuffered {
	public static void copyFile(String source, String dest) {
		File file1 = new File(source);
		File file2 = new File(dest);
		// 创建
		FileInputStream fis = null;
		FileOutputStream fos = null;

		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;

		try {
			fis = new FileInputStream(file1);
			fos = new FileOutputStream(file2);

			bis = new BufferedInputStream(fis);
			bos = new BufferedOutputStream(fos);
			// 复制
			byte[] b = new byte[1024];
			int len;
			while ((len = bis.read(b)) != -1) {
				bos.write(b, 0, len);
				bos.flush();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (bos != null) {
				try {
					bos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (bis != null) {
				try {
					bis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
	}

	public static void main(String[] args) {
		String source = "D:\\tmp\\runuiautomator.jar";
		String dest = "D:\\tmp\\new.jar";
		long start = System.currentTimeMillis();
		TestBuffered.copyFile(source, dest);
		long end = System.currentTimeMillis();
		System.out.println(end - start); // 173
	}
}
