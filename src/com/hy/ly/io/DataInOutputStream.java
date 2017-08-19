package com.hy.ly.io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.junit.Test;

public class DataInOutputStream {

	@Test
	public void testDataInOutputStream() throws Exception {
		DataInputStream dis = new DataInputStream(new FileInputStream("11.jpg"));
		DataOutputStream dos = new DataOutputStream(new FileOutputStream("22.jpg"));
		byte[] b = new byte[1024];
		int len;
		while ((len = dis.read(b)) != -1) {
			dos.write(b, 0, len);
		}
		dos.close();
		dis.close();
	}
	
	public static void copyFile(String source,String dest) throws Exception{
		DataInputStream dis = new DataInputStream(new FileInputStream(source));
		DataOutputStream dos = new DataOutputStream(new FileOutputStream(dest));
		byte[] b = new byte[1024];
		int len;
		while ((len = dis.read(b)) != -1) {
			dos.write(b, 0, len);
		}
		dos.close();
		dis.close();
	}
	
	public static void main(String[] args) throws Exception {
		String source="poney.txt";
		String dest="myPoney.txt";
		DataInOutputStream.copyFile(source, dest);
	}

}
