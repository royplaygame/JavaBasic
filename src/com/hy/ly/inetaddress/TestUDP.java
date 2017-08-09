package com.hy.ly.inetaddress;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import org.junit.Test;

public class TestUDP {

	// 发送端
	@Test
	public void send() {
		DatagramSocket ds = null;
		try {
			ds = new DatagramSocket();
			byte[] b = "我要发送数据！快来接收！".getBytes();
			// 创建一个数据报,每个数据不能大于64K,发送端ip，端口号，以及接收端的IP、端口号
			DatagramPacket packet = new DatagramPacket(b, 0, b.length, InetAddress.getByName("localhost"), 9090);
			// 发送数据
			ds.send(packet);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (ds != null) {
				ds.close();
			}
		}

	}

	// 接收端
	@Test
	public void recive() {
		DatagramSocket ds = null;
		try {
			ds = new DatagramSocket(9090);
			byte[] b = new byte[1024];
			DatagramPacket packet = new DatagramPacket(b, 0, b.length);
			ds.receive(packet);

			// 输出到控制台
			String str = new String(packet.getData(), 0, packet.getLength());
			System.out.println(str);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (ds != null) {
				ds.close();
			}
		}
	}
}
