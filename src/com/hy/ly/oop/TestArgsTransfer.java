package com.hy.ly.oop;

public class TestArgsTransfer {
	public static void main(String[] args) {
		TestArgsTransfer tt = new TestArgsTransfer();
		DataSwap ds = new DataSwap();
		System.out.println("ds.i:" + ds.i + " ds.j:" + ds.j);
		tt.swap(ds);
		System.out.println(ds);
		System.out.println("ds.i:" + ds.i + " ds.j:" + ds.j);

	}

	// 交换元素的值
	public void swap(DataSwap d) {
		int temp = d.i;
		d.i = d.j;
		d.j = temp;
		System.out.println(d);// 打印引用变量d的值
	}
}

class DataSwap{
	int i = 10;
	int j = 5;
}
