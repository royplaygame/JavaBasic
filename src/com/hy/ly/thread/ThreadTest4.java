package com.hy.ly.thread;

import java.util.Date;

public class ThreadTest4 {

	public static void main(String[] args) throws InterruptedException {
		for (int j = 0; j < 20; j++) {
			Thread.sleep(2000);
			System.out.println(new Date());
		}
	}
}
