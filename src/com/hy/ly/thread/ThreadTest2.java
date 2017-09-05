package com.hy.ly.thread;

public class ThreadTest2 extends Thread {

	public ThreadTest2(String name) {
		super(name);
	}

	public void run() {
		for (int i = 0; i < 1000; i++) {
			System.out.println(Thread.currentThread().getName() + " " + i);
		}
	}

	public static void main(String[] args) throws InterruptedException {
		new ThreadTest2("子线程").start();
		for (int j = 0; j < 1000; j++) {
			if (j == 20) {
				ThreadTest2 jo = new ThreadTest2("join子线程");
				jo.start();
				jo.join();
			}
			System.out.println(Thread.currentThread().getName() + " " + j);
		}
	}
}
