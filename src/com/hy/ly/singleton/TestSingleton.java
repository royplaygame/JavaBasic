package com.hy.ly.singleton;

public class TestSingleton {
	public static void main(String[] args) {
		Singleton01 s1 = Singleton01.getSingleton();
		Singleton01 s2 = Singleton01.getSingleton();

		System.out.println(s1 == s2);
	}

}

class Singleton01 {
	private static Singleton01 singleton = null;

	private Singleton01() {
	}

	public static Singleton01 getSingleton() {
		if (singleton == null) {
			synchronized (Singleton.class) { // 对于静态方法而言，可以使用当前类本身充当锁。
				if (singleton == null) {
					singleton = new Singleton01();
				}
			}
		}
		return singleton;
	}
}