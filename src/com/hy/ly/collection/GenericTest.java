package com.hy.ly.collection;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class GenericTest {

	public <T> T get(T e) {
		return e;
	}

	public <T> List<T> fromArrayToList(T[] t, List<T> list) {
		for (int i = 0; i < t.length; i++) {
			list.add(t[i]);
		}
		return list;
	}

	@Test
	public void test1() {

		ThrefpoofDoor td = new ThrefpoofDoor();
		String str = td.get("Tom");
		System.out.println(str);

		ThrefpoofDoor2<String> td2 = new ThrefpoofDoor2<>();
		String str2 = td2.get("good");
		System.out.println(str2);

		ThrefpoofDoor2<Boolean> td3 = new ThrefpoofDoor2<>();
		boolean b = td3.get(true);
		System.out.println(b);

		ThrefpoofDoor2<Integer> td4 = new ThrefpoofDoor2<>();
		Integer i = td4.get(100);
		System.out.println(i);

		GenericTest gt = new GenericTest();
		String str1 = gt.get("oh myGood");
		System.out.println(str1);

		boolean bl = gt.get(true);
		System.out.println(bl);

		Integer nu = gt.get(100);
		System.out.println(nu);

		// 泛型方法
		Integer[] num = { 2, 3, 4, 5, 6, 7 };
		List<Integer> list=new ArrayList<>();
		list=gt.fromArrayToList(num, list);
		for(Integer k:list){
			System.out.println(k);
		}
		
		Double []db={23.3,45.5,56.6,87.9};
		List<Double> list1=new ArrayList<>();
		list1=gt.fromArrayToList(db, list1);
	}

}
