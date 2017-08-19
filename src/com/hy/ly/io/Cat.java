package com.hy.ly.io;

import java.io.Serializable;

public class Cat implements Serializable {

	private static final long serialVersionUID = -7901232632751694369L;
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

	@Override
	public String toString() {
		return "Cat [name=" + name + ", type=" + type + ", master=" + master + "]";
	}

}
