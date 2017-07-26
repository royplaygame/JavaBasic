package com.hy.ly.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import org.junit.Test;

public class TestObjectInputOutputStream {
	// 对象反序列化过程：把保存在硬盘的文件ObjectOutputStream转换相应的对象。
	@Test
	public void testObjectInputStream(){
		ObjectInputStream ois=null;
		try{
			ois=new ObjectInputStream(new FileInputStream("person.txt"));
			Person p=(Person) ois.readObject();
			System.out.println(p);
			
			Person p2=(Person) ois.readObject();
			System.out.println(p2);
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			if(ois!=null){
				try {
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	

	// 对象序列化过程：把内存中的对象通过ObjectOutputStream转换成二进制流，保存在硬盘的文件E中

	@Test
	public void testObjectOutputStream() {
		Person p = new Person("大米", 100);
		Person p1 = new Person("松鼠", 20);

		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream("person.txt"));

			oos.writeObject(p);
			oos.flush();
			oos.writeObject(p1);
			oos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

/**
 * 要实现序列化的类：
 * 1. 要求此类是可序列化的。实现如下两个接口之一：serializable、Externalizable
 * 2. 要求类的属性也要实现序列化的接口。
 * 3. 提供一个版本号。private static final long serialVersionUID = 5236598454678901909L;
 * 4. ObjectOutputStream和ObjectInputStream不能序列化static和trainsient修饰的变量。
 * @author ssr
 *
 */
class Person implements Serializable{

	private static final long serialVersionUID = 5236598454678901909L;
	String name;
	int age;

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

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

	public Person() {
		super();
	}

}