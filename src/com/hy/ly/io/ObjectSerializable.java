package com.hy.ly.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.Test;

public class ObjectSerializable {

	// 对象的反序列化，是通过ObjectInputStream把磁盘中的文件以对象形式读取到程序中。
	@Test
	public void testSerializable() throws Exception {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("cat.txt"));
		Cat tom = (Cat) ois.readObject();
		System.out.println(tom);

		Cat cat = (Cat) ois.readObject();
		System.out.println(cat);

		Cat cat1 = (Cat) ois.readObject();
		System.out.println(cat1);
		ois.close();
	}

	// 对象的序列化，是把对象文通过ObjectOutputStream写入到磁盘文件中
	@Test
	public void testSerializable2() {
		Cat tom = new Cat("汤姆猫", "波斯猫", "汤姆克鲁斯");
		Cat cat = new Cat("流浪猫", "无名品种", "流浪汉");
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream("cat.txt"));
			oos.writeObject(tom);
			oos.flush();
			oos.writeObject(cat);
			oos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
