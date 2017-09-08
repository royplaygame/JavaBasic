package com.hy.ly.thread2;

public class TestPorAndCon {

	public static void main(String[] args) {
		SharedData sd = new SharedData();
		Producer p = new Producer(sd);
		Consumer c = new Consumer(sd);
		p.start();
		c.start();
	}
}
