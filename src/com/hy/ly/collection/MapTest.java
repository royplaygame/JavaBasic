package com.hy.ly.collection;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.TreeMap;

import org.junit.Test;

import com.hy.ly.po.Teacher;

public class MapTest {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		Map map = new HashMap();
		map.put("name", "平凡的世界");
		map.put("price", "100");
		map.put("publish", "清华大学出版社");
		// 要求重写类对象的equals方法，通过equals来判断两个对象是否相同，如果相同只能添加后添加的那个对象（后添加的会覆盖先添加的）
		map.put(new Teacher("王老师", 22), 100);
		map.put(new Teacher("王老师", 22), 110);

		map.clear();
		System.out.println(map);
		System.out.println();

		Set set = map.keySet();
		Iterator it = set.iterator();
		while (it.hasNext()) {
			System.out.print(it.next());
		}

		Collection values = map.values();
		Iterator it1 = values.iterator();
		while (it1.hasNext()) {
			System.out.print(it1.next());
		}

		Map<String, String> map1 = new HashMap<>();
		map1.put("name", "平凡的世界");
		map1.put("price", "100");
		map1.put("publish", "清华大学出版社");
		for (Map.Entry<String, String> entry : map1.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testFunction() {
		Map map = new HashMap();
		map.put("name", "平凡的世界");
		map.put("price", "100");
		map.put("publish", "清华大学出版社");
		map.put(new Teacher("王老师", 22), 100);

		// 遍历key集合
		Set set = map.keySet();
		for (Object obj : set) {
			System.out.println(obj);
		}
		System.out.println();
		// 遍历values集合
		Collection values = map.values();
		Iterator it = values.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		System.out.println();
		// 遍历key value对,方式一：
		Set set1 = map.keySet();
		for (Object obj : set1) {
			System.out.println(obj + " " + map.get(obj));
		}
		System.out.println();
		// 遍历key value对,方式二：
		Set set2 = map.entrySet();
		for (Object obj : set2) {
			Map.Entry entry = (Map.Entry) obj;
			// System.out.println(entry.getKey()+" "+entry.getValue());
			System.out.println(entry);

		}
	}

	// LinkedHashMap维护了一个添加时的顺序，遍历时可以按添加顺序遍历
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testLinkedHashMap() {
		Map map = new LinkedHashMap();
		map.put("name", "平凡的世界");
		map.put("price", "100");
		map.put("publish", "清华大学出版社");
		map.put(new Teacher("王老师", 22), 100);

		// 遍历key value对
		Set set1 = map.keySet();
		for (Object obj : set1) {
			System.out.println(obj + " " + map.get(obj));
		}
	}

	// TreeMap 按照添加进Map中的元素的key的指定属性进行排序，要求key必须是同一个类的对象。
	// 针对key来说有两种排序方式：1. 自然排序 2. 定制排序
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testTreeMap() {
		// 自然排序
		Map map = new TreeMap();
		map.put(new Teacher("AA", 22), 100);
		map.put(new Teacher("DD", 23), 66);
		map.put(new Teacher("EE", 26), 77);
		map.put(new Teacher("BB", 23), 88);
		map.put(new Teacher("CC", 28), 99);

		// 遍历key value对
		Set set1 = map.keySet();
		for (Object obj : set1) {
			System.out.println(obj + " " + map.get(obj));
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testTreeMap2() {
		// 定制排序
		Comparator comp = new Comparator() {
			// 在向TreeSet中添加的Student类对象时，在compare方法中指明是按Student中的哪个属性排序的。
			@Override
			public int compare(Object o1, Object o2) {
				if (o1 instanceof Teacher && o2 instanceof Teacher) {
					Teacher stu1 = (Teacher) o1;
					Teacher stu2 = (Teacher) o2;
					int name = stu1.getName().compareTo(stu2.getName());
					if (name == 0) {
						return stu1.getAge() - stu2.getAge();
					} else {
						return name;
					}
				}
				return 0;
			}
		};
		Map map = new TreeMap(comp);
		map.put(new Teacher("CC", 22), 100);
		map.put(new Teacher("DD", 23), 66);
		map.put(new Teacher("BB", 26), 77);
		map.put(new Teacher("BB", 23), 88);
		map.put(new Teacher("CC", 28), 99);

		// 遍历key value对
		Set set1 = map.keySet();
		for (Object obj : set1) {
			System.out.println(obj + " " + map.get(obj));
		}
	}

	// Properties键和值都是String类型的
	@Test
	public void testProperties() {
		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream(new File("jdbc.properties")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(properties.get("url"));
		System.out.println(properties.get("password"));
		System.out.println(properties.get("user"));
		System.out.println(properties.get("driver"));
	}
	// Properties键和值都是String类型的
	@Test
	public void testProperties2() {
		Properties properties = new Properties();
		try {
			properties.load(MapTest.class.getClassLoader().getResourceAsStream("jdbc.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(properties.get("url"));
		System.out.println(properties.get("password"));
		System.out.println(properties.get("user"));
		System.out.println(properties.get("driver"));
	}
}
