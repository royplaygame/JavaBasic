package com.hy.ly.po;

import org.junit.Test;

public class SuperMan {

	static String name = "我是超人！";
	String hobby = "乒乓球";
	static int total = 0;
	int count = 0;

	public SuperMan() {
		total++;
		count++;
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		System.out.println(SuperMan.total);
		SuperMan sup = new SuperMan();
		System.out.println(SuperMan.total);
		SuperMan sup1 = new SuperMan();
		System.out.println(SuperMan.total);
		
		
		/*// 通过类名调用
		System.out.println(SuperMan.name);
		// 通过对象调用
		SuperMan sup = new SuperMan();
		SuperMan sup1 = new SuperMan();
		System.out.println(sup.name);
		sup.name = "蜘蛛侠";
		sup1.name = "蝙蝠侠";
		// 通过类名调用
		System.out.println(sup.name);
		System.out.println(sup1.name);
		System.out.println(SuperMan.name);*/
	}

	@Test
	public void testSuper1() {
		System.out.println(SuperMan.total);
		SuperMan sup = new SuperMan();
		System.out.println(SuperMan.total);
		SuperMan sup1 = new SuperMan();
		System.out.println(SuperMan.total);
	}

	@Test
	public void testSuper() {
		System.out.println(SuperMan.total);
		SuperMan sup = new SuperMan();
		System.out.println(SuperMan.total);
		SuperMan sup1 = new SuperMan();
		System.out.println(SuperMan.total);
		System.out.println(sup.hobby);
		System.out.println(sup1.hobby);
		sup.hobby = "篮球";
		sup1.hobby = "足球";
		System.out.println();
		System.out.println(sup.hobby);
		System.out.println(sup1.hobby);

		System.out.println(SuperMan.total);
		System.out.println(sup.count);
		System.out.println(sup1.count);
	}

}
