package com.hy.ly.po;

import java.util.Objects;

@SuppressWarnings("rawtypes")
public class Teacher implements Comparable {

	private String name;
	private Integer age;

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

	public Teacher(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}

	public Teacher() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31; // 质数
		int result = 1;
		result = prime * result + (name == null ? 0 : name.hashCode());
		result = prime * result + (age == null ? 0 : age.hashCode());
		return result;
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

	// 当向TreeSet中添加Teacher类的对象时,依据此方法，来确定按照属性排列
	@Override
	public int compareTo(Object o) {
		if (o instanceof Teacher) {
			Teacher t = (Teacher) o;
			// 如果age是int类型时，可以用-来做: return this.age-t.age;
			// 如果要倒序排，可以在返回值前面加个负号（-）
			// return this.age.compareTo(t.age);
			int i = this.age.compareTo(t.age);
			if (i == 0) {
				return this.name.compareTo(t.name);
			} else {
				return i;
			}
		}
		return 0;
	}

}
