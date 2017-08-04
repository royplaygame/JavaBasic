package com.hy.ly.basic;

import java.util.Random;

import org.junit.Test;

public class RandomTest {

	public static void main(String[] args) {
		Random random = new Random(100);
		Random random1 = new Random(100);
		for (int i = 0; i < 20; i++) {
			System.out.print(random.nextInt(10) + " ");
		}
		System.out.println();
		for (int i = 0; i < 20; i++) {
			System.out.print(random1.nextInt(10) + " ");
		}
		System.out.println();
		for (int i = 0; i < 20; i++) {
			System.out.print(random1.nextDouble() + " ");
		}
		System.out.println();
		for (int i = 0; i < 20; i++) {
			System.out.print(random1.nextBoolean() + " ");
		}
	}

	@Test
	public void testRandom() {
		Random random1 = new Random();
		//random1.setSeed(10);
		Random random = new Random();
		//random.setSeed(10);
		for (int i = 0; i < 20; i++) {
			System.out.print(random1.nextInt(10) + " ");
		}
		System.out.println();
		for (int i = 0; i < 20; i++) {
			System.out.print(random.nextInt(10) + " ");
		}
	}
}
