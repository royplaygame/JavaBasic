package com.hy.ly.inface;

public class WoodBird extends Bird {

	private String type;
	private int attackValue;
	
	@Override
	public void attack() {
		System.out.println("我是木头鸟，木头攻击很厉害哟！");

	}

	@Override
	public void eat() {
		System.out.println("我是木头鸟,木头是我的食物哟！");

	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getAttackValue() {
		return attackValue;
	}

	public void setAttackValue(int attackValue) {
		this.attackValue = attackValue;
	}

	public static void main(String[] args) {
		final WoodBird b=new WoodBird();
		b.setType("木头鸟");
		b.setAttackValue(100);
		//b=new WoodBird();
		
		//抽象类不能被实例化
		//Bird bird=new Bird();
	}
}
