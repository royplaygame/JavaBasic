package com.hy.ly.inface;

public class Umouse implements USB{

	@Override
	public void service() {
		System.out.println("USB鼠标已连接，鼠标可以使用了，真开心！");
	}

}
