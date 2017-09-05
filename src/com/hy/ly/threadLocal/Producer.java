package com.hy.ly.threadLocal;

public class Producer extends Thread {
	private SharedData s;

	public Producer(SharedData s) {
		this.s = s;
	}

	public void run() {
		for (char ch = 'A'; ch <= 'Z'; ch++) {
			try {
				Thread.sleep((int)(Math.random()*5000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			s.putSharedChar(ch);
		}
	}
}
