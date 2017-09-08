package com.hy.ly.inetaddress1;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
	
	public static void  relese(OutputStream out,Socket socket){
		if(out!=null){
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(socket!=null){
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		Socket socket = null;
		OutputStream out = null;
		try {
			socket = new Socket(InetAddress.getByName("localhost"), 9090);
			out=socket.getOutputStream();
			out.write("我是客户端，请多多关照".getBytes());
			socket.shutdownOutput();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			Client.relese(out, socket);
		}
	}
}
