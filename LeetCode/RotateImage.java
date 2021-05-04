import java.util.*;
public class RotateImage 
{
	public static void main(String[] args)
	{
		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
		rotate(matrix);
	}
	
	public static void rotate(int[][] matrix)
	{
		for (int i = 0; i < matrix.length; i++)
		{
			for (int j = i+1; j < matrix[0].length; j++)
			{
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
		for (int i = 0; i < matrix.length; i++)
		{
			for (int j = 0; j < matrix.length/2; j++)
			{
				int temp = matrix[i][j];
				matrix[i][j] = matrix[i][matrix.length-1-j];
				matrix[i][matrix.length-1-j] = temp;
			}
		}
		print(matrix);
	}
	public static void print(int[][] arr)
	{
		for (int i = 0; i < arr.length; i++)
		{
			System.out.println();
			for (int j = 0; j < arr.length; j++)
			{
				if(j == arr.length-1)
				{
					System.out.print(arr[i][j]);
				}
				else
				{
					System.out.print(arr[i][j]+",");
				}
			}
		}
	}
}
