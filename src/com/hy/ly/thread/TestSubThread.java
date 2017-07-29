package com.hy.ly.thread;

//线程1输出1～100的奇数，线程2输出1～100的偶数
public class TestSubThread {

	public static void main(String[] args) {
		SubThread1 st1 = new SubThread1();
		SubThread2 st2 = new SubThread2();
		st1.start();
		st2.start();

		// 继承Thread的类和匿名类对象
		new Thread() {
			public void run() {
				for (int i = 0; i < 100; i += 2) {
					System.out.println(Thread.currentThread().getName() + " " + i);
				}
			}
		}.start();
		new Thread() {
			public void run() {
				for (int i = 1; i < 100; i += 2) {
					System.out.println(Thread.currentThread().getName() + " " + i);
				}
			}
		}.start();
	}
}

class SubThread1 extends Thread {

	public void run() {
		for (int i = 0; i < 100; i += 2) {
			System.out.println(Thread.currentThread().getName() + " " + i);
		}
	}
}

class SubThread2 extends Thread {

	public void run() {
		for (int i = 1; i < 100; i += 2) {
			System.out.println(Thread.currentThread().getName() + " " + i);
		}
	}
}