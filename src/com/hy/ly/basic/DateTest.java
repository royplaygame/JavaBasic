package com.hy.ly.basic;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class DateTest {

	public static void main(String[] args) {
		Date date=new Date();
		System.out.println(date);
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		SimpleDateFormat sdf2=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(sdf.format(date));
		System.out.println(sdf1.format(date));
		System.out.println(sdf2.format(date));
	}
	
	@Test
	public void testCalendar(){
		Calendar calendar=Calendar.getInstance();
		System.out.println(calendar.getTime());
		System.out.println(calendar.getTimeInMillis());
		System.out.println(calendar.getTimeZone());
		System.out.println(calendar.get(Calendar.YEAR));
		System.out.println(calendar.get(Calendar.MONTH));
		System.out.println(calendar.get(Calendar.DATE));
		System.out.println(calendar.get(Calendar.HOUR));
		System.out.println(calendar.get(Calendar.MINUTE));
		System.out.println(calendar.get(Calendar.SECOND));
	}
	
	@Test
	public void testTime(){
		long time=System.currentTimeMillis();
		System.out.println(time);
		Date dt=new Date(time);
		System.out.println(dt);
		
		Timestamp st=new Timestamp(System.currentTimeMillis());
		System.out.println(st);
	}
	
}
