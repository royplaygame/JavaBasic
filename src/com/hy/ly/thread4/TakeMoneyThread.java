package com.hy.ly.thread4;

public class TakeMoneyThread extends Thread{
	private Account acc;
	private double drawMoney;
	public TakeMoneyThread(String name,Account acc,double drawMoney){
		super(name);
		this.acc=acc;
		this.drawMoney=drawMoney;
	}

	public void run(){
		synchronized(acc){
			if(acc.getBalance()>=this.drawMoney){
				System.out.println(getName()+"取钱成功！取出的金额是："+this.drawMoney);
				acc.setBalance(acc.getBalance()-this.drawMoney);
				System.out.println("当前的余额是："+acc.getBalance());
			}else{
				System.out.println("余额不足！当前的余额是："+acc.getBalance());
			}
		}
	}
}
