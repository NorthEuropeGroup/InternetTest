package com.example.internettest;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

public class internet extends Thread{
	public String ip;
	public int port;
	public internet()
	{
		ip = null;
		port = 0;
	}
	public internet(String tip,int tport)
	{
		ip = tip;
		port = tport;
		
	}
	public void run()
	{
		InetAddress serverAddr = null;
		SocketAddress sc_add = null;
		Socket socket = null;
		
		
		try {
			serverAddr = InetAddress.getByName(ip);
			sc_add= new InetSocketAddress(serverAddr,port);
			socket = new Socket();
			socket.connect(sc_add,2000);
			
		}catch(Exception e)
		{
		
		}
		
		
	}
	
	
	

}
