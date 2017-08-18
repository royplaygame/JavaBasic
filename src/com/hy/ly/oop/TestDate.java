package com.hy.ly.oop;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class TestDate {

	@Test
	public void testDate() throws ParseException{
		Date date=new Date();
		System.out.println(date);
		//日期转字符串
		SimpleDateFormat sdf=new SimpleDateFormat("yyy-MM-dd");
		System.out.println(sdf.format(date));
		
		//字符串转日期
		String myDate="2017-10-10";
		System.out.println(sdf.parse(myDate));
		
		//Calendar
		Calendar c=Calendar.getInstance();
		System.out.println(c.get(Calendar.YEAR));
		System.out.println(c.get(Calendar.MONTH)+1);  //月份需要加1
		System.out.println(c.get(Calendar.DAY_OF_MONTH));
		System.out.println(c.get(Calendar.HOUR));
		System.out.println(c.get(Calendar.MINUTE));
		System.out.println(c.get(Calendar.SECOND));
		
	}
}
