package com.hy.ly.thread1;

public class TakeThread extends Thread{

	private Account ac;
	private double drawMoney;
	
	public TakeThread(String name,Account ac,double drawMoney){
		super(name);
		this.ac=ac;
		this.drawMoney=drawMoney;
	}
	
	public void run(){
		//如果帐号钱足够，进行取钱
		synchronized(ac){
			if(ac.getBalance()>this.drawMoney){
				System.out.println(getName()+" 取钱成功！取出的金额是："+this.drawMoney);
				ac.setBalance(ac.getBalance()-this.drawMoney);
				System.out.println("\t 帐户的余额是："+ac.getBalance());
			}else{
				System.out.println("取钱失败！余额不够");
			}
		}
	}
}
