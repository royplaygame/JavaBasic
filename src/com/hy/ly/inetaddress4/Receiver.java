package com.hy.ly.inetaddress4;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketAddress;

public class Receiver {

	public static void main(String[] args) {
		DatagramSocket ds = null;
		DatagramPacket dpto=null;
		try {
			ds=new DatagramSocket(9090);
			byte []b=new byte[1024];
			DatagramPacket dp=new DatagramPacket(b,b.length);
			ds.receive(dp);
			//输出数据
			String str=new String(dp.getData(),0,dp.getLength());
			System.out.println(str);
			
			String reply="你好，我在，请咨询！";	
			//显示与本地对话框
			System.out.println("我  说："+reply);			
						
			//创建DatagramPacket对象，封装数据
			SocketAddress sa=dp.getSocketAddress();
			dpto=new DatagramPacket(reply.getBytes(),reply.getBytes().length ,sa);
			ds.send(dpto);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			ds.close();
		}
	}
}
