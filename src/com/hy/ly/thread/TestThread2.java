package com.hy.ly.thread;

//线程1输出1～100的奇数，线程2输出1～100的偶数
public class TestThread2 {
	public static void main(String[] args) {
		PrintNumber1 p1 = new PrintNumber1();
		PrintNumber2 p2 = new PrintNumber2();
		//要想启动一个多线程，必须调用start()
		new Thread(p1).start();
		new Thread(p2).start();
	}
	

}

class PrintNumber1 implements Runnable {
	@Override
	public void run() {
		for (int i = 0; i < 100; i += 2) {
			System.out.println(Thread.currentThread().getName() + " " + i);
		}
	}

}

class PrintNumber2 implements Runnable {

	@Override
	public void run() {
		for (int i = 1; i < 100; i += 2) {
			System.out.println(Thread.currentThread().getName() + " " + i);
		}
	}

}