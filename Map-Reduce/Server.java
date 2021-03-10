import java.util.*;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server 
{
	// sock from client
	public final static int SOCKET_PORT = 2000;
	public final static String SERVER = "147.97.164.79";
	public final static String FILE_TO_RECEIVED = "OutputFile.txt";
	public final static int FILE_SIZE = 200000; 
	
	// sock to map1
	public final static int SOCKET_PORT_1 = 7000;
	public final static String FILE_TO_SEND = "splitfile_1.txt";
	
	public static void main(String[] args) throws IOException 
	{
		//socket from client
	    int bytesRead;
	    int current = 0;
	    FileOutputStream fos = null;
	    BufferedOutputStream bos = null;
	    Socket sock = null;
	    
	    try
	    {
	    	sock = new Socket(SERVER, SOCKET_PORT);
	    	System.out.println("Connecting...");
	    	
	    	// receive file
	    	byte[] mybytearray = new byte[FILE_SIZE];
	    	InputStream is = sock.getInputStream();
	    	fos = new FileOutputStream(FILE_TO_RECEIVED);
	    	bos = new BufferedOutputStream(fos);
	    	bytesRead = is.read(mybytearray,0,mybytearray.length);
	    	current = bytesRead;
	    	
	    	do
	    	{
	    		bytesRead = is.read(mybytearray,current,(mybytearray.length-current));
	    		if (bytesRead >= 0)
	    		{
	    			current += bytesRead;
	    		}
	    	}
	    	while (bytesRead > -1);
	    	
	    	bos.write(mybytearray,0,current);
	    	bos.flush();
	    	
	    	System.out.println("File " + FILE_TO_RECEIVED + " downloaded (" + current + "bytes read)");
	    	System.out.println("mybytearray size = " + mybytearray.length);
	    	System.out.println("bytesRead = " + bytesRead);
	    	System.out.println("current = " + current);
	    	
	    }
	    finally
	    {
	    	if (fos != null)
	    	{
	    		fos.close();
	    	}
	    	if (bos != null)
	    	{
	    		bos.close();
	    	}
	    	if (sock != null)
	    	{
	    		sock.close();
	    	}
	    }
	    
	    // split the file
		String inputfile = "OutputFile.txt";
		String outputfile_1 = "splitfile_1.txt";
		String outputfile_2 = "splitfile_2.txt";
		File file = new File(inputfile);
		Scanner inputData = new Scanner(file);
		
		PrintWriter outputData_1 = new PrintWriter(outputfile_1);
		PrintWriter outputData_2 = new PrintWriter(outputfile_2);
		int part_1 = 1441;
	    int counter_total_line = 0;
	    
	    while (inputData.hasNextLine())
	    {
	    	String file_line = inputData.nextLine();
	    	counter_total_line++;
	    	if (counter_total_line <= part_1)
	    	{
	    		outputData_1.println(file_line);
	    		outputData_1.flush();
	    	}
	    	
	    	if (counter_total_line > part_1)
	    	{
	    		outputData_2.println(file_line);
	    		outputData_2.flush();
	    	}	
	    }
		System.out.println("Done");
		
		// socket to map1
		FileInputStream fis_map1 = null;
		BufferedInputStream bis_map1 = null;
		OutputStream os_map1 = null;
		ServerSocket servsock_map1 = null;
		Socket sock_map1 = null;
		Boolean run = true;
		
		try
		{
			servsock_map1 = new ServerSocket(SOCKET_PORT_1);
			while(run)
			{
				System.out.println("Waiting...");
				try
				{
					sock_map1 = servsock_map1.accept();
					System.out.println("Accepted connection : " + sock_map1);
					// send file
					File myFile = new File (FILE_TO_SEND);
					byte[] mybytearray = new byte [(int)(myFile).length()];
					fis_map1 = new FileInputStream(myFile);
					bis_map1 = new BufferedInputStream(fis_map1);
					bis_map1.read(mybytearray,0,mybytearray.length);
					os_map1 = sock_map1.getOutputStream();
					
					System.out.println("Sending "+ FILE_TO_SEND + "(" + mybytearray.length + " bytes)");
					System.out.println("mybytearray= " + mybytearray.length);
					os_map1.write(mybytearray,0,mybytearray.length);
					os_map1.flush();
					
					System.out.println("Done");
				}
				catch(IOException ex)
				{
					System.out.println(ex);
				}
				finally
				{
					if (bis_map1 != null)
					{
						bis_map1.close();
					}
					if (os_map1 != null)
					{
						os_map1.close();
					}
					if (sock_map1 != null)
					{
						sock_map1.close();
					}
				}
				run = false;
			}
		}
		finally
		{
			if (servsock_map1 != null)
			{
				servsock_map1.close();
			}
		}
	}	
}
