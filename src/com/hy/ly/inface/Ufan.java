package com.hy.ly.inface;

public class Ufan implements USB{

	@Override
	public void service() {
		System.out.println("风扇已连接，开始运转了.......真凉快！");
	}

}
