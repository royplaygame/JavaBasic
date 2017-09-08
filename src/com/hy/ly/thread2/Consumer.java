package com.hy.ly.thread2;

public class Consumer extends Thread {

	private SharedData sd;

	public SharedData getSd() {
		return sd;
	}

	public void setSd(SharedData sd) {
		this.sd = sd;
	}

	public Consumer(SharedData sd) {
		this.sd = sd;
	}

	public void run() {
		char ch;
		do {
			try {
				Thread.sleep((int)(Math.random()*3000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			ch = sd.getSharedChar();
		} while (ch != 'Z');
	}
}
