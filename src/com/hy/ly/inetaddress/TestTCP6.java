package com.hy.ly.inetaddress;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import org.junit.Test;

/**
 * 客户端给服务端发送信息，服务端输出此信息到控制台,同时发送已经收到信息能客户端 解決中文乱码问题
 * 
 * @author ssr
 *
 */
public class TestTCP6 {

	// 客户端
	@Test
	public void client() {
		Socket socket = null;
		OutputStream out = null;
		InputStream in = null;
		BufferedReader br = null;
		BufferedWriter bw = null;
		try {
			socket = new Socket(InetAddress.getByName("localhost"), 9090);
			out = socket.getOutputStream();
			bw = new BufferedWriter(new OutputStreamWriter(out, "utf-8"));
			bw.write("我是客户端！请多关注！");
			// 通过shutdown告诉服务端，我已经输出完毕
			//socket.shutdownOutput();

			// 接收回复
			in = socket.getInputStream();
			br = new BufferedReader(new InputStreamReader(in, "utf-8"));
			String str = null;
			while ((str = br.readLine()) != null) {
				System.out.println(str);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (br != null) {
				try {
					br.close();
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
		BufferedReader br = null;
		BufferedWriter bw = null;
		try {
			ss = new ServerSocket(9090);
			s = ss.accept();
			in = s.getInputStream();
			br = new BufferedReader(new InputStreamReader(in, "utf-8"));
			String str = null;
			while ((str = br.readLine()) != null) {
				System.out.println(str);
			}
			// 给客户端发送回复信息
			out = s.getOutputStream();
			bw = new BufferedWriter(new OutputStreamWriter(out, "utf-8"));
			bw.write("信息我已经收到!");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (br != null) {
				try {
					br.close();
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
