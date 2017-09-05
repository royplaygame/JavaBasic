package com.hy.ly.threadLocal;

public class SharedData {

	private char ch;
	private boolean isProduced = false;

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

	// 同步方法putShareChar(char c)
	public synchronized void putSharedChar(char c) {
		//判断标志位
		if(isProduced){
			System.out.println("消费者还未消费，因此生产者停止生产！");
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.ch=c;
		this.isProduced=true;
		notify();
		System.out.println("生产者已经生产了"+c+"通知消费者进行消费......");
	}

	// 同步方法getShareChar
	public synchronized char getSharedChar() {
		if(!isProduced){
			System.out.println("生产者还没生产，消费者停止消费！");
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.isProduced=false;
		notify();
		System.out.println("消费者已经消费，通知生产都进行生产......");
		return this.ch;
	}

}
