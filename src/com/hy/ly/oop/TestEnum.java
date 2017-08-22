package com.hy.ly.oop;

import java.io.UnsupportedEncodingException;

public class TestEnum {

	private Gender sex;

	public static void main(String[] args) throws UnsupportedEncodingException {
		// 枚举switch
		Season season = Season.WINTER;
		switch (season) {
		case SPRING:
			System.out.println("春暖花开！");
			break;
		case SUMMER:
			System.out.println("夏日炎炎！");
			break;
		case AUTUMN:
			System.out.println("秋高气爽！");
			break;
		case WINTER:
			System.out.println("冬日暖暖！");
			break;
		default:
			System.out.println("季节有误！请重新输入！");
		}

		// 枚举属性
		TestEnum t = new TestEnum();
		t.sex = Gender.Male;
		System.out.println(t.sex);

		/**
		 * 
		 */

	}

}
