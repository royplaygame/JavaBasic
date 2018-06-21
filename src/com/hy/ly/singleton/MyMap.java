package com.hy.ly.singleton;

import java.util.HashMap;
import java.util.Map;

/**
 * 数字0～100拼接成一个字符串，请打印出数字0，1，2，3，4，5，6，7，8，9在这个字符串中各自出现的次数。（10）
 * 
 * @author ssr
 *
 */
public class MyMap {

	public static void main(String[] args) {
		String str = "12393294238492341621";
		Map<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (map.containsKey(ch)) {
				map.put(ch, map.get(ch) + 1);
			} else {
				map.put(ch, 1);
			}
		}
		
		// 遍历map
		for(Map.Entry<Character, Integer> entry: map.entrySet()){
			System.out.println(entry.getKey()+" 出现了："+entry.getValue()+"次！");
		}

	}
}
