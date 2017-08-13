package com.hy.ly.oop;

public class Cat {
	public String name;
	public int age;
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
		return "Cat [name=" + name + ", age=" + age + "]";
	}
	public Cat(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public Cat() {
		super();
	}
	
	public static void main(String[] args) {
		/*String str="Tom";
		Cat c1=new Cat(str,16);
		Cat c2=new Cat(str,18);
		System.out.println(c1);
		System.out.println(c2);
		System.out.println();
		str="TomCat";
		System.out.println(c1);
		System.out.println(c2);*/
		
		
		/*String str1="good";
		String str2="good";
		String str3=new String("good");
		System.out.println(str1==str2);
		System.out.println(str1==str3);
		System.out.println(str1.equals(str2));
		System.out.println(str1.equals(str3));*/
		
		/*String str5=new String("myGod");
		String str6=str5;
		System.out.println(str5);
		System.out.println(str6);
		str5="Oh MyGod";
		System.out.println(str5);
		System.out.println(str6);*/
		
		String []strs=new String[2];
		strs[0]="good";
		strs[1]="look";
		
		String []strs2=strs;
		System.out.print("字符串strs:");
		for(String str:strs){
			System.out.print(str+" ");
		}
		System.out.println();
		
		System.out.print("字符串strs2:");
		for(String str:strs2){
			System.out.print(str+" ");
		}
		
		strs[0]="my good";
		System.out.println("\n");
		System.out.print("字符串strs:");
		for(String str:strs){
			System.out.print(str+" ");
		}
		System.out.println();
		
		System.out.print("字符串strs2:");
		for(String str:strs2){
			System.out.print(str+" ");
		}
	}

}
