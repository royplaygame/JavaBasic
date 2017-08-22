package com.hy.ly.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.Test;

/**
 * 操作集合的工具类：Collection(List、Set)、Map
 * 
 * @author ssr 区分Collection和Collections 
 * 1. Collection是接口，可以存储List、Set
 * 2. Collections是操作集合的一个工具类,可以操作Collection和Map
 * 3. 常用方法：
 *    reverse(List)：反转 List 中元素的顺序
 *    shuffle(List)：对 List 集合元素进行随机排序
 *    sort(List)：根据元素的自然顺序对指定 List 集合元素按升序排序    
 *    sort(List，Comparator)：根据指定的Comparator 产生的顺序对 List 集合元素进行排序
 *    swap(List，int， int)：将指定 list 集合中的 i处元素和 j 处元素进行交换     
 *        
 * 
 */
public class CollectionsTest {
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testCollections(){
		List list=new ArrayList();
		list.add(123);
		list.add(101);
		list.add(991);
		list.add(576);
		
		System.out.println(list);
		Collections.reverse(list);
		System.out.println(list);
		
		Collections.shuffle(list);
		System.out.println(list);
		
		Collections.sort(list);
		System.out.println(list);
		
		Collections.swap(list, 0, 3);
		System.out.println(list);
		
		//保证线程安全,返回list2的是线程安全的
		List list2=Collections.synchronizedList(list);
		System.out.println(list2);
	}
	
	/**
	 * Object max(Collection)：根据元素的自然顺序，返回给定集合中的最大元素
     * Object max(Collection，Comparator)：根据 Comparator 指定的顺序，返回给定集合中的最大元素
     * Object min(Collection)
     * Object min(Collection，Comparator)
     * int frequency(Collection，Object)：返回指定集合中指定元素的出现次数
     * void copy(List dest,List src)：将src中的内容复制到dest中
     * boolean replaceAll(List list，Object oldVal，Object newVal)：使用新值替换 List 对象的所有旧值
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testCollctions2(){
		List list=new ArrayList();
		list.add(123);
		list.add(101);
		list.add(991);
		list.add(576);
		list.add(991);
		list.add(576);
		list.add(576);
		
		int max=Collections.max(list);
		System.out.println(max);
		
		int count=Collections.frequency(list,576);
		System.out.println(count);
		
		//List list1=new ArrayList(); //错误的实现方式
		//List list2=Arrays.asList(0,0,0,0,0,0,0); //可以但不通用
		List list2=Arrays.asList(new Object[list.size()]);
		Collections.copy(list2, list);
		System.out.println(list2);
		
		Collections.replaceAll(list, 576, 888);
		System.out.println(list);
	}
	
	@Test
	public void testCollection(){
		List<Integer> list=new ArrayList<>();
		list.add(123);
		list.add(101);
		list.add(991);
		list.add(576);
		list.add(991);
		list.add(586);
		list.add(576);
		System.out.println(list);
		Collections.sort(list);
		System.out.println(list);
		int index=Collections.binarySearch(list, 991);
		System.out.println(index);
		/*Collections.fill(list, 100);
		System.out.println(list);
		List<Integer> list1=Arrays.asList(new Integer[list.size()]);
		Collections.copy(list1, list);
		System.out.println(list1);*/
		
	}

	@Test
	public void testCollection5(){
		List<Integer> list=new ArrayList<>();
		list.add(123);
		list.add(101);
		list.add(991);
		list.add(576);
		list.add(991);
		list.add(586);
		list.add(576);
		System.out.println(list);
		Collections.addAll(list, 1000,300,500);
		System.out.println(list);
		Collections.addAll(list, new Integer[]{100,200,300});
		System.out.println(list);
		/*ArrayDeque<Integer> deque=new ArrayDeque<>();
		deque.add(666);
		deque.add(777);
		deque.push(300);
		deque.pop();
		Queue<Integer> queue=Collections.asLifoQueue(deque);
		System.out.println(queue);*/
		List<String> list2=Collections.emptyList();
		System.out.println(list2);
		
		System.out.println(Collections.emptyMap());
		System.out.println(Collections.emptySet());
		
		//Collections.fill(list, 0);
		System.out.println(list);
		int count=Collections.frequency(list, 0);
		System.out.println(count);
		
		System.out.println(list.toString());
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<list.size();i++){
			sb.append(list.get(i));
		}
		System.out.println(sb.toString());
	}
	
	@Test
	public void testStringBuilder(){
		String str="1234567894390";
		StringBuilder sb=new StringBuilder(str);
		for(int i=sb.length()-3;i>0;i-=3){
			sb.insert(i, ",");
		}
		System.out.println(sb.toString());
	}
}
