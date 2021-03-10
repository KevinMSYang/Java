
public class Co_cluster
{
    public static void main(String[] args)
    {
        // initialize value
        final int MAX = 0;
        final double Epsilon = 1.5;
        // main variables
        double[][] A = { {1, 1, 10, 10},
            {1, 1, 10, 10},
            {5, 5, 6, 6}};
        // partition variables : k1: rows ; k2: columns
        int k1 = 2;
        int k2 = 2;
        // loop counter
        int k = 0;
        // partition in rows and columns range
        int row_parti = 1;
        int col_parti = 1;
        // three variables to store optimal value
        double V0, Vy1, Vy2, Vx;
        //==================== STEP 0 ====================//
        // original matrix declaration X, Y1, Y2
        double[][] X = Artificial_central(A, row_parti, col_parti);
        double[][] Y1 = Matrix_partition(A, A.length, k1, row_parti);
        double[][] Y2 = Matrix_partition(A, A[0].length, k2, col_parti);
        // generate a temporary matrix to store part of result
        double[][] result = MultiplyMatrix(Y1, X);
        double[][] temp_Y = Matrix_mode2(Y2);
        result = MultiplyMatrix(result, temp_Y);
        result = Substract_matrix(A, result);
        V0 = MAX  - Frobenius(result);
        System.out.println("Given matrix A: ");
        Printout(A);
        System.out.println("Original matrix X: ");
        Printout(X);
        System.out.println("Original matrix Y1: ");
        Printout(Y1);
        System.out.println("Original matrix Y2: ");
        Printout(Y2);
        System.out.println("Start iteration: ");
        System.out.println("V0 = " + V0);
        
        //==================== STEP 1 ====================//
        double temp_V_old = V0;
        double current_V = 0;
        do
        {
            //==================== STEP 1.1 ====================//
            int temp_col_parti = col_parti + 1;
            double[][] temp_Y2 = Matrix_partition(A, A[0].length, k2, temp_col_parti);
            result = MultiplyMatrix(Y1, X);
            temp_Y = Matrix_mode2(temp_Y2);
            result = MultiplyMatrix(result, temp_Y);
            result = Substract_matrix(A, result);
            Vy2 = MAX - Frobenius(result);
            System.out.println("Vy2 = " + Vy2);
            //==================== STEP 1.2 ====================//
            int temp_row_parti = row_parti + 1;
            double[][] temp_Y1 = Matrix_partition(A, A.length, k1, temp_row_parti);
            result = MultiplyMatrix(temp_Y1, X);
            temp_Y = Matrix_mode2(Y2);
            result = MultiplyMatrix(result, temp_Y);
            result = Substract_matrix(A, result);
            Vy1 = MAX - Frobenius(result);
            System.out.println("Vy1 = " + Vy1);
            //==================== STEP 1.3 ====================//
            double[][] temp_X = Artificial_central(A, temp_row_parti, temp_col_parti);
            result = MultiplyMatrix(Y1, temp_X);
            temp_Y = Matrix_mode2(Y2);
            result = MultiplyMatrix(result, temp_Y);
            result = Substract_matrix(A, result);
            Vx = MAX - Frobenius(result);
            System.out.println("Vx = " + Vx);
            
            //==================== STEP 2 ====================//
            double temp_V = Select_max(Vy2, Vy1, Vx);
            // Maximum Improvement
            if (temp_V == Vy2)
            {
                Y2 = Update_matrix(Y2, temp_Y2);
                col_parti = temp_col_parti;
                System.out.println("Update Matrix: ");
                System.out.println("Current Y2: " );
                Printout(Y2);
            }
            else if (temp_V == Vy1)
            {
                Y1 = Update_matrix(Y1, temp_Y1);
                row_parti = temp_row_parti;
                System.out.println("Update Matrix: ");
                System.out.println("Current Y1: ");
                Printout(Y1);
            }
            else
            {
                X = Update_matrix(X, temp_X);
                System.out.println("Update Matrix: ");
                System.out.println("Current X: ");
                Printout(X);
            }
            
            System.out.println("V" + (++k) + " = " + temp_V );
            
            //==================== STEP 3 ====================//
            current_V = temp_V - temp_V_old;
            temp_V_old = temp_V;
        }
        while(current_V >= Epsilon);
        
        //==================== STEP 4 ====================//
        System.out.println("Final optimal X matrix based on Y1 and Y2: ");
        X = Artificial_central(A, row_parti, col_parti);
        Printout(X);
    }
    
