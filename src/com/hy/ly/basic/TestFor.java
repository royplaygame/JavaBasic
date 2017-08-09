package com.hy.ly.basic;

import java.util.Scanner;

import org.junit.Test;

public class TestFor {

	public static void main(String[] args) {
		System.out.println("乘法口诀表：");
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(j + "*" + i + "=" + i * j + "\t");
			}
			System.out.println();
		}
	}

	@Test
	public void test2() {
		System.out.println("请输入圆的半径:");
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		// i代表每一行
		for (int i = 0; i <= 2 * r; i += 2) {
			// 圆上点到竖着半径的距离
			long y = Math.round(Math.sqrt(Math.pow(r, 2) - Math.pow(r - i, 2)));
			// 圆上点到外切正方形边的距离
			long x = r - y;
			// 先打印出正方形左边边到圆上点的空白部位
			for (int j = 0; j < x; j++) {
				System.out.print(" ");
			}
			// 打印出左边的圆上点
			System.out.print("*");
			// 打印出中间空白部分
			for (int k = 0; k < 2 * (r - x); k++) {
				System.out.print(" ");
			}
			// 打印出右边的圆上点 右边空白不要打直接换行
			System.out.println("*");
		}
		sc.close();
	}

	@Test
	public void test3() {
		System.out.println("请输入圆的半径:");
		Scanner sc = new Scanner(System.in);
		int l = sc.nextInt();
		for (int i = 1; i <= l; i++) {
			for (int j = 1; j <= l; j++) {
				if (i == 1 || i == l) {
					System.out.print("* ");
				} else if (j == 1 || j == l) {
					System.out.print("* ");
				} else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}
		sc.close();
	}

	@Test
	public void test5() {
		final double PI = Math.PI;
		int r = 10;
		double area;
		area = PI * r * r;
		System.out.println("圆形的面积是：" + area);
	}

	@Test
	public void testFor() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	@Test
	public void testFor1() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	@Test
	public void testFor2() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4 - i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	@Test
	public void testFor3() {
		int sum = 0;
		for (int i = 1; i <= 100; i++) {
			if (!(i % 3 == 0)) {
				sum += i;
			}
		}
		System.out.println(sum);
	}

	// 3000米长的绳子，每天减一半。问多少天这个绳子会小于5米？不考虑小数。
	@Test
	public void testQuestion() {
		int len = 3000;
		int day = 0;
		while (len >= 5) {
			len /= 2;
			day++;
		}
		System.out.println(day);
	}

	@Test
	public void testQuestion2() {
		int day = 0;
		for (int x = 3000; x >= 5; x /= 2) {
			day++;
		}
		System.out.println("day=" + day);
		/*
		 * 方法二： day = 0; for(int x=3000; x>=5; day++) { x = x/2; }
		 * System.out.println(day);
		 */
	}

	@Test
	public void testYear() {
		/**
		 * 编写程序，判断给定的某个年份是否是闰年。 闰年的判断规则如下： 
		 * （1）若某个年份能被4整除但不能被100整除，则是闰年。
		 * （2）若某个年份能被400整除，则也是闰年。
		 */
		for (int year = 1900; year < 2017; year++) {
			if ((year % 4 == 0 && year % 100 != 0)) {
				System.out.println(year);
			}
		}

	}
}
