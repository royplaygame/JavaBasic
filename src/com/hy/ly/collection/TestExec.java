package com.hy.ly.collection;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class TestExec {

	public static void main(String[] args) {
		String[] strs = { "a", "b", "a", "b", "c", "a", "b", "c", "b" };
		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < strs.length; i++) {
			if (map.containsKey(strs[i])) {
				map.put(strs[i], map.get(strs[i]) + 1);
			} else {
				map.put(strs[i], 1);
			}
		}
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey() + "元素出现的次数是：" + entry.getValue());
		}
	}

	@Test
	public void testHashCode() {
		int hashCode = Float.floatToIntBits(1000.35f);
		long hashCode2 = Double.doubleToLongBits(59.678);
		boolean f = false;
		int hashCode3 = (f ? 0 : 1);
		long l = 1000;
		int hashCode4 = (int) (l ^ (l >>> 32));
		System.out.println(hashCode);
		System.out.println(hashCode2);
		System.out.println(hashCode3);
		System.out.println(hashCode4);

		//List<String> list = new ArrayList<>();
		//List<String> list2 = Collections.synchronizedList(list);
		
		//Properties p=new Properties();
		
	}
}
