package com.hy.ly.po;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Tools {

	private int total;
	private String name;
	private static String hobby="乒乓";
	int kk; 

	public static void getInfo() {
		System.out.println("this is getInfo");
		// getName();
		// System.out.println(name);
		// this.name;
		// super.getClass();
		System.out.println(hobby);
		System.out.println(Tools.hobby);
		show();
		Tools.show();
	}

	public void getName() {
		System.out.println("this is name");
		System.out.println(super.getClass().getName());

	}

	static public void show() {
		System.out.println("this is show method");
	}

	public static void main(String[] args) {
		Tools t=new Tools();
		t.getInfo();
		
		List list=new ArrayList();
		
		Date d=new Date();
		
		int []num=new int[9];
		Arrays.sort(num);
	}
}


class book{
	
}
