package com.hy.ly.inface;

public abstract class Bird {

	public void fly() {
		System.out.println("我像火箭一样飞出去了。。。。。。。。。。。。。。");
	}

	public void bark() {
		System.out.println("嗷嗷。。。。。。。。。。。。。。。。。。。。。。");
	}

	public abstract void attack();

	public abstract void eat();
	
}
