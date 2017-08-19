package com.hy.ly.generic;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.hy.ly.po.Music;

public class TestGeneric {

	// 不使用泛型，容易的出现java.lang.ClassCastException异常
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testGeneric() {
		List list = new ArrayList();
		list.add("book");
		list.add("look");
		list.add("good");
		list.add(1000);

		for (int i = 0; i < list.size(); i++) {
			// System.out.println(list.get(i));
			String str = (String) list.get(i);
			System.out.println(str);
		}
	}

	@Test
	public void testGeneric1() {
		List<String> list = new ArrayList<String>();
		list.add("book");
		list.add("look");
		list.add("good");
		list.add("poop");
		// list.add(33.3);
		for (int i = 0; i < list.size(); i++) {
			String str = list.get(i);
			System.out.println(str);
		}
	}

	@Test
	public void testGeneric2() {
		Music music1 = new Music("大海", 4, "张雨声");
		Music music2 = new Music("南海姑娘", 5, "王菲");
		Music music3 = new Music("好久不见", 4, "陈奕迅");
		List<Music> list = new ArrayList<>();
		list.add(music1);
		list.add(music2);
		list.add(music3);
		for (Music m : list) {
			System.out.println(m);
		}
	}

	// 处理Book类对象
	@Test
	public void testGeneric3() {
		Book<Boolean> book = new Book<Boolean>("平凡的世界", "路遥", 150, "文学");
		book.setT(true);
		System.out.println(book);

		book.add();
		List<Boolean> list = book.list;
		System.out.println(list);
	}

	// 处理StoryBook类对象
	@Test
	public void testGeneric4() {

		StoryBook story = new StoryBook();
		List<Integer> list = story.list;
		System.out.println(list);
	}

	// 泛型和继承的关系
	@SuppressWarnings("unused")
	@Test
	public void testGeneric5() {
		Object obj = null;
		String str = "book";
		obj = str;
		System.out.println(obj);

		Object[] objs = null;
		String[] strs = { "book", "good", "look" };
		objs = strs;
		System.out.println(objs);
		// 若A是B的子类，则List<A>不是List<B>的子类或者子接口。
		List<Object> listObj = null;
		List<String> listStr = new ArrayList<>();
		// listObj=listStr; 不能这样赋值

	}

	// 通配符 List<Object>、List<String>.....都是List<?>的子类
	// ? extends A:可以存放A及其子类
	// ? super A:可以存放A及其父类
	@Test
	public void testGeneric6() {
		List<?> list = null;
		List<Object> listObj = new ArrayList<>();
		list = listObj;

		List<String> listStr = new ArrayList<>();
		list = listStr;
		System.out.println(list);

		// ? extends A:可以存放A及其子类
		List<? extends Number> listNumber = null;
		List<Integer> listInteger = new ArrayList<>();
		listNumber = listInteger;
		// listNumber=listObj;
		System.out.println(listNumber);

		// ? super A:可以存放A及其父类
		List<? super Number> listNumber1 = null;
		listNumber1 = listObj;
		System.out.println(listNumber1);
	}
}
