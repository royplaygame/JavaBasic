package com.hy.ly.singleton;


// 饿汉式线程安全 单例模式
public class Singleton {

	private Singleton() {}

	private Singleton singleton = new Singleton();

	public Singleton getSingleton() {
		return singleton;
	}
}
