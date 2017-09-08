package com.hy.ly.inetaddress1;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void relese(InputStream in, Socket socket, ServerSocket ss) {
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
		if (ss != null) {
			try {
				ss.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		ServerSocket ss = null;
		Socket socket = null;
		InputStream in = null;

		try {
			ss=new ServerSocket(9090);
			socket=ss.accept();
			in=socket.getInputStream();
			byte []b=new byte[1024];
			int len;
			while((len=in.read(b))!=-1){
				String str=new String(b,0,len);
				System.out.print(str);
			}
			System.out.println("\n收到来自于"+socket.getInetAddress().getHostAddress()+"的信息！");
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			Server.relese(in, socket, ss);
		}
	}

}
