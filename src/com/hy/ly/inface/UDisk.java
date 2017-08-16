package com.hy.ly.inface;

public class UDisk implements USB{

	@Override
	public void service() {
		System.out.println("U盘已经连接，正在传输数据............");
		
	}

}