    // Calculate central value based on current partition
    public static double[][] Artificial_central(double[][] array, int row_parti, int col_parti)
    {
        double[][] temp = new double[2][2];
        double sum = 0;
        double count = 0;
        for (int i = 0; i < row_parti; i++ )
        {
            for (int j = 0; j < col_parti; j++)
            {
                sum += array[i][j];
                count++;
            }
        }
        temp[0][0] = sum / count;
        
        sum = 0; count = 0;
        for (int i = row_parti; i < array.length; i++)
        {
            for (int j = 0; j < col_parti; j++)
            {
                sum += array[i][j];
                count++;
            }
        }
        temp[1][0] = sum / count;
        
        sum = 0; count = 0;
        for (int i = 0; i < row_parti; i++ )
        {
            for (int j = col_parti; j < array[0].length; j++)
            {
                sum += array[i][j];
                count++;
            }
        }
        temp[0][1] = sum / count;
        
        sum = 0; count = 0;
        for (int i = row_parti; i < array.length; i++)
        {
            for (int j = col_parti; j < array[0].length; j++)
            {
                sum += array[i][j];
                count++;
            }
        }
        temp[1][1] = sum / count;
        
        return temp;
    }
    
    // Pass given matrix A and the partition value to generate sub-matrix Y1 or Y2
    public static double[][] Matrix_partition(double[][] array, int row, int column, int partition)
    {
        double[][] temp = new double[row][column];
        
        for (int i = 0, j = 0; i < partition; i++)
        {
            temp[i][j] = 1;
        }
        for (int i = partition, j = 1; i < row; i++)
        {
            temp[i][j] = 1;
        }
        
        return temp;
    }
    
    // Transport Y2 matrix to mode 2
    public static double[][] Matrix_mode2(double[][] array)
    {
        int row = array.length;
        int column = array[0].length;
        double[][] temp = new double[column][row];
        
        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < column ; j++)
            {
                temp[j][i] = array[i][j];
            }
        }
        
        return temp;
    }
    
    // Subtract the matrix from given matrix A to the result after doing calculation from X, Y1, Y2
    public static double[][] Substract_matrix(double[][] array_A, double[][] array_B)
    {
        int row = array_A.length;
        int column = array_A[0].length;
        double[][] result = new double[row][column];
        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < column; j++)
            {
                result[i][j] = array_A[i][j] - array_B[i][j];
            }
        }
        return result;
    }
    
    // Update the counterpart matrix when we found max value between Vy1, Vy2, and Vx
    public static double[][] Update_matrix(double[][] array, double[][] array_new)
    {
        int row = array.length;
        int column = array[0].length;
        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < column; j++)
            {
                array[i][j] = array_new[i][j];
            }
        }
        
        return array;
    }
    
    // Finding the max value between Vy2, Vy1 and Vx
    public static double Select_max(double V_y2, double V_y1, double V_x)
    {
        double V_value = 0;
        
        if (V_y2 > V_y1 && V_y2 > V_x)
        {
            return V_value = V_y2;
        }
        if (V_y1 > V_y2 && V_y1 > V_x)
        {
            return V_value = V_y1;
        }
        if (V_x > V_y1 && V_x > V_y2)
        {
            return V_value = V_x;
        }
        return V_value;
    }
    
    // Multiply with two matrix, and return the product
    public static double[][] MultiplyMatrix(double[][] array_A, double[][] array_B)
    {
        int row_A = array_A.length;
        int row_B = array_B.length;
        int cols_B = array_B[0].length;
        double[][] product = new double[row_A][cols_B];
        
        for (int i = 0; i < row_A; i++)
        {
            for (int j = 0; j < cols_B; j++)
            {
                for (int k = 0; k < row_B; k++)
                {
                    product[i][j] += array_A[i][k] * array_B[k][j];
                }
            }
        }
        return product;
    }
    
    // Frobenius: square each element and sum them up. Then take a square root
    public static double Frobenius(double[][] array)
    {
        int row = array.length;
        int column = array[0].length;
        double V_value;
        double sum = 0;
        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < column; j++)
            {
                sum += array[i][j] * array[i][j];
            }
        }
        V_value = Math.sqrt(sum);
        return V_value;
    }
    
    // Print out Matrix
    public static void Printout(double[][] array)
    {
        int row = array.length;
        int column = array[0].length;
        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < column; j++)
            {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
