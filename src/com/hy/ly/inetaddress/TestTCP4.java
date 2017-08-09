package com.hy.ly.inetaddress;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import org.junit.Test;

/**
 * 客户端给服务端发送文本，服务端把文本转成大写后返回给客户端
 * 
 * @author ssr
 *
 */
public class TestTCP4 {
	// 客户端
	@Test
	public void client() {
		Socket socket = null;
		OutputStream out = null;
		InputStream in = null;
		try {
			socket = new Socket(InetAddress.getByName("127.0.0.1"), 9898);
			out = socket.getOutputStream();
			out.write("I am s student, I will study hard and make progress every day!".getBytes());
			// 告诉服务发送完毕
			socket.shutdownOutput();

			// 接收服务器的返回
			in = socket.getInputStream();
			byte[] b = new byte[1024];
			int len;
			while ((len = in.read(b)) != -1) {
				String str = new String(b, 0, len);
				System.out.println(str);
			}

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
		OutputStream out = null;
		try {
			ss = new ServerSocket(9898);
			s = ss.accept();
			in = s.getInputStream();
			out = s.getOutputStream();
			// 读取客户端发来的数据
			byte[] b = new byte[1024];
			int len;
			while ((len = in.read(b)) != -1) {
				String str = new String(b, 0, len);
				System.out.println(str);
				// 转化成大写后发送回客户端
				out.write(str.toUpperCase().getBytes());
			}

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
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (s != null) {
				try {
					s.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (ss != null) {
				try {
					ss.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
