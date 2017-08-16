package com.hy.ly.oop;

import com.hy.ly.modify.Pet;
public class Parent {
	public String uname = "haha";
    Pet p = new Pet();
    public void test2(){
       // System.out.println(p.uname);
    }
    
    public static void main(String[] args) {
		Parent p=new Parent();
		p.test2();
	}
}
