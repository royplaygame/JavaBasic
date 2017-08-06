package com.hy.ly.collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapTest {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		Map map=new HashMap();
		map.put("name", "平凡的世界");
		map.put("price", "100");
		map.put("publish", "清华大学出版社");
		
		Set set=map.keySet();
		Iterator it=set.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
		Collection values=map.values();
		Iterator it1=values.iterator();
		while(it1.hasNext()){
			System.out.println(it1.next());
		}
		
		
		Map<String,String> map1=new HashMap<>();
		map1.put("name", "平凡的世界");
		map1.put("price", "100");
		map1.put("publish", "清华大学出版社");
		for(Map.Entry<String, String> entry:map1.entrySet()){
			System.out.println(entry.getKey()+" "+entry.getValue());
		}
	}
}
