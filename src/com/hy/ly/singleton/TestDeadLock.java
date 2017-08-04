package com.hy.ly.singleton;

//死锁问题出现的例子。
public class TestDeadLock {

	static StringBuffer sb1 = new StringBuffer();
	static StringBuffer sb2 = new StringBuffer();

	public static void main(String[] args) {
		new Thread() {
			@SuppressWarnings("static-access")
			public void run() {
				synchronized (sb1) {
					try {
						Thread.currentThread().sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					sb1.append("A");
					synchronized (sb2) {
						sb2.append("B");
						System.out.println(sb1);
						System.out.println(sb2);
					}
				}
			}
		}.start();

		new Thread() {
			@SuppressWarnings("static-access")
			public void run() {
				synchronized (sb2) {
					try {
						Thread.currentThread().sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					sb1.append("C");
					synchronized (sb1) {
						sb2.append("D");
						System.out.println(sb1);
						System.out.println(sb2);
					}
				}
			}
		}.start();
	}

}
