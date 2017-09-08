package com.hy.ly.thread;

public class ThreadTest10 extends Thread{

	public void run(){
		for(int i=0;i<100;i++){
			System.out.println(getName()+" "+i);
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		ThreadTest10 th=new ThreadTest10();
		th.start();
		for(int j=0;j<100;j++){
			if(j==20){
				ThreadTest10 th1=new ThreadTest10();
				th1.start();
				th1.join();
			}
			System.out.println(Thread.currentThread().getName()+" "+j);
		}
	}

}
