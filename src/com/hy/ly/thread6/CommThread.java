package com.hy.ly.thread6;

public class CommThread implements Runnable{
	public static void main(String[] args) {
		CommThread tr=new CommThread();
		Thread t1 =new Thread(tr,"线程1");
		Thread t2 =new Thread(tr,"线程2");
		Thread t3 =new Thread(tr,"线程3");
		t1.start();
		t2.start();
		t3.start();
	}

	@Override
	public synchronized void run() {
		for(int i=0;i<10;i++){
			System.out.println(Thread.currentThread().getName()+"------>"+i);
			if(i==5){
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			if(i==3){
				notify();
			}
			if(i==9){
				notify();
			}
		}
	}

	
}
