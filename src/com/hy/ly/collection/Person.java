package com.hy.ly.collection;

public class Person<T> {

	private String name;
	private int age;
	private T t;

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

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", t=" + t + "]";
	}

	public static void main(String[] args) {
		Person<String> p = new Person<>();
		p.setT("this is t");
		System.out.println(p);
		
		Person<Double> p1 = new Person<>();
		p1.setT(33.3);
		System.out.println(p1);
	}
}
