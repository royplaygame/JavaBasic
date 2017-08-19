package com.hy.ly.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.junit.Test;

public class TestException {

	// java.lang.ArithmeticException
	public static void main(String[] args) {
		int i = 0;
		int j = 100;
		int result;
		try {
			result = j / i;
			System.out.println(result);
		} catch (Exception ex) {
			System.out.println("零不能做被除数！");
			ex.printStackTrace();
			// System.exit(1);
		} finally {
			System.out.println("==============");
		}
	}

	@Test
	public void testException() throws Exception {
		int i = 0;
		int j = 100;
		int result;
		if (i != 0) {
			result = j / i;
		} else {
			throw new ArithmeticException("零不能做被除数!");
		}
		System.out.println(result);
	}

	/**
	 * 
	 */
	@Test
	public void testException2() {
		Scanner in = null;
		try {
			in = new Scanner(System.in);
			System.out.print("请输入被除数:");
			int num1 = in.nextInt();
			System.out.print("请输入除数:");
			int num2 = in.nextInt();
			System.out.println(String.format("%d/%d=%d", num1, num2, num1 / num2));
		} catch (InputMismatchException e) {
			System.err.println("被除数和除数必须是整数。");
		} catch (ArithmeticException e) {
			System.err.println("除数不能为零。");
		} catch (Exception e) {
			System.err.println("其他未知异常。");
		} finally {
			System.out.println("感谢使用本程序！");
		}
		in.close();
	}
}
