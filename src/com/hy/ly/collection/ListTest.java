package com.hy.ly.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

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
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void ArrayListOperation(){
		ArrayList list=new ArrayList();
		list.add("kafei");
		list.add("book");
		list.add("apple");
		list.add("orange");
		list.add(3, "平凡的世界");
		System.out.println(list.toString());
		System.out.println(list.get(2));
		System.out.println(list.indexOf("平凡的世界"));
		list.set(1, "monkey");
		System.out.println(list.toString());
		Object obj=list.remove(1);
		System.out.println(list.toString());
		System.out.println(obj);
		System.out.println(list.isEmpty());
		System.out.println(list.contains("apple"));
		
	}
	//SuppressWarnings压制警告，即去除警告 
	//rawtypes是说传参时也要传递带泛型的参数
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void LinkedListOperation(){
		LinkedList list=new LinkedList();
		list.add("kafei");
		list.add("book");
		list.add("apple");
		list.add("orange");
		list.add(3, "平凡的世界");
		list.addFirst("First");
		list.addLast("Last");
		System.out.println(list.toString());
		System.out.println(list.getFirst());
		System.out.println(list.getLast());
		list.removeLast();
		System.out.println(list.toString());
		list.removeFirst();
		System.out.println(list.toString());
		System.out.println(list.contains("book"));
		list.clear();
		System.out.println(list.toString());
		list.offerLast("thisLast");
		list.offerFirst("thisFirst");
		System.out.println(list.toString());
		String peek=(String) list.peek();
		System.out.println(peek);
		
		//pop push
		System.out.println("===================================");
		LinkedList list2=new LinkedList();
		list2.add("kafei");
		list2.add("book");
		list2.add("apple");
		list2.add("orange");
		list2.add(3, "平凡的世界");
		list2.addFirst("First");
		list2.addLast("Last");
		System.out.println(list2.toString());
		list2.push("push1");
		list2.push("push2");
		System.out.println(list2.toString());
		list2.pop();
		System.out.println(list2.toString());
		//set
		list2.set(6, "Modifyto6");
		System.out.println(list2.toString());
		
		//list size
		System.out.println(list2.size());
		System.out.println(list2.toString());
		list2.add(null);
		list2.add(null);
		System.out.println(list2.size());
		System.out.println(list2.toString());
		
		
		
		
	}
}
