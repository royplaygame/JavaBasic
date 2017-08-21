package com.hy.ly.util;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Locale;

public class CharSet {
	public static void main(String[] args) throws UnsupportedEncodingException {
		/**
		 * 问题来了，Charset.defaultCharset()由什么决定的呢？ 1、如果使用了eclipse，由java文件的编码决定
		 * 2、如果没有使用eclipse，则有本地电脑语言环境决定，中国的都是默认GBK编码
		 * 3.字符编码：http://www.cnblogs.com/God-/p/6006749.html
		 */
		// windows环境，直接修改jdk编码在系统变量→新建 “JAVA_TOOL_OPTIONS”
		// 变量，值为“-Dfile.encoding=UTF-8”
		String a = "张";
		System.out.println(a.getBytes("utf-8").length);
		System.out.println(a.getBytes("GBK").length);
		System.out.println(a.getBytes("GB2312").length);

		System.out.println(Charset.defaultCharset().displayName());
		System.out.println(Charset.defaultCharset().displayName(Locale.US));

		String defaultCharsetName = Charset.defaultCharset().displayName();
		System.out.println("defaultCharsetName:" + defaultCharsetName);
	}
}
