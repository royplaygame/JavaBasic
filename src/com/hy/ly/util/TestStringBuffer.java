package com.hy.ly.util;

import org.junit.Test;

//java.lang.StringBuffer代表可变的字符序列
//java.lang.StringBuilder代表可变的字符序列   jdk1.5之后新加入的，线程不安全的，效率要高于StringBuffer
public class TestStringBuffer {

	@Test
	public void testStringBuffer(){
		StringBuffer sb=new StringBuffer();
		sb.append("123").append("abc").append(true);
		System.out.println(sb);
		//插入
		sb.insert(3, "hello");
		
		//反转
		sb.reverse();
		System.out.println(sb);
		
		//查找
		char c=sb.charAt(7);
		System.out.println(c);
		
		//修改单个字符
		sb.setCharAt(7, 'u');
		System.out.println(sb);
		
		//修改多个字符
		sb.replace(3, 6, "ppp");
		System.out.println(sb);
		
		//删除字符
		sb.delete(5, 9);
		System.out.println(sb);
		
		//长度
		sb.length();
		
	}
	
}
