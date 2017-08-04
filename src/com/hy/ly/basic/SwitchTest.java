package com.hy.ly.basic;

import java.util.Scanner;

import org.junit.Test;

import com.hy.ly.po.Season;

public class SwitchTest {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int num = in.nextInt();

		switch (num) {
		case 1:
			System.out.println("星期一");
			break;
		case 2:
			System.out.println("星期二");
			break;
		case 3:
			System.out.println("星期三");
			break;
		case 4:
			System.out.println("星期四");
			break;
		case 5:
			System.out.println("星期五");
			break;
		case 6:
			System.out.println("星期六");
			break;
		case 7:
			System.out.println("星期日");
			break;
		default:
			System.out.println("输入错误");

		}
		in.close();
	}

	@Test
	public void testFunction() {
		String str = "7";
		switch (str) {
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
			System.out.println("输入错误");
		}
	}

	@Test
	public void testSwitch() {
		int num = 11;
		switch (num) {
		case 1:
			System.out.println(Season.SPRING);
			break;
		case 2:
			System.out.println(Season.SUMMER);
			break;
		case 3:
			System.out.println(Season.AUTUMN);
			break;
		case 4:
			System.out.println(Season.WINTER);
			break;
		default:
			System.out.println("输入有误！");
		}
	}
}
