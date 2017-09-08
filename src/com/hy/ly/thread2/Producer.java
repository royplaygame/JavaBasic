package com.hy.ly.thread2;

public class Producer extends Thread {

	private SharedData sd;

	public SharedData getSd() {
		return sd;
	}

	public void setSd(SharedData sd) {
		this.sd = sd;
	}

	public Producer(SharedData sd) {
		this.sd = sd;
	}

	public void run() {
		for(char ch='A';ch<='Z';ch++){
			try {
				Thread.sleep((int)(Math.random()*3000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			sd.putSharedChar(ch);
		}
	}

}
