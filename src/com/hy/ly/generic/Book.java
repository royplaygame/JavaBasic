package com.hy.ly.generic;

import java.util.ArrayList;
import java.util.List;

public class Book<T> {

	private String name;
	private String author;
	private int pageNo;
	private String type;
	private T t;
	List<T> list = new ArrayList<>();

	public void add() {
		list.add(t);
	}

	public void setT(T t) {
		this.t = t;
	}

	public T getT() {
		return t;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Book() {
		super();
	}

	public Book(String name, String author, int pageNo, String type) {
		super();
		this.name = name;
		this.author = author;
		this.pageNo = pageNo;
		this.type = type;
	}

	@Override
	public String toString() {
		return "Book [name=" + name + ", author=" + author + ", pageNo=" + pageNo + ", type=" + type + ", t=" + t + "]";
	}

}

class StoryBook extends Book<Integer>{
	
}
