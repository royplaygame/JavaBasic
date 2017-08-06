package com.hy.ly.po;

import java.util.Objects;

public class Teacher {
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

	@Override
	public String toString() {
		return "Teacher [name=" + name + ", age=" + age + "]";
	}

	public Teacher(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public Teacher() {
		super();
	}

	@Override
	public boolean equals(Object obj) {
		// 如果为同一对象的不同引用,则相同
		if (this == obj) {
			return true;
		}

		// 如果传入的对象为空,则返回false
		if (obj == null) {
			return false;
		}
		// 如果两者属于不同的类型,不能相等
		if (getClass() != obj.getClass()) {
			return false;
		}

		// 类型相同, 比较内容是否相同
		Teacher tea = (Teacher) obj;

		return Objects.equals(name, tea.name) && age == tea.age;
	}

}
