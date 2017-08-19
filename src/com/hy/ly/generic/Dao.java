package com.hy.ly.generic;

import java.util.List;

public class Dao<T> {

	public void add(T t) {
		System.out.println("add Operation");
	}

	public void update(T t) {
		System.out.println("update Operation");
	}

	public void delete(T t) {
		System.out.println("delete Operation");
	}

	public T get() {
		System.out.println("return one Obj");
		return null;
	}

	public List<T> getList() {
		System.out.println("return list");
		return null;
	}
}
