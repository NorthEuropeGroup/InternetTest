package com.example.internettest;

public class server {
	public String ip;
	public int port;
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
	public  static  void main(String[] args)
	{
		System.out.println("aa");
	}
}
