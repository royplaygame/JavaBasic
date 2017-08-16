package com.hy.ly.inface;

public class TestUSB {

	public static void main(String[] args) {
		USB u=new UDisk();
		u.service();
		
		USB uf=new Ufan();
		uf.service();
		
		USB um=new Umouse();
		um.service();
		
	}
}
