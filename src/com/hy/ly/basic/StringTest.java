package com.hy.ly.basic;

import java.text.DecimalFormat;

import org.junit.Test;

public class StringTest {

	public static void main(String[] args) {
		String str = "abcdefgaaaa";
		System.out.println(str.length());

		String str2 = "abcdefga";
		System.out.println(str.compareTo(str2));

		System.out.println(str.concat(str2));
		System.out.println(str2.substring(3));

		System.out.println(str.equals(str2));

		String str3 = "abcdefgaaaa";
		String str4 = new String("abcdefgaaaa");
		System.out.println(str.equals(str3));
		System.out.println(str.equals(str4));
		System.out.println("========================");
		System.out.println(str == str3);
		System.out.println(str == str4);
		String str5 = "abc" + "defgaaaa";
		String str6 = "aaa";
		String str7 = str2 + str6;
		System.out.println("========================");
		System.out.println(str7 == str3);
		System.out.println(str5 == str3);
		System.out.println(str3 == str7.intern());

		System.out.println(str.toUpperCase());
		String str8 = "adbdEFGDSE";
		System.out.println(str8.toLowerCase());

		System.out.println(str.indexOf("def"));
		System.out.println(str.lastIndexOf('a'));

		System.out.println(str8.substring(2, 4));

		String str9 = "  this dsdf";
		System.out.println(str9.trim());
		String str10 = "this is my first java progrem";
		String[] strs = str10.split(" ");
		for (String s : strs) {
			System.out.println(s);
		}

	}

	@Test
	public void StringBufferTest() {
		StringBuffer str = new StringBuffer("12345678990");
		int len = str.length();
		while (len > 3) {
			str.insert(len - 3, ",");
			len -= 3;
		}
		System.out.println(str.toString());

		long num = 1234567899;
		DecimalFormat df = new DecimalFormat("#,###");
		System.out.println(df.format(num));
	}
}
