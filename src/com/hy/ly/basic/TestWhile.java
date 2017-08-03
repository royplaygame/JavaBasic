package com.hy.ly.basic;

import java.util.Scanner;

import org.junit.Test;

public class TestWhile {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		System.out.println("这是第一遍做业,合格了吗？(y/n)");
		String flag = in.next();
		while("N".equals(flag)||"n".equals(flag)){
			System.out.println("再做一遍，合格了吗？(y/n)");
			flag = in.next();
		}
		System.out.println("已经合格!");
		in.close();
	}

	
	@Test
	public void testGood(){
		int i=1;
		do{
			System.out.println("我做了第"+i+"遍");
			i++;
		}while(i<10);
	}
}
