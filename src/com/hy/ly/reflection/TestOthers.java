package com.hy.ly.reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.junit.Test;

import com.hy.ly.po.Teacher;

public class TestOthers {
	
	@Test
	public void test(){



	}
	
	// 获取内部类
	@SuppressWarnings("rawtypes")
	@Test
	public void testInnerClass() {
		//Class clazz = Teacher.class;
		
	}

	// 获取类的注解
	@SuppressWarnings("rawtypes")
	@Test
	public void testAnno() {
		Class clazz = Teacher.class;
		Annotation[] anno = clazz.getAnnotations();
		for (Annotation a : anno) {
			System.out.println(a);
		}
	}

	// 获取所在的包
	@SuppressWarnings("rawtypes")
	@Test
	public void testPackage() {
		Class clazz = Teacher.class;
		Package pac = clazz.getPackage();
		System.out.println(pac);
	}

	// 获取实现的接口
	@SuppressWarnings("rawtypes")
	@Test
	public void testInterface() {
		Class clazz = Teacher.class;
		Class[] interf = clazz.getInterfaces();

		for (Class c : interf) {
			System.out.println(c);
		}
	}

	// 获取运行时类的的父类的泛型
	@SuppressWarnings("rawtypes")
	@Test
	public void testOthers3() {
		Class clazz = Teacher.class;
		Type type = clazz.getGenericSuperclass();
		ParameterizedType pType = (ParameterizedType) type;
		Type[] tps = pType.getActualTypeArguments();
		for (int i = 0; i < tps.length; i++) {
			System.out.println(((Class) tps[i]).getName());
		}
	}

	// 获取运行时类的带泛型的父类
	@SuppressWarnings("rawtypes")
	@Test
	public void testOthers2() {
		Class clazz = Teacher.class;
		Type type = clazz.getGenericSuperclass();

		System.out.println(type);
	}

	// 获取运行时类的父类
	@SuppressWarnings("rawtypes")
	@Test
	public void testOthers() {
		Class clazz = Teacher.class;
		Class superClass = clazz.getSuperclass();

		System.out.println(superClass);
	}
}
