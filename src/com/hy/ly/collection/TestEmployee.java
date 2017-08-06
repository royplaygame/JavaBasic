package com.hy.ly.collection;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

import org.junit.Test;

import com.hy.ly.po.Employee;
import com.hy.ly.po.Employee2;
import com.hy.ly.po.MyDate;

/**
 * 创建该类的 5 个对象，并把这些对象放入 TreeSet 集合中（下一章：TreeSet 需使用泛型来定义）
 * 分别按以下两种方式对集合中的元素进行排序，并遍历输出：
 * 
 * 1). 使Employee 实现 Comparable 接口，并按 name 排序 2). 创建
 * TreeSet时传入Comparator对象，按生日日期的先后排序。
 * 
 * 
 * 
 * @author ssr
 *
 */
public class TestEmployee {

	// 自然排序,使Employee 实现 Comparable 接口，并按 name 排序
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testEmp() {
		Employee emp1 = new Employee("刘备", 26, new MyDate(2017, 10, 10));
		Employee emp2 = new Employee("张飞", 24, new MyDate(2015, 10, 10));
		Employee emp3 = new Employee("关羽", 25, new MyDate(2016, 10, 10));
		Employee emp4 = new Employee("曹操", 26, new MyDate(2017, 10, 11));
		Employee emp5 = new Employee("孙权", 18, new MyDate(2009, 10, 10));
		// Employee emp6 = new Employee("孙权", 16, new MyDate(2008, 11, 10));

		TreeSet ts = new TreeSet();
		ts.add(emp1);
		ts.add(emp2);
		ts.add(emp3);
		ts.add(emp4);
		ts.add(emp5);
		// ts.add(emp6);

		Iterator it = ts.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

	// 定制排序，创建 TreeSet时传入Comparator对象，按生日日期的先后排序。
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testEmp2() {

		Comparator cmp = new Comparator() {
			@Override
			public int compare(Object o1, Object o2) {
				if (o1 instanceof Employee2 && o2 instanceof Employee2) {
					Employee2 emp1 = (Employee2) o1;
					Employee2 emp2 = (Employee2) o2;

					MyDate birth1 = emp1.getBirthday();
					MyDate birth2 = emp2.getBirthday();
					if (birth1.getYear() != birth2.getYear()) {
						return birth1.getYear() - birth2.getYear();
					} else if (birth1.getMonth() != birth2.getMonth()) {
						return birth1.getMonth() - birth2.getMonth();
					} else {
						return birth1.getDay() - birth2.getDay();
					}
				}
				return 0;
			}
		};

		Employee2 emp1 = new Employee2("刘备", 26, new MyDate(2017, 10, 10));
		Employee2 emp2 = new Employee2("张飞", 24, new MyDate(2015, 10, 10));
		Employee2 emp3 = new Employee2("关羽", 25, new MyDate(2016, 10, 10));
		Employee2 emp4 = new Employee2("曹操", 26, new MyDate(2017, 10, 11));
		Employee2 emp5 = new Employee2("孙权", 18, new MyDate(2009, 10, 10));
		Employee2 emp6 = new Employee2("董卓", 16, new MyDate(2017, 11, 10));

		TreeSet ts = new TreeSet(cmp);
		ts.add(emp1);
		ts.add(emp2);
		ts.add(emp3);
		ts.add(emp4);
		ts.add(emp5);
		ts.add(emp6);

		Iterator it = ts.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
