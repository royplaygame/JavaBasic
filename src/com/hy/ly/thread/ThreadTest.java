package com.hy.ly.thread;

public class ThreadTest extends Thread{

	public void run(){
		for(int i=1;i<1000;i++){
			System.out.println(getName()+" "+i);
		}
	}
	
	public static void main(String[] args) {
		ThreadTest th=new ThreadTest();
		
		for(int i=0;i<100;i++){
			System.out.println(Thread.currentThread().getName()+" "+i);
			if(i==20){
				th.start();
				new ThreadTest().start();
				new ThreadTest().start();
			}
		}
	}
}
