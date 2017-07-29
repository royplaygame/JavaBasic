package com.hy.ly.thread;

//模拟火车站售票窗口，开启三个窗口售票，总票数为100张
public class TestWindow3 {
	public static void main(String[] args) {
		Window3 w1 = new Window3();
		Window3 w2 = new Window3();
		Window3 w3 = new Window3();
		w1.setName("1号");
		w2.setName("2号");
		w3.setName("3号");
		w1.start();
		w2.start();
		w3.start();
	}
}

class Window3 extends Thread {
	static int ticket = 100;
	static Object obj=new Object();
	public void run() {
		while (true) {
			synchronized (obj) {
				if (ticket > 0) {
					try {
						Thread.currentThread().sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + "售票窗口。售票号为：" + ticket--);
				}
			} 
		}
	}
}