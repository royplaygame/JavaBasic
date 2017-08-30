package com.hy.ly.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class MyBuffered extends BufferedOutputStream{

	public MyBuffered(OutputStream out) {
		super(out);
		System.out.println(super.buf.length);
		System.out.println(super.count);
	}

	public static void main(String[] args) throws FileNotFoundException {
		MyBuffered my=new MyBuffered(new FileOutputStream("hello.txt"));
		System.out.println(my);
		
		MyBufferedIn my1=new MyBufferedIn(new FileInputStream("hello.txt"));
		System.out.println(my1);
	}
}


class MyBufferedIn extends BufferedInputStream{

	public MyBufferedIn(InputStream in) {
		super(in);
		System.out.println(super.buf.length);
		System.out.println(super.count);
	}
	
}