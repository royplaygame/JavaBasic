package com.hy.ly.thread5;

public class TakeMoneyThread extends Thread{
	private Account acc;
	private double drawMoney;
	public TakeMoneyThread(String name,Account acc,double drawMoney){
		super(name);
		this.acc=acc;
		this.drawMoney=drawMoney;
	}

	public void run(){
		acc.takeMoney(drawMoney);
	}
}
