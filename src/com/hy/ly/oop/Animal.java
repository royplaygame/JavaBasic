package com.hy.ly.oop;

public class Animal {
	protected String name;
	private String color;
	protected int age;

	public Animal() {
		super();
	}

	public Animal(String name, String color, int age) {
		super();
		this.name = name;
		this.color = color;
		this.age = age;
	}

	public void showInfo() {
		System.out.println("名称是：" + this.name + "\t" + this.color + "\t" + this.age);
	}
	
	protected void eat(){
		System.out.println("吃东西");
	}

	public static void main(String[] args) {
		Dogg dog = new Dogg();
		dog.name = "泰迪";
		dog.age = 3;
		dog.type = "牧羊犬";
		dog.showInfo();
		dog.catchFlyDisk();
		dog.eat();
		
		Animal a=new Dogg();
		a.name="泰迪";
		a.eat();
		Animal a1=new Catt();
		a1.name="Tom";
		a1.eat();
		Animal aa=new Animal();
		aa.eat();
	}
}

class Dogg extends Animal{
	public String type;
	Dogg(){
		super();
		this.name="ddd";
	}
	
	Dogg(String name, String color, int age,String type){
		super(name,color,age);
		this.type=type;
	}
	public void catchFlyDisk() {
		eat();
		super.eat();
		System.out.println(super.name + "玩飞碟游戏！");
	}
	
	public void eat(){
		System.out.println(this.name+"在吃骨头！");
	}
}

class Catt extends Animal{
	protected void eat(){
		System.out.println(this.name+"在吃小鱼！");
	}
}
