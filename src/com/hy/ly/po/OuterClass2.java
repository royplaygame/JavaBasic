package com.hy.ly.po;

//java 内部类有：成员内部类、局部内部类、匿名内部类、静态内部类。

/**
 * 匿名内部类注意：
 * 
 * @author ssr
 *
 */

public class OuterClass2 {
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
	
	public InnerClass2 getInnerClass2(final int num){
		return new InnerClass2(){
			int count=num+3;
			@Override
			public int getCount() {
				return count;
			}
		};
	}

	public static void main(String[] args) {
		//测试匿名内部类
		OuterClass2 outer=new OuterClass2();
		InnerClass2 inner=outer.getInnerClass2(100);
		System.out.println(inner.getCount());
	}
}

interface InnerClass2{
	int getCount();
}
