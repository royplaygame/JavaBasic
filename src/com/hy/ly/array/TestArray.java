package com.hy.ly.array;

import java.util.Arrays;

import org.junit.Test;

public class TestArray {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		//byte short int long 默认值0
		int []nums=new int[3];
		//double float 默认值0.0
		double []scores=new double[3];
		//char默认值空格或空白
		char []ch=new char[3];
		//boolean默认值false
		boolean []bl=new boolean[3];
		
		for(int i=0;i<3;i++){
			System.out.println(bl[i]);
		}
		
		int []num;
		num=new int[9];
		
		int []num2={1,32,2,4,};
		int []num3=new int[]{22,33,14,25,65};
		
		Arrays.sort(num3);
		for(int i:num3){
			System.out.print(i+" ");
		}
		System.out.println();
		String str=Arrays.toString(num3);
		System.out.println(str);
		
		int []newNum=Arrays.copyOf(num3, num3.length-2);
		for(int i:newNum){
			System.out.print(i+" ");
		}
		System.out.println();
		
		int find=Arrays.binarySearch(num3, 25);
		int find1=Arrays.binarySearch(num3, 28);
		System.out.println(find);
		System.out.println(find1);
	}
	
	@Test
	public void testArrays(){
		String[] stringArray = new String[3]; // 各元素的值默认为null
		for (int i = 0; i < stringArray.length; i++) { // 对各元素进行初始化，但没有赋值。
			stringArray[i] = new String();
			System.out.println(stringArray[i]);
		}
	}
	
	@Test
	public void testArray(){
		String foo="blue"; 
		boolean[] bar=new boolean[2]; 
		if(bar[0]){   
      			foo="green"; 
   		} 
		System.out.println(foo);
	}
}
