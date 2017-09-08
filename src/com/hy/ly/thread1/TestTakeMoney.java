package com.hy.ly.thread1;

public class TestTakeMoney {

	public static void main(String[] args) throws InterruptedException {
		Account ac=new Account("10001",1000);
		TakeThread t1=new TakeThread("郭靖",ac,600);
		TakeThread t2=new TakeThread("黄蓉",ac,600);
		t1.start();
		//t1.join();
		t2.start();
	}
}
