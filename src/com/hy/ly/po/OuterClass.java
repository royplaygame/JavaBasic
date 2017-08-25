package com.hy.ly.po;

//java 内部类有：成员内部类、局部内部类、匿名内部类、静态内部类。

/**
 * 成员内部类注意： (是类外围的一个成员)
 * 1.成员内部类不能存在任务的static的变量和方法； 
 * 2.成员内部类依附于外围类的，所以只有创建了外围类才能够创建内部类;
 * 
 * @author ssr
 *
 */

public class OuterClass {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void outerShow() {
		System.out.println("this is outerClass");
	}

	public class InnerClass {
		public void innerShow() {
			// 调用外围属性
			name = "my name is Tom";
			System.out.println(name);
			// 调用外围方法
			outerShow();
		}
	}

	// 获取内部类的对象，推荐用getXxx()方法获取，尤其在该内部类的构造函数无参时
	public InnerClass getInnerClass() {
		return new InnerClass();
	}
	public static void main(String[] args) {
		OuterClass outer=new OuterClass();
		//常用的获取内部的类对象方法
		OuterClass.InnerClass inner=outer.getInnerClass();
		inner.innerShow();
		
		//获取内部类对象的另一种方式
		OuterClass.InnerClass inner1=outer.new InnerClass();
		inner1.innerShow();
	}
}
