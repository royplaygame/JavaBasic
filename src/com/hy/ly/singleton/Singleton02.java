package com.hy.ly.singleton;

// 懒汉式线程不安全
public class Singleton02 {

	private Singleton02() {}

	private Singleton02 singleton = null;

	public Singleton02 getSingleton() {
		if (singleton == null) {
			singleton = new Singleton02();
		}
		return singleton;
	}
}
