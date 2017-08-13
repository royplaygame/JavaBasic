package com.hy.ly.util;

public class TestCalculate {

	public static void main(String[] args) {

		int total;
		total = foo(100);
		System.out.println(total);
		multi(9);

		System.out.println(factorial(10));

		System.out.println(reverse("abcdefg"));
		
		System.out.println(eat(4));

	}

	// 递归计算1～100的和
	static int foo(int i) {
		if (i == 1) {
			return 1;
		} else {
			return foo(i - 1) + i;
		}
	}

	// 递归法输出九九乘法口诀表
	static void multi(int i) {
		if (i == 1) {
			System.out.println("1*1=1" + "\t");
		} else {
			multi(i - 1);
			for (int j = 1; j <= i; j++) {
				System.out.print(j + "*" + i + "=" + j * i + "\t");
			}
			System.out.println();
		}
	}

	// 利用递归方法实现一个函数,该函数能够实现n的阶乘,即 n! = n*(n-1)*…*3*2*1;
	static long factorial(int n) {
		if (n == 1) {
			return 1;
		} else {
			return n * factorial(n - 1);
		}
	}

	// 利用递归函数调用方式,将所输入的n个字符以相反顺序打印出来
	static String reverse(String str) {
		if (str.length() == 1) {
			return str;
		} else {
			return str.substring(str.length() - 1) + reverse(str.substring(0, str.length() - 1));
		}
	}

	/**
	 * 第一天悟空吃掉桃子总数一半多一个，第二天又将剩下的桃子吃掉一半多一个，以后每天吃掉前一天剩下的一半多一个，
	 * 到第10天准备吃的时候只剩下一个桃子。聪明的你，请帮悟空算一下，他第一天开始吃的时候桃子一共有多少个呢？
	 * 
	 */
	static int eat(int day){
		if(day==1){
			return 1;
		}else{
			return 2*eat(day-1)+2;
		}
	}
}
