package com.hy.ly.reflection;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;

import org.junit.Test;

import com.hy.ly.po.Teacher;

public class TestReflection {

	@SuppressWarnings("rawtypes")
	@Test
	public void testClassLoader() throws ClassNotFoundException, IOException {
		ClassLoader loader = ClassLoader.getSystemClassLoader();
		System.out.println(loader);
		System.out.println(loader.getParent());
		System.out.println(loader.getParent().getParent());

		Class clazz = Teacher.class;
		ClassLoader loader4 = clazz.getClassLoader();
		System.out.println(loader4);

		String className = "java.lang.Object"; // java.lang.String也一样是核心类加载
		Class clazz1 = Class.forName(className);
		System.out.println(clazz1.getClassLoader());

		// 类加载器可以，获取以流的方式获取类路径下的文件
		ClassLoader loader5 = this.getClass().getClassLoader();
		// InputStream in=loader5.getResourceAsStream("jdbc.properties");
		InputStream in = loader5.getResourceAsStream("com\\hy\\ly\\util\\jdbc.properties");
		Properties properties = new Properties();
		properties.load(in);

		System.out.println(properties.getProperty("user"));
		System.out.println(properties.getProperty("password"));
		System.out.println(properties.getProperty("url"));
		System.out.println(properties.getProperty("driver"));
		System.out.println();

		// 如果是在当前工程下，可以用文件的方式来读取
		FileInputStream fis = new FileInputStream(new File("jdbc.properties"));
		Properties properties1 = new Properties();
		properties1.load(fis);

		System.out.println(properties1.getProperty("user"));
		System.out.println(properties1.getProperty("password"));
		System.out.println(properties1.getProperty("url"));
		System.out.println(properties1.getProperty("driver"));
	}

	/**
	 * java.lang.Class反射的源头 1. 获取Class类的方法
	 * 
	 * @throws ClassNotFoundException
	 */
	@SuppressWarnings("rawtypes")
	@Test
	public void testClass() throws ClassNotFoundException {
		// 1. 运行时类的本身的.class属性

		Class<Teacher> clazz = Teacher.class;
		System.out.println(clazz.getName());

		Class<String> clazz1 = String.class;
		System.out.println(clazz1.getName());

		// 2. 通过运行时类的对象
		Teacher t = new Teacher();
		Class clazz2 = t.getClass();
		System.out.println(clazz2);

		// 3.通过Class的静态方法获取
		Class clazz3 = Class.forName("com.hy.ly.po.Teacher");
		System.out.println(clazz3.getName());

		// 4. 通过类加载器加载
		ClassLoader classLoader = this.getClass().getClassLoader();
		Class clazz4 = classLoader.loadClass("com.hy.ly.po.Teacher");
		System.out.println(clazz4.getName());

		// 比较四个Clazz对象
		System.out.println(clazz == clazz2);
		System.out.println(clazz == clazz3);
		System.out.println(clazz == clazz4);
	}

	// 在有反射以后，创建类的对象，以及调用类的方法、属性。
	@Test
	public void testReflection() throws Exception {
		Class<Teacher> clazz = Teacher.class;

		// 创建Clazz对应运行时Person类的对象
		Teacher t = clazz.newInstance();
		System.out.println(t);
		// 获取Clazz类的属性
		Field f = clazz.getField("name");
		f.set(t, "孙悟空");
		System.out.println(t);
		// 获取Clazz类的属性
		Field f1 = clazz.getDeclaredField("age");
		f1.setAccessible(true);
		f1.set(t, 16);
		System.out.println(t);
		// 获取Clazz类的调用方法
		Method m = clazz.getMethod("show");
		m.invoke(t);

		Method m1 = clazz.getMethod("display", String.class);
		m1.invoke(t, "中国");
	}

	// 在有反射以前，创建类的对象，以及调用类的方法、属性。
	@Test
	public void testBefore() {
		Teacher t = new Teacher();
		t.setAge(10);
		t.setName("王老师");
		System.out.println(t);
		t.show();
		//t.display("中国");
	}

}
