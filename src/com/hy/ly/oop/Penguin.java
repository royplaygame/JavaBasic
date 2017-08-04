package com.hy.ly.oop;

public class Penguin extends Pet {
	private String name;
	private int health;
	private int intimacy;
	public Penguin() {
	}

	public Penguin(String name, int health) {
		super();
		this.name = name;
		this.health = health;
	}

	public void eat() {
		System.out.println(this.name + " 在吃小鱼......");
	}

	public void showPetInfo() {
		System.out.println("宠物企鹅的健康值是:" + this.health);
	}
	
	public void swimming(){
		System.out.println(this.name+" 小企鹅在和主人玩游泳游戏");
		this.health-=10;
		this.intimacy+=5;
	}

	public int getIntimacy() {
		return intimacy;
	}

	public void setIntimacy(int intimacy) {
		this.intimacy = intimacy;
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

	@Override
	public String toString() {
		return "Penguin [name=" + name + ", health=" + health + ", intimacy=" + intimacy + "]";
	}

	
	
}
