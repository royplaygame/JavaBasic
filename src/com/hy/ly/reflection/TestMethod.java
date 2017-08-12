package com.hy.ly.reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.junit.Test;

import com.hy.ly.po.Teacher;

public class TestMethod {
	// 调用方法
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testMethodRun() throws Exception {
		Class clazz = Teacher.class;
		//获取指定方法
		Method show=clazz.getMethod("show");
		
		//创建运行时类
		Teacher t=(Teacher) clazz.newInstance();
		//执行运行时类的指定方法
		show.invoke(t);
		
		//获取第二个方法
		Method toString=clazz.getMethod("toString");
		t.setAge(10);
		t.setName("刘备");
		Object obj=toString.invoke(t);
		System.out.println(obj);
		
		//获取第三个方法私有的方法
		Method showInfo=clazz.getDeclaredMethod("showInfo");
		showInfo.setAccessible(true);
		Object objs=showInfo.invoke(t);
		System.out.println(objs);
		
		//调用带参数的方法
		Method display=clazz.getMethod("display", String.class);
		display.invoke(t, "中国");
		
		//调用静态方法
		Method info=clazz.getMethod("info");
		info.invoke(Teacher.class);
		
		
	}

	@SuppressWarnings("rawtypes")
	@Test
	public void testMethod() {
		Class clazz = Teacher.class;

		// getMethods()获取运行时类、及其父类所有声明成public的方法
		Method[] methods = clazz.getMethods();

		for (Method m : methods) {
			System.out.println(m);
		}
		System.out.println();
		// getDeclaredMethods()获取运行时类本身声明的所有的方法
		Method[] methods1 = clazz.getDeclaredMethods();
		for (Method m : methods1) {
			System.out.println(m);
		}
	}

	// 注解、权限修饰符、返回值类型、方法名称、形参列表、异常
	@SuppressWarnings("rawtypes")
	@Test
	public void testMethod2() {
		Class clazz = Teacher.class;
		// getDeclaredMethods()获取运行时类本身声明的所有的方法
		Method[] methods1 = clazz.getDeclaredMethods();
		for (Method m : methods1) {

			// 1.获取注解
			Annotation[] ann = m.getAnnotations();
			for (Annotation a : ann) {
				System.out.println(a);
			}
			// 2. 权限修饰符
			String str = Modifier.toString(m.getModifiers());
			System.out.print(str + " ");
			// 3. 返回值类型
			Class retrunType = m.getReturnType();
			System.out.print(retrunType.getName() + " ");
			// 4. 方法名称
			System.out.print(m.getName());
			// 5. 形参列表
			System.out.print("(");
			Class[] params = m.getParameterTypes();
			for (int i = 0; i < params.length; i++) {
				System.out.print(params[i].getName() + " args--" + i + " ");
			}
			System.out.print(")");
			// 6. 异常

			Class[] exps = m.getExceptionTypes();
			if (exps.length > 0) {
				System.out.print(" throws ");
			}
			for (int i = 0; i < exps.length; i++) {
				System.out.print(exps[i].getName() + " ");
			}

			System.out.println();

		}

	}
}
