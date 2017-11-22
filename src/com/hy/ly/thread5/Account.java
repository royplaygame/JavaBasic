package com.hy.ly.thread5;

public class Account {

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
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public Account(String accountNo, double balance) {
		super();
		this.accountNo = accountNo;
		this.balance = balance;
	}
	public Account() {
		super();
	}
	
	public synchronized void takeMoney(double drawMoney){
		if(getBalance()>=drawMoney){
			System.out.println(Thread.currentThread().getName()+"取钱成功！取出的金额是："+drawMoney);
			setBalance(getBalance()-drawMoney);
			System.out.println("当前的余额是："+getBalance());
		}else{
			System.out.println("余额不足！当前的余额是："+getBalance());
		}
	}
}
