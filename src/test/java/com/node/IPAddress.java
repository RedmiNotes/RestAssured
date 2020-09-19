package com.node;
import java.net.InetAddress;
public class IPAddress {
public static void main(String[] args) {
	try {
	InetAddress ip = InetAddress.getLocalHost();
	System.out.println(ip);
	}catch (Exception e) {
		e.printStackTrace();
	}
}
}
