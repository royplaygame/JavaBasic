package com.hy.ly.inetaddress;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import org.junit.Test;

/**
 * 客户端发送一个文件给服务端，服务端保存到本地，并返回“发送成功”给客户端，关闭相应的连接。
 * 
 * @author ssr
 *
 */
public class TestTCP3 {
	// 客户端
	@Test
	public void client() {
		Socket socket = null;
		OutputStream out = null;
		FileInputStream fis = null;
		InputStream in = null;
		try {
			socket = new Socket(InetAddress.getByName("localhost"), 9090);
			out = socket.getOutputStream();
			// 从本地把文件读取进来
			fis = new FileInputStream(new File("11.jpg"));
			byte[] b = new byte[1024];
			int len;
			while ((len = fis.read(b)) != -1) {
				out.write(b, 0, len);
			}
			// 告诉服务输出完毕
			socket.shutdownOutput();

			// 接收服务返回的消息,打印在控制台中
			in = socket.getInputStream();
			int len1;
			byte[] b1 = new byte[1024];
			while ((len1 = in.read(b1)) != -1) {
				String str = new String(b1, 0, len1);
				System.out.println(str);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
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
			if (in != null) {
				try {
					in.close();
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
		FileOutputStream fos = null;

		try {
			ss = new ServerSocket(9090);
			s = ss.accept();
			// 接收传过来的数据
			in = s.getInputStream();
			// 写入本地文件
			fos = new FileOutputStream(new File("n11.jpg"));
			byte[] b = new byte[1024];
			int len;
			while ((len = in.read(b)) != -1) {
				fos.write(b, 0, len);
			}

			// 向外发送收到信息的消息
			out = s.getOutputStream();
			out.write("你发送的图片，我已经接收成功！".getBytes());

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fos != null) {
				try {
					fos.close();
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
			if (in != null) {
				try {
					in.close();
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
