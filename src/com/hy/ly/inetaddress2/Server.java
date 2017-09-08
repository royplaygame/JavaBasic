package com.hy.ly.inetaddress2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		ServerSocket ss=null;
		Socket s=null;
		InputStream in=null;
		OutputStream out=null;
		try{
			ss=new ServerSocket(9090);
			s=ss.accept();
			in=s.getInputStream();
			byte []b=new byte[1024];
			int len;
			while((len=in.read(b))!=-1){
				String str=new String(b,0,len);
				System.out.print(str);
			}
			System.out.println();
			System.out.println("\t 收到来自于"+s.getLocalAddress().getHostAddress()+" 的信息！");
			
			//再向客户发送回复信息
			out=s.getOutputStream();
			out.write("我是服务器，你的信息已经收到！".getBytes());
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				s.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				ss.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
