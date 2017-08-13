package com.hy.ly.oop;

class Student {
	private String name;
	private int age;

	public void gotoClass() {
		System.out.println("走到教室......");
		Teacher.lecture();
		System.out.println("下课了......");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}

class Teacher {
	private String name;
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public static void lecture() {
		System.out.println("我正在讲Java基础");
	}
}

public class TestMethod {

	public static void main(String[] args) {
		Student s=new Student();
		s.gotoClass();
	}
}
