package com.hy.ly.thread4;

public class TestTakeMoney {

	public static void main(String[] args) {
		Account acc = new Account("1001", 1000);
		TakeMoneyThread t1 = new TakeMoneyThread("郭靖", acc, 600);
		TakeMoneyThread t2 = new TakeMoneyThread("黄蓉", acc, 600);
		t1.start();
		t2.start();
	}
}
