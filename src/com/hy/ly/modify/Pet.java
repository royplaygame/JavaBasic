package com.hy.ly.modify;

public class Pet {

	String uname;

	public Pet() {

	}

	public Pet(String uname) {
		this.uname = uname;
	}

	public void introduceMyself() {
		System.out.println(uname);
	}

	protected void eat() {
		System.out.println("宠物吃东西！");
	}
}
