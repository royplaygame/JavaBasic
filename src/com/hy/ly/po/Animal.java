package com.hy.ly.po;

public class Animal {

	private String name;
	private int age;
	private final String color="red";
	
	public String getColor() {
		return color;
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
	
	public final void eat(){
		System.out.println("吃东西");
	}

	@Override
	public String toString() {
		return "Animal [name=" + name + ", age=" + age + ", color=" + color + "]";
	}
	
}
