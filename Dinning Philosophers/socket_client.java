import java.net.*;
import java.io.*;

public class socket_client 
{
	
	private Socket socket = null;
	private BufferedReader input = null;
	private DataOutputStream out = null;
	
	
	public socket_client (String address, int port)
	{
		try
		{
			socket = new Socket(address, port);
			System.out.println("Connected");
			
			// takes input from terminal 
			input = new BufferedReader(new InputStreamReader(System.in));
			// sends output to the socket
			out = new DataOutputStream(socket.getOutputStream());
		}
		catch(UnknownHostException u)
		{
			System.out.println(u);
		}
		catch(IOException i)
		{
			System.out.println(i);
		}
		
		// String to read message from input
		String line = "";
		
		// keep reading until "over" is input
		
		while(!line.equals("Over"))
		{
			try
			{
				line = input.readLine();
				out.writeUTF(line);
			}
			catch(IOException i)
			{
				System.out.println(i);
			}
		}
		
		// close the connection
		try
		{
			input.close();
			out.close();
			socket.close();
		}
		catch(IOException i)
		{
			System.out.println(i);
		}
	}
	
	public static void main(String args[])
	{
		socket_client client = new socket_client("10.10.13.239", 3000);
	}

}
