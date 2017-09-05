package com.hy.ly.thread;

public class ThreadTake extends Thread{
	private AccountK ak;
	private double withDraw;
	
	public ThreadTake(String name,AccountK ak, double withDraw) {
		super(name);
		this.ak = ak;
		this.withDraw = withDraw;
	}
	public ThreadTake() {
		super();
	}
	
	public void run(){
		synchronized(ak){
			if(ak.getBalance()>this.withDraw){
				System.out.println(getName()+"取钱成功，吐出钞票！"+this.withDraw);
				ak.setBalance(ak.getBalance()-this.withDraw);
				System.out.println("\t 当前的余额为"+ak.getBalance());
			}else{
				System.out.println(getName()+"取钱失败，余额不足！");
			}
		}
	}
	
	public static void main(String[] args) {
		AccountK ak=new AccountK("1000001",1000);
		ThreadTake t1=new ThreadTake("张飞",ak,800);
		ThreadTake t2=new ThreadTake("刘备",ak,800);
		t1.start();
		t2.start();
	}
}
