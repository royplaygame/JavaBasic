package com.hy.ly.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

/**
 * 与时间相关的类 1. java.lang.System 2. java.util.Date 3. java.text.SimpleDateFormat
 * 4. java.util.Calendar
 * 
 * @author ssr
 *
 */
public class TestDate {

	@Test
	public void testDate() {
		// java.sql.Date date1=new java.sql.Date(3994845858838383l);
		// System.out.println(date1);
		Date date = new Date();
		System.out.println(date);
		System.out.println(date.getTime());

	}

	/**
	 * java.text.SimpleDateFormat易于国际化
	 * 
	 * 1. 将一个日期转化成字符串(格式化) 2. 将一个字符串转化为日期(解析)
	 * 
	 * @throws ParseException
	 */
	@Test
	public void testSimpleDateFormart() throws ParseException {
		// 格式化一：
		SimpleDateFormat sdf = new SimpleDateFormat();
		String strDate = sdf.format(new Date());
		System.out.println(strDate);
		// 格式化二：
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String strDate1 = sdf1.format(new Date());
		System.out.println(strDate1);

		// 将一个字符串转化为日期(解析)
		Date date = sdf.parse("17-8-6 下午10:21");
		System.out.println(date);

		Date date1 = sdf1.parse("2017-08-06 22:24:02");
		System.out.println(date1);

	}

	// 三天打渔两天晒网， 问1990-01-01, xxxx-xx-xx 打渔？ 晒网？

	// 返回两个日期之间的天数，date1早于date2
	public static long getTotalDays(String date1, String date2) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date d1 = sdf.parse(date1);
		Date d2 = sdf.parse(date2);
		return ((d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24))+1;
	}

	@Test
	public void testDate2() throws ParseException {
		String str1 = "1990-01-01";
		String str2 = "1990-01-06";
		long days = TestDate.getTotalDays(str1, str2);
		System.out.println(days);
		//如果%5整除是最后一天，如果余4是第4天，这个说明最后两天
		if (days % 5 == 0 || days % 5 == 4) {
			System.out.println("晒网");
		} else {
			System.out.println("打渔");
		}
	}
	
	@Test
	public void testCalendar(){
		Calendar c=Calendar.getInstance();
		System.out.println(c.get(Calendar.DAY_OF_MONTH));
		
		c.add(Calendar.DAY_OF_MONTH, 8);
		System.out.println(c.get(Calendar.DAY_OF_MONTH));
		
		c.set(Calendar.DAY_OF_MONTH, 15);
		System.out.println(c.get(Calendar.DAY_OF_MONTH));
	}
}
