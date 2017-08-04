package com.hy.ly.basic;

import org.junit.Test;

public class SortTest {
	int as[] = { 1, 25, 56, 35, 22, 9, 8, 2, 4 };

	/**
	 * 冒泡排序 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
	 * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数。 针对所有的元素重复以上的步骤，除了最后一个。
	 * 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
	 */
	@Test
	public void bubbleTest() {
		// 输出原字符串
		for (int i = 0; i < as.length; i++) {
			System.out.print(as[i] + " ");
		}
		System.out.println();
		for (int i = 0; i < as.length - 1; i++) {
			for (int j = 0; j < as.length - 1 - i; j++) {
				if (as[j] > as[j + 1]) {
					int temp = as[j];
					as[j] = as[j + 1];
					as[j + 1] = temp;
				}
			}
		}

		// 输出排序后的字符串
		for (int i = 0; i < as.length; i++) {
			System.out.print(as[i] + " ");
		}
	}

	/**
	 * 选择排序
	 */
	@Test
	public void testSelect() {
		// 输出原字符串
		for (int i = 0; i < as.length; i++) {
			System.out.print(as[i] + " ");
		}

		System.out.println();

		int size = as.length;
		for (int i = 0; i < size; i++) {
			int k = i;
			// 找到一个最小值
			for (int j = size - 1; j > i; j--) {
				if (as[j] < as[k]) {
					k = j;
				}
			}
			// 把最小值交换到相应的位置
			int temp = as[i];
			as[i] = as[k];
			as[k] = temp;
		}

		// 输出排序后的字符串
		for (int i = 0; i < as.length; i++) {
			System.out.print(as[i] + " ");
		}
	}

	// 插入排序
	@Test
	public void testInsertSort() {
		// 输出原字符串
		for (int i = 0; i < as.length; i++) {
			System.out.print(as[i] + " ");
		}
		System.out.println();

		int size = as.length;
		int temp = 0;
		int j = 0;

		for (int i = 0; i < size; i++) {
			temp = as[i];
			// 假如temp比前面的值小，则将前面的值后移
			for (j = i; j > 0 && temp < as[j - 1]; j--) {
				as[j] = as[j - 1];
			}
			as[j] = temp;
		}

		// 输出排序后的字符串
		for (int i = 0; i < as.length; i++) {
			System.out.print(as[i] + " ");
		}
	}
}
