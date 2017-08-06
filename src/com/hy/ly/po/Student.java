package com.hy.ly.po;

import java.util.Objects;

public class Student {

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", sex=" + sex + ", phone=" + phone + "]";
	}

	private Integer id;
	private String name;
	private String sex;
	private String phone;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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
		Student stu = (Student) obj;

		return Objects.equals(name, stu.name) && id == stu.id && Objects.equals(sex, stu.sex)
				&& Objects.equals(phone, stu.phone);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((sex == null) ? 0 : sex.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		return result;
	}

	public Student() {
		super();
	}

	public Student(Integer id, String name, String sex, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.phone = phone;
	}

}