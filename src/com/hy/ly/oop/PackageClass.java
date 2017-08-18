package com.hy.ly.oop;

import java.util.Random;

import org.junit.Test;

public class PackageClass {

	// 包装类
	@SuppressWarnings("unused")
	public static void main(String[] args) {

		// 基本类型转换为包装类型
		byte b = 10;
		short s = 2;
		char c = 'a';
		int it = 100;
		long l = 101;
		float f = 22.5f;
		double d = 34.5;
		Integer i = new Integer(c);
		Byte bt = new Byte(b);
		Short st = new Short(s);
		Long lo = new Long(10002L);
		Float fo = new Float(11.5);
		Double du = new Double(23.3);
		Boolean bool = new Boolean(true);
		Character ch = new Character(c);
		System.out.println(ch);

		// 包装类型转换为基本类型 xxxValue();
		int it1 = i.intValue();
		byte b1 = bt.byteValue();
		short s1 = st.shortValue();

		// 包装类型和基本类型自动转化
		Integer it5 = 10;
		String str = it5.toString();
		int iit = Integer.valueOf(str);
		int iit1 = Integer.parseInt(str);
		int it6 = it5;

		Object obj = new PackageClass();

	}

	// Math类
	@Test
	public void testMath() {
		System.out.println(Math.abs(-90));
		System.out.println(Math.max(100, 33));
		System.out.println(Math.random());

		System.out.println(Math.ceil(10.5));
		System.out.println(Math.floor(10.5));

		// 随机数
		Random rand = new Random();
		Random rand1 = new Random();
		System.out.println(rand.nextInt(100));
		System.out.println(rand1.nextInt(100));

		Random rd1 = new Random(100);
		Random rd2 = new Random(100);
		System.out.println(rd1.nextInt(100));
		System.out.println(rd2.nextInt(100));

	}

	// 字符串
	@Test
	public void testString() {
		String str1 = "this is my str";
		String str2 = "this is your str";
		String str3 = "this is your str";
		String str4 = new String("this is your str");
		int i = str1.compareTo(str2);
		System.out.println(i);
		System.out.println('m' - 'y');

		String newStr = str1.concat(" " + str2);
		System.out.println(newStr);
		System.out.println(newStr.substring(4, 8));
		System.out.println(newStr.startsWith("your"));
		System.out.println(newStr.endsWith("str"));

		String[] strs = newStr.split(" ");
		for (String s : strs) {
			System.out.println(s);
		}

		System.out.println(newStr.replace("this", "it"));

		// 字符串比较
		System.out.println(str1.equals(str2));
		System.out.println(str2.equals(str3));
		System.out.println(str2 == str3);
		System.out.println();
		System.out.println(str4 == str3);
		System.out.println(str4.equals(str3));
		
		//比较密码
		String password1="HPE123456";
		String password2="hpe123456";
		System.out.println();
		System.out.println(password1.equalsIgnoreCase(password2));
		System.out.println(password1.toLowerCase());
		System.out.println(password2.toUpperCase());
		
		//判断邮箱
	    String email="myemail@126.com";
	    
	    if(email.contains("@")&&email.contains(".")&&email.indexOf("@")<email.indexOf(".")-1){
	    	System.out.println(email+"格式正确！");
	    }else{
	    	System.out.println(email+"格式错误！");
	    }
	    
	    //StringBuffer 插入操作
	    String number="123456789123";
	    StringBuffer sb=new StringBuffer(number);
	    for(int k=number.length()-3;k>0;k-=3){
	    	sb.insert(k, ",");
	    }
	    System.out.println(sb.toString());
	
	    //StringBuffer 删除操作
	    StringBuffer sb1=new StringBuffer("123456789123");
	    System.out.println(sb1.delete(2, 5).toString());
	    StringBuffer sb2=new StringBuffer("123456789123");
	    System.out.println(sb2.deleteCharAt(5));
	}
}
