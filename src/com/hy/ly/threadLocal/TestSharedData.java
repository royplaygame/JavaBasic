package com.hy.ly.threadLocal;

public class TestSharedData {

	public static void main(String[] args) {
		SharedData s = new SharedData();
		Producer p = new Producer(s);
		Consumer c = new Consumer(s);
		p.start();
		c.start();
	}
}
