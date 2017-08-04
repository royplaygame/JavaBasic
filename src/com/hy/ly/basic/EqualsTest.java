package com.hy.ly.basic;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import com.hy.ly.po.Student;

public class EqualsTest {

	public static void main(String[] args) {
		Student stu1 = new Student(1001, "zhangsan", "男", "18399991111");
		Student stu2 = new Student(1001, "zhangsan", "男", "18399991111");
		Student stu4 = new Student(1005, "zhangsan", "女", "18399991111");
		Student stu3 = stu1;

		System.out.println(stu1 == stu2);
		System.out.println(stu1.equals(stu2));

		System.out.println(stu1 == stu3);
		System.out.println(stu1.equals(stu3));

		int hashCode = stu1.hashCode();
		System.out.println(hashCode);
		System.out.println(stu2.hashCode());
		System.out.println(stu3.hashCode());
		System.out.println(stu4.hashCode());
		
		
		String []hobbys=new String[5];
		hobbys[0]="pingpang";
		hobbys[1]="yumaoqiu";
		hobbys[2]="lanqiu";
		hobbys[3]="zuqiu";
		hobbys[4]="wangqiu";
		
		List<String> list=Arrays.asList(hobbys);
		for(String s:list){
			System.out.println(s);
		}
		
	}
}
