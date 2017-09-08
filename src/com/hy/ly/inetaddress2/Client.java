package com.hy.ly.inetaddress2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {

	public static void main(String[] args) {
		Socket socket=null;
		OutputStream out=null;
		InputStream in=null;
		try{
			socket = new Socket("localhost",9090);
			out=socket.getOutputStream();
			out.write("我是客户端，请多多关照！".getBytes());
			//关闭客户的输出
			socket.shutdownOutput();
			
			
			//接收服务器的消息
			in=socket.getInputStream();
			byte []b=new byte[1024];
			int len;
			while((len=in.read(b))!=-1){
				String str=new String(b,0,len);
				System.out.print(str);
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
