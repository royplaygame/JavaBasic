package com.hy.ly.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.junit.Test;

import com.hy.ly.po.Teacher;

public class TestField {
	// 调用运行时类指定的属性
	@SuppressWarnings("rawtypes")
	@Test
	public void testFieldRun() throws Exception {
		Class clazz = Teacher.class;
		// 获取属性
		Field name = clazz.getField("name");
		Field age =clazz.getDeclaredField("age");
		// 创建对象
		Teacher t = (Teacher) clazz.newInstance();
		System.out.println(t);
		// 调用指定的属性,给指定属性赋值
		name.set(t, "zhangsan");
		age.setAccessible(true);
		age.set(t, 16);
		System.out.println(t);
		
		

	}

	// 获取属性
	@SuppressWarnings("rawtypes")
	@Test
	public void testField() {
		Class clazz = Teacher.class;
		// clazz.getFields()只能获取运行时类中及其父类中的public类型的属性
		Field[] fields = clazz.getFields();
		for (int i = 0; i < fields.length; i++) {
			System.out.println(fields[i]);
		}
		System.out.println();
		// 获取取运行时类本身所有的属性clazz.getDeclaredFields()
		Field[] fields2 = clazz.getDeclaredFields();
		for (int i = 0; i < fields2.length; i++) {
			System.out.println(fields2[i]);
		}

	}

	// 权限修饰符、属性类型、属性名称
	@SuppressWarnings("rawtypes")
	@Test
	public void testFlag() {
		Class clazz = Teacher.class;
		// 获取取运行时类本身所有的属性clazz.getDeclaredFields()
		Field[] fields = clazz.getDeclaredFields();
		for (Field f : fields) {
			// 1. 获取权限修饰符
			int i = f.getModifiers();
			String str = Modifier.toString(i);
			System.out.print(i + " " + str + " ");
			// 2. 获取属性类型
			Class type = f.getType();
			System.out.print(type.getName() + " ");
			// 3. 获取属性名称
			System.out.print(f.getName());
			System.out.println();
		}
	}
}
