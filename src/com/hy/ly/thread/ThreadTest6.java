package com.hy.ly.thread;

public class ThreadTest6 extends Thread {

	private AccountK account;
	private double drawAmount;

	public ThreadTest6(String name, AccountK account, double drawAmount) {
		super(name);
		this.account = account;
		this.drawAmount = drawAmount;
	}

	public void run() {
		synchronized (account) {
			if (account.getBalance() >= drawAmount) {
				System.out.println(getName() + "取钱成功！吐出钞票：" + drawAmount);
				account.setBalance(account.getBalance() - drawAmount);
				System.out.println("\t 当前的余额为：" + account.getBalance());
			} else {
				System.out.println(getName() + "取钱失败！余额不足！");
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		AccountK acct = new AccountK("100001", 1000);
		new ThreadTest6("张飞", acct, 800).start();
		// Thread.sleep(1);
		new ThreadTest6("刘备", acct, 800).start();
	}
}
