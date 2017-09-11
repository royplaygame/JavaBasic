package com.hy.ly.basic;

import java.util.Scanner;

import org.junit.Test;

public class ForTest {

	public static void main(String[] args) {
		for(;;){
			System.out.println("this is test");
			;
			;
			System.out.println("yyy");
			Object obj=new Object();
			obj.equals("");
		}
	}
	
	@Test
	public void test(){
		//输入一串已知字符串，再输入一串子字符串，输出该子字符串在已知字符串中出现的次数
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入一串字符串");
		String str = scanner.nextLine();
		System.out.println("请再输入一串子字符串");
		String str1 = scanner.nextLine();

		int count = 0;
		int start = 0;
		while (str.indexOf(str1, start) > 0 && start < str.length()) {
		count++;
		start = str.indexOf(str1, start) + str1.length();
		}

		System.out.println(count);
		scanner.close();
	}
	
}
