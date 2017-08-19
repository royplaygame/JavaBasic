package com.hy.ly.collection;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

import com.hy.ly.po.Music;
import com.hy.ly.po.Student;
import com.hy.ly.po.Teacher;

public class SetTest {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		// 无序性指的是元素在底层存储的位置是无序的，不可重复的
		Set set = new HashSet();
		set.add("good");
		set.add("book");
		set.add("book");
		set.add("look");
		set.add("123");
		set.add("456");
		set.add("789");
		System.out.println(set);
		Iterator it = set.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}

		Set set1 = new LinkedHashSet();
		Set set2 = new TreeSet();

		set1.add("this is");
		set1.add("ok");
		set2.add("haha");
		set2.add("lolo");
		Iterator it1 = set1.iterator();
		Iterator it2 = set2.iterator();
		while (it1.hasNext()) {
			System.out.println(it1.next());
		}
		while (it2.hasNext()) {
			System.out.println(it2.next());
		}
	}

	@Test
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void testSet() {
		// 要求添加到set的类，一定要重写equals()和hashCode()的方法
		Set set = new HashSet();
		set.add("good");
		set.add("book");
		set.add(new String("myBook"));
		set.add(new String("yourBook"));
		set.add(new String("myBook"));
		set.add("book");
		set.add(new Teacher("王老师", 22));
		set.add(new Teacher("李老师", 28));
		set.add(new Teacher("李老师", 28));

		System.out.println(set);
	}

	@Test

	public void testHashCode() {
		Teacher t1 = new Teacher("王老师", 22);
		Teacher t2 = new Teacher("李老师", 23);
		Teacher t3 = new Teacher("赵老师", 24);
		Teacher t4 = new Teacher("张老师", 25);
		Teacher t5 = new Teacher("张老师", 25);
		System.out.println(t1.hashCode());
		System.out.println(t2.hashCode());
		System.out.println(t3.hashCode());
		System.out.println(t4.hashCode());
		System.out.println(t5.hashCode());
	}

	/**
	 * LinkedHashSet插入时性能略低于HashSet,要维护链表，遍历时set集合时有较好的性能
	 */
	@Test
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void testLinkedHashCode() {
		// LinkedHashSet维护了一个添加时的顺序，遍历时可以按添加顺序遍历
		Set set = new LinkedHashSet();
		set.add("good");
		set.add("book");
		set.add(new String("myBook"));
		set.add(new String("yourBook"));
		set.add(new String("myBook"));
		set.add("book");
		set.add(new Teacher("王老师", 22));
		set.add(new Teacher("李老师", 28));
		set.add(new Teacher("李老师", 28));

		Iterator iterator = set.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		System.out.println(set);
	}

	@Test
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void testTreeSet() {
		// 1. TreeSet要求添加的类型是相同的, 2.按照添加到集合中的指定的顺序遍历，像String等包装类按照从小到大的顺序遍历。
		// 2. 对于自定义的类
		// 3. 对于TreeSet 首先按照compareTo来比较，如果返回0，虽然只是这个对象的此属性值相同，但程序会认为这两个对象相同
		// 进而不会添加后一个对象。
		// 4. 要求compareTo()、hashCode()以及equals()三个方法要一致。
		Set set = new TreeSet();
		/*
		 * set.add("good"); set.add("book"); set.add(new String("myBook2"));
		 * set.add(new String("yourBook")); set.add(new String("myBook1"));
		 * set.add("book");
		 */

		// 当Teacher没有实现Comparable接口，当向TreeSet中添加Teacher的对象时报java.lang.ClassCastException:
		/*
		 * 当向TreeSet中添加Teacher类的对象时,依据此方法，来确定按照属性排列 :1.自然的排序 2.制定排序
		 * 1.自然的排序，要求类实现java.lang包下的Comparable抽象方法，病重写compareTo(Object
		 * o)方法，在方法写明按照哪个属性排序。
		 * 
		 * 
		 * @Override public int compareTo(Object o) { if(o instanceof Teacher){
		 * Teacher t=(Teacher)o; return this.age.compareTo(t.age); } return 0; }
		 */

		set.add(new Teacher("王老师", 22));
		set.add(new Teacher("李老师", 28));
		set.add(new Teacher("刘老师", 29));
		set.add(new Teacher("张老师", 29));
		set.add(new Teacher("田老师", 26));
		set.add(new Teacher("赵老师", 30));

		// 遍历
		for (Object obj : set) {
			System.out.println(obj);
		}
	}

	// 1. TreeSet定制排序，注意：自然排序用的是comparable,定制排序用的是：comparator
	// 2. 要求compareTo()、hashCode()以及equals()三个方法要一致。
	@Test
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void testTreeSet2() {
		// 1. 创建一个实现了comparater接口的类对象
		Comparator comp = new Comparator() {
			// 在向TreeSet中添加的Student类对象时，在compare方法中指明是按Student中的哪个属性排序的。
			@Override
			public int compare(Object o1, Object o2) {
				if (o1 instanceof Student && o2 instanceof Student) {
					Student stu1 = (Student) o1;
					Student stu2 = (Student) o2;
					int id = stu1.getId().compareTo(stu2.getId());
					if (id == 0) {
						int name = stu1.getName().compareTo(stu2.getName());
						if (name == 0) {
							int sex = stu1.getSex().compareTo(stu2.getSex());
							if (sex == 0) {
								int mobile = stu1.getPhone().compareTo(stu2.getPhone());
								if (mobile == 0) {
									return 0;
								} else {
									return mobile;
								}
							} else {
								return sex;
							}
						} else {
							return name;
						}
					} else {
						return id;
					}
				}
				return 0;
			}
		};
		// 2. 将此对象做为形参传入到TreeSet的构造器中。
		Set set = new TreeSet(comp);
		// 3. 向TreeSet中添加在Comparator中涉及的类的对象
		set.add(new Student(101, "王同学", "男", "13588880001"));
		set.add(new Student(102, "李同学", "女", "13588880002"));
		set.add(new Student(103, "刘同学", "女", "13588880003"));
		set.add(new Student(104, "张同学", "男", "13588880004"));
		set.add(new Student(105, "田同学", "女", "13588880005"));
		set.add(new Student(106, "赵同学", "男", "13588880006"));
		set.add(new Student(106, "梅同学", "女", "13588880007"));
		set.add(new Student(106, "梅同学", "女", "13588880007"));

		// 遍历
		for (Object obj : set) {
			System.out.println(obj);
		}
	}

	@Test
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void testTreeSet3() {

		Set set = new TreeSet(new Comparator() {
			public int compare(Object o1, Object o2) {
				if (o1 instanceof Student && o2 instanceof Student) {
					Student stu1 = (Student) o1;
					Student stu2 = (Student) o2;
					int id = stu1.getId().compareTo(stu2.getId());
					if (id == 0) {
						int name = stu1.getName().compareTo(stu2.getName());
						if (name == 0) {
							int sex = stu1.getSex().compareTo(stu2.getSex());
							if (sex == 0) {
								int mobile = stu1.getPhone().compareTo(stu2.getPhone());
								if (mobile == 0) {
									return 0;
								} else {
									return mobile;
								}
							} else {
								return sex;
							}
						} else {
							return name;
						}
					} else {
						return id;
					}
				}
				return 0;
			}
		});
		set.add(new Student(101, "王同学", "男", "13588880001"));
		set.add(new Student(102, "李同学", "女", "13588880002"));
		set.add(new Student(103, "刘同学", "女", "13588880003"));
		set.add(new Student(104, "张同学", "男", "13588880004"));
		set.add(new Student(105, "田同学", "女", "13588880005"));
		set.add(new Student(106, "赵同学", "男", "13588880006"));
		set.add(new Student(106, "梅同学", "女", "13588880007"));
		set.add(new Student(106, "梅同学", "女", "13588880007"));

		for (Object obj : set) {
			System.out.println(obj);
		}
	}

	@Test
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void testHashSet() {
		HashSet set = new HashSet();
		set.add(null);
		set.add("book");
		set.add("look");
		set.add("good");
		set.add("good");
		set.add("Hello");
		// 迭代器
		Iterator it = set.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		// 存储对象
		Music m1 = new Music("好久不见",4,"陈奕迅");
		Music m2 = new Music("水手",4,"郑智化");
		Music m3 = new Music("大海",4,"张雨生");
		Music m4 = new Music("大海",4,"张雨生");
		HashSet hSet = new HashSet();
		hSet.add(m1);
		hSet.add(m2);
		hSet.add(m3);
		hSet.add(m4);
		System.out.println(m3.hashCode()+"==="+m4.hashCode());
		System.out.println(m3.equals(m4));
		Iterator it2=hSet.iterator();
		while(it2.hasNext()){
			System.out.println(it2.next());
		}
		
		//比较两个对象大小
		Music obj1 = new Music("大海",4,"张雨生");
		Music obj2 = new Music("大海",4,"张雨生");
		Music obj3 = new Music("水手",4,"郑智化");
		System.out.println(obj1.compareTo(obj2));
		System.out.println(obj1.compareTo(obj3));
		System.out.println("大海".compareTo("水手"));
	}
}
