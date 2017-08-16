package com.hy.ly.modify;

public class Cat extends Pet {
	public int age;
	Pet p = new Pet();

	public void test1() {
		System.out.println(super.uname);
	}
	
	public Cat(){
	}
	public Cat(String name,int age){
		//super();
		super(name);
		//this.uname=name;
		this.age=age;
	}

	protected void eat() {
		super.eat();
		System.out.println(uname+"小猫再吃小鱼！"+age);
	}

	public static void main(String[] args) {
		Cat c = new Cat("Tom",10);
		c.test1();
		c.eat();
	}
}
