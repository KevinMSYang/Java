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


public class Reduce 
{
	public static void main(String[] args) throws IOException
	{
		// process data
		String inputfile_1 = "intermediate_1.txt";
		String inputfile_2 = "intermediate_2.txt";
		String outputfile = "final_output.txt";
		File file_1 = new File(inputfile_1);
		Scanner inputData_1 = new Scanner (file_1);
		File file_2 = new File(inputfile_2);
		Scanner inputData_2 = new Scanner (file_2);
		PrintWriter outputData = new PrintWriter(outputfile);
		int i = 1;
		outputData.println("Month MIN MAX AVG RAINING_HOURS");
		while (inputData_1.hasNextLine())
		{
			String file_line = inputData_1.nextLine();
			outputData.println( i +" "+ file_line);
			outputData.flush();
			i++;
		}
		i = 3;
		while (inputData_2.hasNextLine())
		{
			String file_line = inputData_2.nextLine();
			outputData.println( i+ " "+ file_line);
			outputData.flush();
			i++;
		}
	}
}
