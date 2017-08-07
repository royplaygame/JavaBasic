package com.hy.ly.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * 1. 模拟一个trim方法，去除字符串两端的空格。 2.将一个字符串进行反转。将字符串中指定部分进行反转。比如将“abcdefg”反转为”abfedcg”
 * 3. 获取一个字符串在另一个字符串中出现的次数。比如：获取“ ab”在 “abkkcadkabkebfkabkskab” 中出现的次数 4.
 * 获取两个字符串中最大相同子串。比如： str1 = "abcwerthelloyuiodef“;str2 = "cvhellobnm"
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

	// 4.获取两个字符串中最大相同子串,只返回了第一个最大的子串
	public static String getMaxSubString(String str1, String str2) {
		String maxStr = (str1.length() > str2.length()) ? str1 : str2;
		String minStr = (str1.length() < str2.length()) ? str1 : str2;
		int len = minStr.length();
		// 遍历匹配的字串
		for (int i = 0; i < len; i++) {
			for (int x = 0, y = len - i; y < len; x++, y++) {
				String str = minStr.substring(x, y);
				if (maxStr.contains(str)) {
					return str;
				}
			}
		}
		return null;
	}

	// 4.获取两个字符串中最大相同子串,只返回了第一个最大的子串
	public static List<String> getMaxSubStrings(String str1, String str2) {
		String maxStr = (str1.length() > str2.length()) ? str1 : str2;
		String minStr = (str1.length() < str2.length()) ? str1 : str2;
		int len = minStr.length();
		List<String> list = new ArrayList<>();
		// 遍历匹配的字串
		for (int i = 0; i < len; i++) {
			for (int x = 0, y = len - i; y < len; x++, y++) {
				String str = minStr.substring(x, y);
				if (maxStr.contains(str)) {
					list.add(str);
				}
			}
			if (list.size() > 0) {
				return list;
			}
		}
		return null;
	}

	/**
	 * 5.对字符串中字符进行自然顺序排序。 提示： 1）字符串变成字符数组。 2）对数组排序，选择，冒泡，Arrays.sort();
	 * 3）将排序后的数组变成字符串。
	 * 
	 * @param args
	 */
	public static String sortStr(String str) {
		char []c=str.toCharArray();
		Arrays.sort(c);
		return new String(c);
	}
	
	/**
	 * 6. I am a student !  写一个方法输入出 ! student a am I
	 * @param args
	 */
	public static String  reverseWords(String str){
		String []strs=str.split(" ");
		List<String> list=Arrays.asList(strs);
		Collections.reverse(list);
		String []newStrs=(String [])list.toArray();
		
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<newStrs.length;i++){
			sb.append(newStrs[i]+" ");
		}
		return sb.toString();
	}

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

		// 获取两个字符串中最大相同子串,只返回第一个,比如：str1 = "abcwerthelloyuiodef";str2 =
		// "cvhellobnm"
		String str10 = StringDemo.getMaxSubString("abcwcerthelloyuiodef", "abcwcvhellobnm");
		System.out.println(str10);

		// 获取两个字符串中最大相同子串,返回一个list列表,比如：str1 = "abcwerthelloyuiodef";str2 =
		// "cvhellobnm"
		List<String> list = StringDemo.getMaxSubStrings("abcwcerthelloyuiodef", "abcwcvhellobnm");
		System.out.println(list);
		
		//对字符串中字符进行自然顺序排序
		String str11="abcwcerthelloyuiodef";
		System.out.println(StringDemo.sortStr(str11));
		
		//I am a student !  写一个方法输入出 ! student a am I
		String str12=StringDemo.reverseWords("I am a student !");
		System.out.println(str12);

	}
}
