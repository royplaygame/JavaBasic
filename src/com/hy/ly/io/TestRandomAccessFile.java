package com.hy.ly.io;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

import org.junit.Test;

/**
 * RandomAccessFile支持随机访问 1. 既可以充当输入流，又可以充当输出流 2. 支持从文件开头读取和写入。 3.
 * 也支持从文件的任意位置读取和写入。
 * 
 * @author ssr
 *
 */
public class TestRandomAccessFile {
	// 实现插入效果,实现多行文本
		@Test
		public void testRandomAccessFile4() {
			RandomAccessFile write = null;
			try {
				write = new RandomAccessFile(new File("hello5.txt"), "rw");

				write.seek(5);
				byte []b=new byte[1024];
				int len;
				StringBuffer sb=new StringBuffer();
				while((len=write.read(b))!=-1){
					sb.append(new String(b,0,len));
				}
				write.seek(5);
				write.write("haha ".getBytes());
				write.write(sb.toString().getBytes());
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (write != null) {
					try {
						write.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	
	// 实现插入效果，实现单行文本
	@Test
	public void testRandomAccessFile3() {
		RandomAccessFile write = null;
		try {
			write = new RandomAccessFile(new File("hello5.txt"), "rw");

			write.seek(5);
			String str=write.readLine();  //读取一行，后指针在最后面了
			//long l=write.getFilePointer(); //查看当前指针的位置
			write.seek(5);
			write.write("haha ".getBytes());
			write.write(str.getBytes());

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (write != null) {
				try {
					write.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	// 在某一个位置进行写,实现一个覆盖效果，不是插入的
	@Test
	public void testRandomAccessFile2() {
		RandomAccessFile write = null;
		try {
			write = new RandomAccessFile(new File("hello5.txt"), "rw");

			write.seek(5);
			write.write("haha".getBytes());

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (write != null) {
				try {
					write.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	// 文件读写
	@Test
	public void testRandomAccessFile() {
		RandomAccessFile read = null;
		RandomAccessFile write = null;
		try {
			read = new RandomAccessFile(new File("hello.txt"), "r");
			write = new RandomAccessFile(new File("hello5.txt"), "rw");

			byte[] b = new byte[1024];
			int len;
			while ((len = read.read(b)) != -1) {
				write.write(b, 0, len);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (read != null) {
				try {
					read.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (write != null) {
				try {
					write.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
