package com.hy.ly.inetaddress;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import org.junit.Test;

/**
 * 统一资源定位符，一个URL对象，对应一个互联网上的资源
 * 
 * @author ssr
 *
 */
public class TestURL {

	@Test
	public void testUrl() {
		URL url = null;
		InputStream in = null;
		InputStream in2 = null;
		FileOutputStream fos = null;
		try {
			// 创建URL对象
			url = new URL("http://localhost:8080/myWeb/index.jsp");
			// 常用方法
			System.out.println(url.getProtocol());
			System.out.println(url.getHost());
			System.out.println(url.getPort());
			System.out.println(url.getPath());
			System.out.println(url.getFile());
			System.out.println(url.getRef());
			System.out.println(url.getQuery());

			// 如何将服务端的资源读取下来 url.openStream()
			in = url.openStream();
			byte[] b = new byte[100];
			int len;
			while ((len = in.read(b)) != -1) {
				String str = new String(b, 0, len);
				System.out.println(str);
			}

			// 如果想数据既有输入，又有输出 ; 要用这个url.openConnection()
			URLConnection urlCon = url.openConnection();
			in2 = urlCon.getInputStream();
			fos = new FileOutputStream(new File("index.jsp"));
			byte[] b2 = new byte[1024];
			int len2;
			while ((len2 = in2.read(b2)) != -1) {
				fos.write(b2, 0, len2);
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
			if (in2 != null) {
				try {
					in2.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
