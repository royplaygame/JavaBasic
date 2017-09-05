package com.hy.ly.thread;

public class ThreadTest9 extends Thread{

	public void run(){
		for(int i=0;i<1000;i++){
			if(i<=800){
				System.out.println("乌龟领先了，加油！");
			}else{
				System.out.println("乌龟超过了，再接再厉！");
			}
		}
	}
	
	public static void main(String[] args) {
		ThreadTest9 to=new ThreadTest9();
		Rabbit ra=new Rabbit();
		to.start();
		ra.start();
	}
}

class Rabbit extends Thread{
	public void run(){
		for(int i=0;i<1000;i++){
			if(i<800){
				System.out.println("兔子领先了，别骄傲！");
			}else{
				System.out.println("兔子领先了，加油！");
			}
		}
	}
}