package com.hy.ly.thread;

public class AccountTest2 implements Runnable {

	AccountK acc = new AccountK("10002", 500);

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			makeWithDraw(100);
			if (acc.getBalance() < 0) {
				System.out.println("帐户透支了！");
			}
		}
	}

	private synchronized void makeWithDraw(int i) {
			if (acc.getBalance() >= i) {
				System.out.println(Thread.currentThread().getName() + " 准备取款！");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				acc.withDraw(100);
				System.out.println(Thread.currentThread().getName() + " 完成取款！");
			} else {
				System.out.println("帐户的余额为：" + acc.getBalance());
			}
	}

	public static void main(String[] args) {
		AccountTest2 at = new AccountTest2();
		Thread one = new Thread(at);
		Thread two = new Thread(at);
		one.setName("甲");
		two.setName("乙");
		one.start();
		two.start();
	}

}
