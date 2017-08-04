package com.hy.ly.singleton;

//线程通信 wait()  notify()  notifyAll()
//线程输出1～100，线程1和线程2交替打印。
public class TestCommunation {
	public static void main(String[] args) {
		PrintNumber p = new PrintNumber();
		Thread t1 = new Thread(p);
		Thread t2 = new Thread(p);

		t1.setName("线程1");
		t2.setName("线程2");
		t1.start();
		t2.start();
	}
}

class PrintNumber implements Runnable {
	int num = 1;

	@SuppressWarnings("static-access")
	@Override
	public void run() {
		while (true) {
			synchronized (this) {
				notify();
				if (num <= 100) {
					try {
						Thread.currentThread().sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + " " + num);
					num++;
				} else {
					break;
				}
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}