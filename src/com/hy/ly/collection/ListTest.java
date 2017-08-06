package com.hy.ly.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.hy.ly.po.Teacher;

public class ListTest {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		List list=new ArrayList();
		
		Collection col=Arrays.asList(2,3,5,6);
		list.add("this");
		list.add(10);
		list.add('d');
		list.addAll(col);
		
		Teacher te=new Teacher("王老师",25);
		list.add(te);
		boolean b=list.contains(new Teacher("王老师",25));
		System.out.println(b);
		//遍历集合
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
		//集合迭代器遍历
		for(Iterator<Object> it=list.iterator();it.hasNext();){
			System.out.println(it.next());
		}
		
		//集合转化成数组。
		Object []objs=list.toArray();
		for(int i=0;i<objs.length;i++){
			System.out.println(objs[i]);
		}
		//增强for循环
		for(Object obj:list){
			System.out.println(obj);
		}
		
		List linkedList=new LinkedList();
		linkedList.add("ddd");
		linkedList.add("eee");
		linkedList.add("fff");
		linkedList.add("yyy");
		
		for(int i=0;i<linkedList.size();i++){
			System.out.println(linkedList.get(i));
		}
		
	}
}
