package com.hy.ly.util;

/**
 *
 * 1. 模拟一个trim方法，去除字符串两端的空格。 2.将一个字符串进行反转。将字符串中指定部分进行反转。比如将“abcdefg”反转为”abfedcg”
 * 3. 获取一个字符串在另一个字符串中出现的次数。比如：获取“ ab”在 “abkkcadkabkebfkabkskab” 中出现的次数
 * 4. 获取两个字符串中最大相同子串。比如： str1 = "abcwerthelloyuiodef“;str2 = "cvhellobnm"
 * 提示：将短的那个串进行长度依次递减的子串与较长 的串比较。
 * 
 * 5.对字符串中字符进行自然顺序排序。 提示： 1）字符串变成字符数组。 2）对数组排序，选择，冒泡，Arrays.sort();
 * 3）将排序后的数组变成字符串。
 * 
 * @author ssr
 *
 */
public class StringDemo {

	// 1. 模拟一个trim方法，去除字符串两端的空格。
	public static String myTrim(String str) {
		int start = 0;
		int end = str.length() - 1;
		while (start < end && str.charAt(start) == ' ') {
			start++;
		}

		while (start < end && str.charAt(end) == ' ') {
			end--;
		}
		return str.substring(start, end + 1);
	}

	// 2. 将一个字符串进行反转。将字符串中指定部分进行反转
	public static String myReverse(String str, int start, int end) {
		char[] ch = str.toCharArray();
		for (int i = start, j = end; i < j; i++, j--) {
			char temp = ch[i];
			ch[i] = ch[j];
			ch[j] = temp;
		}
		// 字符数组转化成字符串
		return new String(ch);
	}

	// 2. 将一个字符串进行反转。将字符串中指定部分进行反转,方法二：
	public static String myReverse2(String str, int start, int end) {
		String str1 = str.substring(0, start);

		for (int i = end; i >= start; i--) {
			char c = str.charAt(i);
			str1 += c;
		}
		str1 += str.substring(end + 1);
		return str1;
	}

	// 3. 获取一个字符串在另一个字符串中出现的次数。比如：获取“ ab”在 “abkkcadkabkebfkabkskab” 中出现的次数
	public static int myCount(String str1, String str2) {
		int count = 0;
		int pos;
		while ((pos = str1.indexOf(str2)) != -1) {
			str1 = str1.substring(pos + str2.length());
			count++;
		}

		return count;
	}

	//4.获取两个字符串中最大相同子串
	
	public static void main(String[] args) {
		String str3 = "   thiis    ";
		String str5 = "   ";
		System.out.println("===========" + StringDemo.myTrim(str3) + "===============");
		System.out.println("===========" + str3 + "===============");
		System.out.println(StringDemo.myTrim(str5));

		String str6 = "abcdefg";
		String str7 = StringDemo.myReverse(str6, 2, 5);
		System.out.println(str7);
		System.out.println(StringDemo.myReverse2(str6, 2, 5));

		String str8 = "abkkcadkabkebfkabkskab";
		String str9 = "ab";
		System.out.println(StringDemo.myCount(str8, str9));

	}
}
