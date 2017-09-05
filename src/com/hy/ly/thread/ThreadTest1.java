package com.hy.ly.thread;

public class ThreadTest1 implements Runnable {

	public void run(){
		for(int i=1;i<1000;i++){
			System.out.println(Thread.currentThread().getName()+" "+i);
		}
	}
	
	public static void main(String[] args) {
		ThreadTest1 th=new ThreadTest1();
		
		for(int j=1;j<1000;j++){
			System.out.println(Thread.currentThread().getName()+" "+j);
			if(j==20){
				new Thread(th,"线程1").start();
				new Thread(th,"线程2").start();
				new Thread(th).start();
			}
		}
	}
}
