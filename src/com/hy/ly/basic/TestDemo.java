package com.hy.ly.basic;

import org.junit.Test;

public class TestDemo {

	public static void main(String[] args) {
		String day = "1";
		switch (day) {
		case "1":
			System.out.println("星期一");
			break;
		case "2":
			System.out.println("星期二");
			break;
		case "3":
			System.out.println("星期三");
			break;
		case "4":
			System.out.println("星期四");
			break;
		case "5":
			System.out.println("星期五");
			break;
		case "6":
			System.out.println("星期六");
			break;
		case "7":
			System.out.println("星期日");
			break;
		default:
			break;
		}
	}

	@Test
	public void test() {
		int i = 222;
		int j=-35;
		System.out.println(i >> 2);  //55                   1101 1110->0011 0111
		System.out.println(i << 2);  //888                  1101 1110->0011 0111 1000
		System.out.println(j<<2);    //-140         11111111111111111111111111011101->1111 1111 1111 1111 1111 1111 01110100
		
		
		int k=-24;
		
		System.out.println(k>>>2);  //1073741818                        //1111 1111 1111 1111 1111 1111 1110 1000->0011 1111 1111 1111 1111 1111 1111 1010
		
		
		int l=100;
		l+=100;
		System.out.println(l);
		
		System.out.println("HelloWord" instanceof String);
		
		
		int 成绩=100;
		System.out.println(成绩);
		
		
		double f=5.0;
		double f1=0.2f;
		int ii=5;
		System.out.println(f*f1+" "+f/ii);
		
		double d1=0.1;
		double d2=0.2;
		System.out.println(d1+d2);
	}
}
