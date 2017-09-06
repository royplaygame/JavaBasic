package com.hy.ly.inetaddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.junit.Test;

public class TestInetAddress {

	public static void main(String[] args) throws UnknownHostException {
		InetAddress inet=InetAddress.getByName("www.qzhangsq.com");
		InetAddress inet1=InetAddress.getByName("portal.qzhangsq.com");
		System.out.println(inet);
		System.out.println(inet1);
		System.out.println(inet.getHostName());
		System.out.println(inet.getHostAddress());
		InetAddress inet2=InetAddress.getByName("localhost");
		System.out.println(inet2.getHostName());
		System.out.println(inet2.getHostAddress());
	}
	
	@Test
	public void test(){
		try {
			InetAddress inet=InetAddress.getLocalHost();
			System.out.println(inet);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
		try {
			InetAddress []inets=InetAddress.getAllByName("localhost");
			for(InetAddress i:inets){
				System.out.println(i);
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
	
	
}
