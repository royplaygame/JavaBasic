package com.hy.ly.thread;

//模拟火车站售票窗口，开启三个窗口售票，总票数为100张
public class TestWindow {
	public static void main(String[] args) {
		Window w1 = new Window();
		Window w2 = new Window();
		Window w3 = new Window();
		w1.setName("1号");
		w2.setName("2号");
		w3.setName("3号");
		w1.start();
		w2.start();
		w3.start();
	}
}

class Window extends Thread {
	static int ticket = 100;

	public void run() {
		while (true) {
			if (ticket > 0) {
				System.out.println(Thread.currentThread().getName() + "售票窗口。售票号为：" + ticket--);
			} else {
				break;
			}
		}
	}
}