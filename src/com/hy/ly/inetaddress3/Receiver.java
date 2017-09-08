package com.hy.ly.inetaddress3;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Receiver {

	public static void main(String[] args) {
		DatagramSocket ds = null;
		try {
			ds=new DatagramSocket(9090);
			byte []b=new byte[1024];
			DatagramPacket dp=new DatagramPacket(b,0,b.length);
			ds.receive(dp);
			//输出数据
			String str=new String(dp.getData(),0,dp.getLength());
			System.out.println(str);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			ds.close();
		}
	}
}
