package com.hy.ly.thread;

public class CommunicationDemo {

	public static void main(String[] args) {
		SharedData sd=new SharedData();
		new Producer(sd).start();
		new Consumer(sd).start();
	}
}

class SharedData {
	private char c;
	private boolean isProduced = false;

	public synchronized void putShareData(char c) {
		// 如果产品还未消费，则生产者等待
		if (isProduced) {
			try {
				System.out.println("消费还未消费，因此生产者停止生产！");
				wait(); // 生产等待
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.c = c;
		isProduced = true; // 标记已经生产
		notify(); // 通知消费已经生产,可以消费
		System.out.println("生产了产品" + c + " 通知消费者消费....");

	}

	public synchronized char getShareData() {
		// 如果产品还没有生产，消费者等待
		if (!isProduced) {
			try {
				System.out.println("生产者未生产，消费者等待！");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		isProduced = false; // 标记已经消费
		notify();
		System.out.println("消费者消费了" + c + " 通知生产生产....");
		return this.c;
	}

}

class Producer extends Thread {
	private SharedData s;

	Producer(SharedData s) {
		this.s = s;
	}

	public void run() {
		for(char c='A';c<='Z';c++){
			try {
				Thread.sleep((int)(Math.random()*3000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			s.putShareData(c);
		}
	}
}

class Consumer extends Thread {
	private SharedData s;

	Consumer(SharedData s) {
		this.s = s;
	}

	public void run() {
		char ch;
		do{
			try {
				Thread.sleep((int)(Math.random()*3000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			ch=s.getShareData();
		}while(ch!='Z');
	}
}