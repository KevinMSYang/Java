import java.util.*;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Map_1 
{
	public final static int SOCKET_PORT_1 = 7000;
	public final static String SERVER = "147.97.164.79";
	public final static String FILE_TO_RECEIVED = "splitfile_1.txt";
	public final static int FILE_SIZE = 200000;
	
	public static void main(String[] args) throws IOException
	{
		
		int bytesRead;
	    int current = 0;
	    FileOutputStream fos_map1 = null;
	    BufferedOutputStream bos_map1 = null;
	    Socket sock_map1 = null;
	    
	    try
	    {
	    	sock_map1 = new Socket(SERVER, SOCKET_PORT_1);
	    	System.out.println("Connecting...");
	    	
	    	// receive file
	    	byte[] mybytearray = new byte[FILE_SIZE];
	    	InputStream is = sock_map1.getInputStream();
	    	fos_map1 = new FileOutputStream(FILE_TO_RECEIVED);
	    	bos_map1 = new BufferedOutputStream(fos_map1);
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
	    	
	    	bos_map1.write(mybytearray,0,current);
	    	bos_map1.flush();
	    	
	    	System.out.println("File " + FILE_TO_RECEIVED + " downloaded (" + current + "bytes read)");
	    	System.out.println("mybytearray size = " + mybytearray.length);
	    	System.out.println("bytesRead = " + bytesRead);
	    	System.out.println("current = " + current);
	    	
	    }
	    finally
	    {
	    	if (fos_map1 != null)
	    	{
	    		fos_map1.close();
	    	}
	    	if (bos_map1 != null)
	    	{
	    		bos_map1.close();
	    	}
	    	if (sock_map1 != null)
	    	{
	    		sock_map1.close();
	    	}
	    }
		
		
		
		// process data
		double[] ans_1 = new double[4];
		double[] ans_2 = new double[4];
		String inputfile = "splitfile_1.txt";
		String outputfile = "intermediate_1.txt";
		File file = new File(inputfile);
		Scanner inputData = new Scanner(file);
		PrintWriter outputData_1 = new PrintWriter(outputfile);
		int counter_month = 0;
		int partition = 745;
		int partition_2 = 502;
		int loop = 1;
		int min = 0;
		int max = 0;
		int sum = 0;
		int count_yes = 0;
		int sum_2 = 0;
		int loop_2 = 1;
		int min_2 = 0;
		int max_2 = 0;
		int count_yes_2 = 0;
		
		while (inputData.hasNextLine())
		{
			String str = inputData.nextLine();
			String station, date, temperature, precip;
			Scanner key = new Scanner(str);
			inputData.useDelimiter(" ");
			station = key.next();
			date = key.next();
			temperature = key.next();
			precip = key.next();
			counter_month++;
			
			if (counter_month <= partition)
			{
				sum += Integer.parseInt(temperature);
				if (loop == 1)
				{
					min = Integer.parseInt(temperature);
					ans_1[0] = min;
					max = Integer.parseInt(temperature);
					ans_1[1] = max;
					loop ++;
				}
				if (ans_1[0] >= Integer.parseInt(temperature))
				{
					ans_1[0] = Integer.parseInt(temperature);
				}
				if (ans_1[1] <= Integer.parseInt(temperature))
				{
					ans_1[1] = Integer.parseInt(temperature);
				}
				
				if (precip.equals("YES"))
				{
					count_yes++;
				}
 			}
			if (counter_month > partition)
			{
				sum_2 += Integer.parseInt(temperature);
				if (loop_2 == 1)
				{
					min_2 = Integer.parseInt(temperature);
					ans_2[0] =min_2;
					max_2 = Integer.parseInt(temperature);
					ans_2[1]= max_2;
					loop_2 ++;
				}
				if (ans_2[0] >= Integer.parseInt(temperature))
				{
					ans_2[0] = Integer.parseInt(temperature);
				}
				if (ans_2[1] <= Integer.parseInt(temperature))
				{
					ans_2[1] = Integer.parseInt(temperature);
				}
				
				if (precip.equals("YES"))
				{
					count_yes_2++;
				}
			}
		}
		ans_1[2] = sum / partition;
		ans_1[3] =  count_yes;
		ans_2[2] = sum_2 / partition_2;
		ans_2[3] = count_yes_2;
		for (int i = 0; i < ans_1.length; i++)
		{
			outputData_1.printf(ans_1[i] + " ");
		}
		outputData_1.println();
		outputData_1.flush();
		for (int i = 0; i < ans_2.length; i++)
		{
			outputData_1.printf(ans_2[i] + " ");
		}
		outputData_1.flush();
		// test print out
		for (int i = 0; i < ans_1.length; i++)
		{
			System.out.print(ans_1[i] + " ");
		}
		System.out.println();
		for (int i = 0; i < ans_2.length; i++)
		{
			System.out.print(ans_2[i] + " ");
		}
	}
}
