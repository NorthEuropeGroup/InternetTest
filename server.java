

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.net.InetAddress;
public class server {
	public String ip;
	public int port;
	
	public static String bytetoString(byte [] data1)
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
		 String SERVER_ADDRESS="140.116.104.209";
		InetAddress inetAddress;
		ServerSocket serverSocket;
		try{
			inetAddress=InetAddress.getByName(SERVER_ADDRESS);
			serverSocket=new ServerSocket(5000, 15);
			while (true) {
				System.out.println("Ac");
				 Socket socket = serverSocket.accept();
				 System.out.println("Ac");
				 DataInputStream in = new DataInputStream(socket.getInputStream());
					DataOutputStream out = new
							DataOutputStream(socket.getOutputStream());
					byte[] data = new byte[2048];
					Arrays.fill(data,(byte)0);
					in.read(data);
					String cmd = bytetoString(data);
					System.out.println(cmd);
					if(cmd.equals("connect"))
					{
						out.writeBytes("OK");
					}
					socket.close();
			}
			
		}catch(Exception e)
		{
			
		}
	}
}
