package com.hy.ly.thread;

public class TestWindow1 {
	public static void main(String[] args) {
		Window1 w = new Window1();
		Thread t1= new Thread(w);
		Thread t2 = new Thread(w);
		Thread t3 = new Thread(w);
		t1.start();
		t2.start();
		t3.start();
	}
	
}

class Window1 implements Runnable {
	int ticket = 100;

	@SuppressWarnings("static-access")
	@Override
	public void run() {
		while (true) {
			//加大错误的暴露几率
			try {
				Thread.currentThread().sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (ticket > 0) {
				System.out.println(Thread.currentThread().getName() + "售票窗口。售票号为：" + ticket--);
			} else {
				break;
			}
		}
	}

}