

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

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
		try{
			ServerSocket serverSocket = new ServerSocket(1234);
			while (true) {
				 Socket socket = serverSocket.accept();
				 DataInputStream in = new DataInputStream(socket.getInputStream());
					DataOutputStream out = new
							DataOutputStream(socket.getOutputStream());
					byte[] data = new byte[2048];
					Arrays.fill(data,(byte)0);
					in.read(data);
					String cmd = bytetoString(data);
					if(cmd.equals("connect"))
					{
						out.writeBytes("OK");
					}
			}
			
		}catch(Exception e)
		{
			
		}
	}
}
