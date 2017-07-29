package com.hy.ly.thread;

/**
 * 银行有一个帐户 有两个客户向同一个帐户存3000元，每次存1000,共存3次。每次存完打印帐户余款。
 *
 */

public class TestAccount {
	public static void main(String[] args) {
		Account ac=new Account();
		Customer c1=new Customer(ac);
		Customer c2=new Customer(ac);
		
		c1.setName("甲客户");
		c2.setName("乙客户");
		c1.start();
		c2.start();
	}
}

class Account {
	double balance;

	public Account() {

	}

	public synchronized void deposit(double amt) {
		notify();
		balance += amt;
		try {
			Thread.currentThread().sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "的当前的余额是：" + balance);
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class Customer extends Thread {
	Account account;

	public Customer(Account account) {
		this.account = account;
	}

	public void run() {
		for (int i = 0; i < 3; i++) {
			account.deposit(1000);
		}
	}
}