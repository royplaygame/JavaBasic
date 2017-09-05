package com.hy.ly.thread;

public class ThreadTest7 extends Thread{

	public void run(){
		for(int i=10;i>0;i--){
			System.out.println(getName()+" "+i);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		ThreadTest7 t7=new ThreadTest7();
		t7.start();
		ThreadTest8 t8=new ThreadTest8();
		t8.start();
	}
	
}


class ThreadTest8 extends Thread{
	public void run(){
		for(int i=1;i<=10;i++){
			System.out.println(getName()+" "+i);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}