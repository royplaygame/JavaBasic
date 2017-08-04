package com.hy.ly.collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetTest {

	public static void main(String[] args) {
		Set set = new HashSet();
		set.add("good");
		set.add("book");
		set.add("book");
		set.add("look");
		Iterator it=set.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
		Set set1=new LinkedHashSet();
		Set set2=new TreeSet();
		
		set1.add("this is");
		set1.add("ok");
		set2.add("haha");
		set2.add("lolo");
		Iterator it1=set1.iterator();
		Iterator it2=set2.iterator();
		while(it1.hasNext()){
			System.out.println(it1.next());
		}
		while(it2.hasNext()){
			System.out.println(it2.next());
		}
	}
}
