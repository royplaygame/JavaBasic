package com.hy.ly.thread;

/**
 * 线程优先级 1. st.getPriority();st.setPriority(10);
 * 
 * @author ssr
 *
 */
public class TestThread {
	public static void main(String[] args) {
		SubThread st = new SubThread();
		SubThread st1 = new SubThread();
		st.setName("子线程1"); // 设置线程名称
		st.setPriority(Thread.MAX_PRIORITY); // 设置线程优先级
		st.start();
		st1.setName("子线程2");
		st1.start();

		for (int j = 0; j < 100; j++) {
			System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getPriority() + " " + j);
			// 获取线程名称
			/*
			 * if (j % 10 == 0) { Thread.currentThread().yield(); //会释放cpu的使用权限
			 * }
			 */
			/*
			 * if (j == 20) { try { st.join();
			 * //执行到此方法，要求A线程停止，B线程开始，直到B线程执行完成，A线程再开始执行。 } catch
			 * (InterruptedException e) { e.printStackTrace(); } }
			 * System.out.println(st.isAlive()); //判断st线程是否存活。
			 */ }
	}
}

class SubThread extends Thread {
	// 2.重写线程类的run方法
	public void run() {
		for (int i = 0; i < 100; i++) {
			/*
			 * try { Thread.currentThread().sleep(1000); //线程睡眠1秒 } catch
			 * (InterruptedException e) { e.printStackTrace(); }
			 */
			System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getPriority() + " " + i);
		}
	}

}
