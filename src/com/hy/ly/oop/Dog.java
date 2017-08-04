package com.hy.ly.oop;

public class Dog extends Pet {

	private String name;
	private int health;
	private int intimacy;

	public void eat() {
		System.out.println(this.name + " 在吃骨头......");
	}

	public void showPetInfo() {
		System.out.println("宠物狗狗的健康值是:" + this.health);
	}
	
	public void catchingFlyDisc(){
		System.out.println(this.name+" 在和主人玩接飞盘游戏");
		this.health-=10;
		this.intimacy+=5;
	}

	public int getIntimacy() {
		return intimacy;
	}

	public void setIntimacy(int intimacy) {
		this.intimacy = intimacy;
	}

	public Dog(String name, int health) {
		super();
		this.name = name;
		this.health = health;
	}

	public Dog() {
	}



	@Override
	public String toString() {
		return "Dog [name=" + name + ", health=" + health + ", intimacy=" + intimacy + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}
	
}
