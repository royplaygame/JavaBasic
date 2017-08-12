package com.hy.ly.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.Test;

import com.hy.ly.po.Teacher;

public class TestConstructor {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testConstructor() throws Exception {
		String className = "com.hy.ly.po.Teacher";
		// 1. 要求运行时类有空参的构造器，2.构造器的权限修饰符的权限要足够
		Class clazz = Class.forName(className);
		Teacher t = (Teacher) clazz.newInstance();
		System.out.println(t);

		// 调用带参的私有构造器
		Constructor con=clazz.getDeclaredConstructor(String.class,Integer.class,int.class);
		con.setAccessible(true);
		Teacher t2=(Teacher)con.newInstance("大方",18,100);
		System.out.println(t2);
		// 调用空参的构造器
		Constructor cons=clazz.getConstructor();
		Teacher t3=(Teacher) cons.newInstance();
		System.out.println(t3);
		
	}

	@SuppressWarnings("rawtypes")
	@Test
	public void testConstructor2() throws ClassNotFoundException {
		String className = "com.hy.ly.po.Teacher";
		// 1. 要求运行时类有空参的构造器，2.构造器的权限修饰符的权限要足够
		Class clazz = Class.forName(className);

		// 2. 获取所有的public构造器
		Constructor[] cons = clazz.getConstructors();
		for (Constructor c : cons) {
			System.out.println(c);
		}
		System.out.println();
		// 3. 获取所有的构造器
		Constructor[] cons1 = clazz.getDeclaredConstructors();
		for (Constructor c : cons1) {
			System.out.println(c);
		}
	}

	// 权限修饰符、方法名称、形参列表
	@SuppressWarnings("rawtypes")
	@Test
	public void testConstructor3() throws ClassNotFoundException {
		String className = "com.hy.ly.po.Teacher";
		// 1. 要求运行时类有空参的构造器，2.构造器的权限修饰符的权限要足够
		Class clazz = Class.forName(className);
		// 3. 获取所有的构造器
		Constructor[] cons1 = clazz.getDeclaredConstructors();
		for (Constructor c : cons1) {
			//1. 权限修饰符
			String str=Modifier.toString(c.getModifiers());
			System.out.print(str+" ");
			//2. 方法名称
			System.out.println(c.getName());
			//3. 形参列表
			System.out.println("(");
			Class []paras=c.getParameterTypes();
			for(int i=0;i<paras.length;i++){
				System.out.print(paras[i]+" args--"+i);
			}
			System.out.println(")");
			
			System.out.println(c);
		}
	}
}
