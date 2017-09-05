package com.hy.ly.thread;

public class AccountB {

	private String accountNo;
	private double balance;

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public double getBalance() {
		return balance;
	}

	// 线程安全draw方法
	public synchronized void draw(double drawAmout) {
		if (this.balance > drawAmout) {
			System.out.println(Thread.currentThread().getName() + "取钱成功！吐出钞票：" + drawAmout);
			this.balance -= drawAmout;
			System.out.println("\t 当前的余额为：" + this.balance);
		} else {
			System.out.println(Thread.currentThread().getName() + "取钱失败！余额不足！");
		}
	}

	public AccountB(String accountNo, double balance) {
		super();
		this.accountNo = accountNo;
		this.balance = balance;
	}

	public AccountB() {
		super();
	}

	public static void main(String[] args) {
		AccountB ab=new AccountB("100002",1000);
		ThreadAccountTest t1=new ThreadAccountTest("刘备",ab,600);
		ThreadAccountTest t2=new ThreadAccountTest("张飞",ab,600);
		t1.start();
		t2.start();
	}
}

class ThreadAccountTest extends Thread {
	private AccountB ab;
	private double drawAmount;

	public ThreadAccountTest(String name, AccountB ab, double drawAmount) {
		super(name);
		this.ab = ab;
		this.drawAmount = drawAmount;
	}
	public ThreadAccountTest() {
	}

	public void run() {
		ab.draw(drawAmount);
	}
}