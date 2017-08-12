package com.hy.ly.po;

import java.util.Objects;

@SuppressWarnings("rawtypes")
@MyAnnotation(value = "luoyang")
public class Teacher extends Creature<String> implements Comparable, MyInterface {

	private static final long serialVersionUID = -7940922469680343056L;
	public String name;
	private Integer age;
	int id;
	protected int total;

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

	@MyAnnotation(value = "mymethod123")
	public void show() {
		System.out.println("我是一个教师！");
	}
	
	@SuppressWarnings("unused")
	private void showInfo() {
		System.out.println("我是一个教师！");
	}
	
	public static void info(){
		System.out.println("我是一个中国人！");
	}

	public void display(String nation) throws Exception{
		System.out.println("我的国籍是：" + nation);
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
	@SuppressWarnings("unused")
	private Teacher(String name, Integer age,int total) {
		super();
		this.name = name;
		this.age = age;
		this.total=total;
	}

	public Teacher() {
		super();
		System.out.println("初始化Teacher类对象");
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

	class bird {

	}
}
