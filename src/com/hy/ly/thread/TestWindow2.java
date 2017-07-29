package com.hy.ly.thread;

//解决重票问题
/**
 * 1. 存在的原因是什么？一个线程在没有操作完共享数据时，另一个线程参与进来，导致共享数据存在安全问题。 2.
 * 如何来解决线程的安全问题？一个线程在操作完共享数据后，其它线程才能参与操作共享数据。 3. java如何实现线程的同步机制？ 方式一：同步代码块,
 * 共享数据（线程共同操作的数据），同步监视器（一个类的对象，即锁） 方式二：同步方法
 * 
 * @author ssr
 *
 */

public class TestWindow2 {
	public static void main(String[] args) {
		Window2 w = new Window2();
		Thread t1 = new Thread(w);
		Thread t2 = new Thread(w);
		Thread t3 = new Thread(w);
		t1.start();
		t2.start();
		t3.start();
	}

}

class Window2 implements Runnable {
	int ticket = 100;
	// Object obj = new Object();

	@Override
	public void run() {
		while (true) {
			synchronized (this) { // this表示当前对象，也即小w
				if (ticket > 0) {
					try {
						Thread.currentThread().sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + "售票窗口。售票号为：" + ticket--);
				}
			}
		}
	}

}