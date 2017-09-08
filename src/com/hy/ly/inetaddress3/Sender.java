package com.hy.ly.inetaddress3;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Sender {

	public static void main(String[] args) {
		DatagramSocket ds = null;
		try {
			ds = new DatagramSocket();
			byte []b="这是我要发送的数据，请服务器端接收！".getBytes();
			DatagramPacket dp=new DatagramPacket(b,0,b.length,InetAddress.getByName("localhost"),9090);
			ds.send(dp);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			ds.close();
		}
	}
}
