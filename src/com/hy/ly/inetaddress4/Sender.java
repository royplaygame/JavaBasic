package com.hy.ly.inetaddress4;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Sender {

	public static void main(String[] args) {
		DatagramSocket ds = null;
		try {
			ds = new DatagramSocket();
			byte []b="这是我要发送的数据，请服务器端接收！".getBytes();
			DatagramPacket dp=new DatagramPacket(b,b.length,InetAddress.getByName("localhost"),9090);
			ds.send(dp);
			
			byte[] buf=new byte[1024];		
			DatagramPacket dpre=new DatagramPacket(buf,buf.length);
			//创建DatagramSocket对象，接收数据
			//ds=new DatagramSocket(8800);
			ds.receive(dpre);
			//显示接收到的信息
			String reply=new String(dpre.getData(),0,dpre.getLength());
			System.out.println(dpre.getAddress().getHostAddress()+"说："+reply);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			ds.close();
		}
	}
}
