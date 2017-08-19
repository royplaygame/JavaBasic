package com.hy.ly.io;

public class Cat {

	private String name;
	private String type;
	private String master;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMaster() {
		return master;
	}
	public void setMaster(String master) {
		this.master = master;
	}
	public Cat(String name, String type, String master) {
		super();
		this.name = name;
		this.type = type;
		this.master = master;
	}
	public Cat() {
		super();
	}
	
}
