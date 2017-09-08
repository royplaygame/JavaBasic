package com.hy.ly.thread3;

public class TestWindow {

	public static void main(String[] args) {
		TicketWindow t1=new TicketWindow();
		TicketWindow t2=new TicketWindow();
		TicketWindow t3=new TicketWindow();
		
		t1.start();
		t2.start();
		t3.start();
	}
}
