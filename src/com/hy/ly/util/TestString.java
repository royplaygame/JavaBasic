package com.hy.ly.util;

import org.junit.Test;

public class TestString {
	/**
	 * String 不可变了的字符序列，底层以char[]的形式存储的 String 是final的
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		String str1 = "JavaEE";
		String str2 = "JavaEE";
		String str3 = new String("JavaEE");
		String str4 = "JavaEE" + "Android";
		String str5 = "Android";
		String str6 = str1 + str5;
		str5 = str5 + "hadoop";
		String str7 = str6.intern();
		String str8 = "JavaEEAndroid";

		System.out.println(str1 == str2); // true
		System.out.println(str1 == str3); // false
		System.out.println(str1.equals(str3)); // true

		System.out.println(str4 == str6); // false
		System.out.println(str4.equals(str6)); // true
		System.out.println(str4 == str7); // true
		System.out.println(str4 == str8); // true
	}

	/**
	 * int length() char charAt(int index) boolean equals(Object anObject) int
	 * indexOf(String str) 返回指定子字符串在此字符串中第一次出现处的索引。 int lastIndexOf(int ch)
	 * 返回指定字符在此字符串中最后一次出现处的索引。
	 */
	@Test
	public void testString() {
		String str1 = "abcdefghijklmnddfff";
		String str2 = "abccc";
		String str3 = "   thiis    ";
		System.out.println(str1.length());
		System.out.println(str1.charAt(0));
		System.out.println(str1.equals(str2));
		System.out.println(str1.compareTo(str2));
		System.out.println(str1.indexOf("d"));
		System.out.println(str1.lastIndexOf("d"));
		System.out.println(str1.lastIndexOf("p"));
		System.out.println(str1.startsWith("abc"));
		System.out.println(str3.trim());

	}

	/**
	 * 字符与基本数据类型和包装类之间的转换 
	 * 1. 字符串转--->相应的基本数据类型和包装类:调用相应的包装的praseXxx(String str)方法
	 * 2. 基本数据类型和包装类------->字符串转:调用String的一系列的valueOf()方法
	 * 
	 * 
	 * 字符串与字节数组的转换
	 * 1. 字符串------>字节数组的转换:调用字符串的getBytes()方法
	 * 2. 字节数组的转换------>字符串:调用字符串的构造器
	 * 
	 * 
	 * 字符串与字符数组的转换
	 * 1. 字符串------>字符数组的转换:调用字符串的toCharArray()方法
	 * 2. 字符数组的转换------>字符串:调用字符串的构造器
	 */

	@Test
	public void testString2() {
		//1.字符与基本数据类型和包装类之间的转换
		String str = "123456";
		int i = Integer.parseInt(str);
		System.out.println(i);

		int num=987654;
		String str1=String.valueOf(num);
		String str2=num+"";
		System.out.println(str1);
		System.out.println(str2);
		
		System.out.println();
		//3.字符与字节数组的转换
		String hobby="swimming";
		byte []hobbys=hobby.getBytes();
		for(int j=0;j<hobbys.length;j++){
			System.out.print((char)hobbys[j]);
		}
		
		System.out.println();
		String str3=new String(hobbys);
		System.out.println(str3);
		
		//3.字符串与字符数组的转换
		String str4="this is a 中华人民共和国";
		char []chs=str4.toCharArray();
		for(int k=0;k<chs.length;k++){
			System.out.println(chs[k]);
		}
		
		String str5=new String(chs);
		System.out.println(str5);
	}
}
