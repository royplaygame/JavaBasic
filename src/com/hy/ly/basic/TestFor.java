package com.hy.ly.basic;

import java.util.Scanner;

import org.junit.Test;

public class TestFor {

	public static void main(String[] args) {
		System.out.println("乘法口诀表：");
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(j + "*" + i + "=" + i * j + "\t");
			}
			System.out.println();
		}
	}

	@Test
	public void test2() {
		System.out.println("请输入圆的半径:");
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		// i代表每一行
		for (int i = 0; i <= 2 * r; i += 2) {
			// 圆上点到竖着半径的距离
			long y = Math.round(Math.sqrt(Math.pow(r, 2) - Math.pow(r - i, 2)));
			// 圆上点到外切正方形边的距离
			long x = r - y;
			// 先打印出正方形左边边到圆上点的空白部位
			for (int j = 0; j < x; j++) {
				System.out.print(" ");
			}
			// 打印出左边的圆上点
			System.out.print("*");
			// 打印出中间空白部分
			for (int k = 0; k < 2 * (r - x); k++) {
				System.out.print(" ");
			}
			// 打印出右边的圆上点 右边空白不要打直接换行
			System.out.println("*");
		}
		sc.close();
	}
	
	@Test
	public void test3(){
		System.out.println("请输入圆的半径:");
		Scanner sc = new Scanner(System.in);
		int l = sc.nextInt();
		for(int i=1;i<=l;i++){
			for(int j=1;j<=l;j++){
				if(i==1||i==l){
					System.out.print("* ");
				}else if(j==1||j==l){
					System.out.print("* ");
				}else{
					System.out.print("  ");
				}
			}
			System.out.println();
		}
		sc.close();
	}
	
	@Test
	public void test5(){
		final double PI=Math.PI;
		int r=10;
		double area;
		area=PI*r*r;
		System.out.println("圆形的面积是："+area);
	}
}
