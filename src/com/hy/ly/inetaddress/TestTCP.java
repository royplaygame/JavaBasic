package com.hy.ly.inetaddress;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import org.junit.Test;

//客户端给服务端发送信息，服务端输出此信息到控制台
public class TestTCP {

	// 客户端
	@Test
	public void client() {
		Socket socket = null;
		OutputStream out = null;
		try {
			socket = new Socket(InetAddress.getByName("localhost"), 9090);
			out = socket.getOutputStream();
			out.write("我是客户端！请多关注！".getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	// 服务端
	@Test
	public void server() {
		ServerSocket ss = null;
		Socket s = null;
		InputStream in = null;
		try {
			ss = new ServerSocket(9090);
			s = ss.accept();
			in = s.getInputStream();
			byte[] b = new byte[100];
			int len;
			while ((len = in.read(b)) != -1) {
				String str = new String(b, 0, len);
				System.out.print(str);
			}
			System.out.println("\n收到来自于"+s.getInetAddress().getHostAddress()+"的信息！");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (in != null) {
				try {
					s.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (in != null) {
				try {
					ss.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
}
