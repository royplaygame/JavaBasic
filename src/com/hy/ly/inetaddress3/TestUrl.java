package com.hy.ly.inetaddress3;

import java.io.InputStream;
import java.net.URL;

public class TestUrl {

	public static void main(String[] args) {
		try {
			URL url=new URL("http://qzhangsq.com:80/index.html");
			System.out.println(url.getHost());
			System.out.println(url.getUserInfo());
			System.out.println(url.getPort());
			System.out.println(url.getProtocol());
			System.out.println(url.getFile());
			
			InputStream in=url.openStream();
			byte []b=new byte[1024];
			int len;
			while((len=in.read(b))!=-1){
				String str=new String(b,0,len);
				System.out.print(str);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
