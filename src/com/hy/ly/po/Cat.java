package com.hy.ly.po;

public class Cat extends Animal{

	public static void main(String[] args) {
		
		final Cat c=new Cat();
		System.out.println(c);
		c.setAge(100);
		c.setName("花花");
		System.out.println(c);
		//c=new Cat();
	}
}
