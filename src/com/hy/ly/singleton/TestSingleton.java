package com.hy.ly.singleton;

public class TestSingleton {
	public static void main(String[] args) {
		Singleton s1 = Singleton.getSingleton();
		Singleton s2 = Singleton.getSingleton();

		System.out.println(s1 == s2);
	}

}

class Singleton {
	private static Singleton singleton = null;

	private Singleton() {
	}

	public static Singleton getSingleton() {
		if (singleton == null) {
			synchronized (Singleton.class) { // 对于静态方法而言，可以使用当前类本身充当锁。
				if (singleton == null) {
					singleton = new Singleton();
				}
			}
		}
		return singleton;
	}
}