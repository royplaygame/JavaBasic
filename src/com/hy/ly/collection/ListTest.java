package com.hy.ly.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ListTest {

	public static void main(String[] args) {
		List list=new ArrayList();
		list.add("this");
		list.add(10);
		list.add('d');
		
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
		
		for(Iterator<Object> it=list.iterator();it.hasNext();){
			System.out.println(it.next());
		}
		
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
