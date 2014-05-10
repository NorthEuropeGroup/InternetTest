package com.example.internettest;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Arrays;





import android.os.Handler;
import android.widget.TextView;
import android.widget.Toast;

public class internet extends Thread{
	public String ip;
	public int port;
	public String text;
	Handler notify = new Handler();
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
	public String bytetoString(byte [] data1)
	  {
		  String ans = "";
		  for(int i = 0;;i++)
		  {
			  if(data1[i]==0)
				  break;
			  ans = ans + (char)data1[i];
		  }
		  return ans;
	  }
	
	@Override
	public void run()
	{
		InetAddress serverAddr = null;
		SocketAddress sc_add = null;
		Socket socket = null;
		
		
		try {
			serverAddr = InetAddress.getByName("192.168.144.1");
			sc_add= new InetSocketAddress(serverAddr,5000);
			
			socket.connect(sc_add,2000);
			DataInputStream in = new DataInputStream(socket.getInputStream());
			DataOutputStream out = new
					DataOutputStream(socket.getOutputStream());
			byte[] data = new byte[2048];
			out.writeBytes("connect");
			Arrays.fill(data, (byte)0);
			in.read(data);
			String cmd = bytetoString(data);
			if(cmd.equals("OK"))
			{
				 
				text = "Connected";
					
			}
			
		}catch(Exception e)
		{
		
		}
		
		
	}
	
	
	

}
