package com.hy.ly.thread;

public class ThreadTest5 extends Thread{
	
	public ThreadTest5(String name){
		super(name);
	}

	public void run(){
		for(int i=1;i<1000;i++){
			System.out.println(Thread.currentThread().getName()+" "+i);
			if(i==20){
				Thread.yield();
			}
		}
	}
	public static void main(String[] args) {
		ThreadTest5 th=new ThreadTest5("高级");
		th.setPriority(Thread.MAX_PRIORITY);
		th.start();
		
		ThreadTest5 th1=new ThreadTest5("低级");
		th1.setPriority(Thread.MIN_PRIORITY);
		th1.start();
		
		
	}
}
