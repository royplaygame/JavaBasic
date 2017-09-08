package com.hy.ly.thread3;

public class TicketWindow extends Thread {

	static Integer ticket = 100;
	static Object obj = new Object();

	public void run() {
		while (true) {
			synchronized (obj) {
				if (ticket > 0) {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + "售票窗口。售票号为：" + ticket--);
				} else {
					System.exit(0);
				}
			}
		}
	}
}
