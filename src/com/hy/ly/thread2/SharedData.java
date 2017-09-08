package com.hy.ly.thread2;

public class SharedData {

	private char ch;
	private boolean isProduced;

	public char getCh() {
		return ch;
	}

	public void setCh(char ch) {
		this.ch = ch;
	}

	public boolean isProduced() {
		return isProduced;
	}

	public void setProduced(boolean isProduced) {
		this.isProduced = isProduced;
	}

	// 生产数据
	public synchronized void putSharedChar(char ch) {
		// 判断是否已经生生产
		if (this.isProduced) {
			System.out.println("消费者未消费，生产者等待消费者来消费.....");
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.ch = ch;
		this.isProduced = true; // 标记已经生产
		notify(); // 通知消费者来消费
		System.out.println("生产已经生产！生产了：" + ch);
	}

	// 消费数据
	public synchronized char getSharedChar() {
		// 判断是否消费
		if (!this.isProduced) {
			System.out.println("生产者未生产，消费者等待生产来生产.....");
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.isProduced = false; // 标记已经消费
		notify(); // 通知生产来生产
		System.out.println("消费者已经消费，消费的是：" + this.ch);
		return this.ch;
	}
}
