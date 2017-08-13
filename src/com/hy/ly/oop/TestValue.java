package com.hy.ly.oop;

public class TestValue {

	public static void main(String[] args) {
		int i = 10;
		int j = 5;
		System.out.println("i:" + i + " j:" + j);// i : 10 j : 5

		// 交换变量i与j的值
		/*int temp = i;
		i = j;
		j = temp;*/
		swap(i,j);

		System.out.println("i:" + i + " j:" + j);// i : 10 j : 5
	}

	public static void swap(int m, int n) {
		int temp = m;
		m = n;
		n = temp;
		//System.out.println("m:" + m + " n:" + n);

	}
}
