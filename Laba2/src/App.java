
import java.util.Random;

class RandomMatrixGenerator {

    public static float[][] generateRandomMatrix(int rows, int columns) {
        if (rows <= 0 || columns <= 0) {
            throw new IllegalArgumentException("Розмірність матриці має бути натуральним числом");
        }

        float[][] matrix = new float[rows][columns];
        Random rand = new Random();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = rand.nextFloat();
            }
        }

        return matrix;
    }
}
class MatrixPrinter {

    public static void printMatrix(float [][] matrix){
        for (float [] i : matrix) {
            for (float j: i) {
                System.out.print(j + "\t\t");
            }
            System.out.println();
        }
    }
}

class Operation {

    public static float[][] count(float a, float [][] B){
        int vectors_number = B.length;
        int elements_number = B[0].length;
        float [][] C = new float[vectors_number][elements_number];
        for (int i = 0; i < vectors_number; i++){
            for (int j = 0; j < elements_number; j++){
                C[i][j] = B[i][j] * a;
            }
        }
        return C;
    }
}

class MatrixAverageCalculator {

    public static double[] calculateColumnAverages(float[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        double[] columnAverages = new double[columns];

        for (int j = 0; j < columns; j++) {
            double sum = 0;
            for (int i = 0; i < rows; i++) {
                sum += matrix[i][j];
            }
            columnAverages[j] = sum / rows;
        }

        return columnAverages;
    }
}

public class App

{
    public static void main(String[] args) {
        int k5 = 5;
        int k7 = 7;
        int k11 = 11;
        int n = 1120;
        int c5 = n % k5;
        int c7 = n % k7;
        int c11 = n % k11;

        System.out.println("C5 = " + c5);
        System.out.println("C7 = " + c7);
        System.out.println("C11 = " + c11);

        System.out.println();
        System.out.println("Matrix B");
        float[][] B = RandomMatrixGenerator.generateRandomMatrix(5, 5);
        MatrixPrinter.printMatrix(B);

        float [][] C = Operation.count(3, B);
        System.out.println();
        System.out.println("Matrix C");
        MatrixPrinter.printMatrix(C);

        System.out.println();
        double [] average = MatrixAverageCalculator.calculateColumnAverages(B);
        for (int i = 0; i < average.length; i++){
            System.out.println("Column " + i + ": " + average[i]);
        }

    }
}