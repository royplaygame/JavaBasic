package com.hy.ly.threadLocal;

public class Consumer extends Thread {
	private SharedData s;

	public Consumer(SharedData s) {
		this.s = s;
	}

	public void run() {
		char ch;
		do {
			try {
				Thread.sleep((int)(Math.random()*5000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			ch = s.getSharedChar();
		} while (ch != 'Z');
	}
}
