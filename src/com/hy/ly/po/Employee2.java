package com.hy.ly.po;

import java.util.Objects;

public class Employee2 {

	private String name;
	private int age;
	private MyDate birthday;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (name == null ? 0 : name.hashCode());
		result = prime * result + (age == 0 ? 0 : age);
		result = prime * result + (birthday == null ? 0 : birthday.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		// 如果是同一对象的两个引用，返回true
		if (this == obj) {
			return true;
		}
		// 如果obj是null,返回false
		if (obj == null) {
			return false;
		}
		// 判断两个对象的类型是否相同，类型不同返回false
		if (getClass() != obj.getClass()) {
			return false;
		}
		Employee2 emp = (Employee2) obj;

		return Objects.equals(this.name, emp.name) && Objects.equals(this.age, emp.age)
				&& Objects.equals(this.birthday, emp.birthday);
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

	public MyDate getBirthday() {
		return birthday;
	}

	public void setBirthday(MyDate birthday) {
		this.birthday = birthday;
	}

	public Employee2(String name, int age, MyDate birthday) {
		super();
		this.name = name;
		this.age = age;
		this.birthday = birthday;
	}

	public Employee2() {
		super();
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", birthday=" + birthday + "]";
	}
}
