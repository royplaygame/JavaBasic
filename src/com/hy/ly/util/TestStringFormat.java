package com.hy.ly.util;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestStringFormat {

	public static void main(String[] args) {
		String str = "123456789";
		DecimalFormat df = new DecimalFormat("#,###");
		Double d = Double.parseDouble(str);
		String neStr = df.format(d);
		System.out.println(neStr);
	}

	// 字符串从右边起，每三位加一个逗号，例如str = "1,234,567,890";
	@Test
	public void testInsert() {
		String str = "123456789179";
		StringBuffer sb = new StringBuffer(str);
		char[] ch = sb.reverse().toString().toCharArray();

		StringBuffer sb1 = new StringBuffer();
		for (int i = 0; i < ch.length; i++) {
			sb1.append(ch[i]);
			if ((i + 1) % 3 == 0&&(i+1)!=ch.length) {
				sb1.append(",");
			}
		}
		String newStr = sb1.reverse().toString();
		System.out.println(new String(ch));
		System.out.println(newStr);
	}

	// 字符串从右边起，每三位加一个逗号，例如str = "1,234,567,890";
	@Test
	public void testInsert2() {
		String str = "123456789179";
		List<String> list = new ArrayList<>();
		int len = str.length();
		while (len > 0) {
			if (len < 3) {
				list.add(str.substring(0, len));
			} else {
				list.add(str.substring(len - 3, len));
			}
			len -= 3;
		}
		StringBuffer sb = new StringBuffer();
		int total = list.size() - 1;
		for (int i = total; i >= 0; i--) {
			if (i == 0) {
				sb.append(list.get(i));
			} else {
				sb.append(list.get(i) + ",");
			}
		}
		System.out.println(sb.toString());
	}
}
