package com.hy.ly.inface;

public class TheftproofDoor extends Door implements Lock, Photo {

	@Override
	public void lock() {
		System.out.println("插进钥匙，向左转三圈，门锁上了，拔出钥匙");
	}

	@Override
	public void unlock() {
		System.out.println("插进钥匙，向右转三圈，门打开了，拔出钥匙");
	}

	@Override
	public void open() {
		System.out.println("用力推门，门打开了");

	}

	@Override
	public void close() {
		System.out.println("轻轻的拉门，门关上了");

	}

	@Override
	public void photo() {
		System.out.println("叮铃铃.......咔嚓.........照片已存储！");
	}

	public static void main(String[] args) {
		TheftproofDoor td = new TheftproofDoor();
		td.close();
		td.lock();
		td.photo();
		td.unlock();
		td.open();
	}

}
