package com.hy.ly.thread;

public class ThreadTest3 extends Thread{
	public void run(){
		for(int i=0;i<1000;i++){
			System.out.println(Thread.currentThread().getName()+" "+i);
		}
	}
	
	public static void main(String[] args) {
		ThreadTest3 th=new ThreadTest3();
		//设置为后台线程，前台线程的消亡后，jvm会通知后台线程
		th.setDaemon(true);
		th.start();
		
		for(int j=0;j<200;j++){
			System.out.println(Thread.currentThread().getName()+" "+j);
		}
	}
}
