
import java.util.Random;

class RandomMatrixGenerator {

    public static double[][] generateRandomMatrix(int rows, int columns) {
        if (rows <= 0 || columns <= 0) {
            throw new IllegalArgumentException("Розмірність матриці має бути натуральним числом");
        }

        double[][] matrix = new double[rows][columns];
        Random rand = new Random();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = rand.nextDouble();
            }
        }
        return matrix;
    }
}

class MatrixPrinter {

    public static void printMatrix(double [][] matrix){
        for (double [] i : matrix) {
            for (double j: i) {
                System.out.print(j + "\t");
            }
            System.out.println();
        }
    }
}

class Operation {

    public static double[][] multiply(double[][] A, double[][] B) {
        int rowsA = A.length;
        int colsA = A[0].length;
        int rowsB = B.length;
        int colsB = B[0].length;

        if (colsA != rowsB) {
            throw new IllegalArgumentException("Неможливо виконати множення матриць: кількість стовбців матриці A не дорівнює кількості рядків матриці B.");
        }

        double[][] C = new double[rowsA][colsB];

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                C[i][j] = 0; 
                for (int k = 0; k < colsA; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return C;
    }
}

class MatrixSumOfMinCalculator {

    public static double calculateSumOfMin(double[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        double[] columnMin = new double[columns];
        double sum = 0;

        for (int j = 0; j < columns; j++) {
            double min = matrix[0][j]; 

            for (int i = 0; i < rows; i++) {
                if (matrix[i][j] < min) {
                    min = matrix[i][j]; 
                }
            }
            columnMin[j] = min; 
            sum += columnMin[j];
        }
        return sum;
    }
}

public class App
{
    public static void main(String[] args) {
        int k5 = 5;
        int k7 = 7;
        int k11 = 11;
        int n = 1309;
        int c5 = n % k5;
        int c7 = n % k7;
        int c11 = n % k11;

        System.out.println("C5 = " + c5);
        System.out.println("C7 = " + c7);
        System.out.println("C11 = " + c11);

        System.out.println();
        System.out.println("Matrix A");
        double[][] A = RandomMatrixGenerator.generateRandomMatrix(5, 5);
        MatrixPrinter.printMatrix(A);

        System.out.println();
        System.out.println("Matrix B");
        double[][] B = RandomMatrixGenerator.generateRandomMatrix(5, 5);
        MatrixPrinter.printMatrix(B);

        double [][] C = Operation.multiply(A, B);
        System.out.println();
        System.out.println("Matrix C");
        MatrixPrinter.printMatrix(C);

        System.out.println();
        double sum = MatrixSumOfMinCalculator.calculateSumOfMin(C);
        System.out.println("Sum of min: " + sum);
        System.out.println();
    }
}