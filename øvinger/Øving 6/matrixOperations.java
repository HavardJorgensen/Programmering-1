import java.util.*;

public class matrixOperations{
    private final int[][] data;
    private final int rows;
    private final int columns;

    public matrixOperations(int[][] values){
        if(values == null || values.length == 0 || values[0].length == 0){
            throw new IllegalArgumentException("get a better matrix chump");
        }
        int cols = values[0].length;
        for (int i = 0; i < values.length; i++) {
            if(values[i].length != cols){
                throw new IllegalArgumentException("The matrix must be rectangular");
            }
        }

        this.rows = values.length;
        this.columns = cols;

        this.data = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            this.data[i] = Arrays.copyOf(values[i], columns);            
        }
    }

    public int rows(){
        return rows;
    }
    public int columns(){
        return columns;
    }
    public int get(int row, int column){
        return data[row][column];
    }


    public matrixOperations addition(matrixOperations other){
        if(other == null || columns != other.columns || rows != other.columns){
            return null;
        }
        int result[][] = new int [rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result[i][j] = data[i][j] + other.data[i][j];
            }
        }
        return new matrixOperations(result);
    }

    public matrixOperations multiply(matrixOperations other){
        if(other == null || columns != other.rows){
            return null;
        }
        int result[][] = new int [rows][other.columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < other.columns; j++){
                int sum = 0;
                for (int k = 0; k < columns; k++) {
                    sum += data[i][k] * other.data[k][j];
                    result[i][j] = sum;                    
                }
            }
        }
        return new matrixOperations(result);
    }

    public matrixOperations transpose(){
        int result[][] = new int[columns][rows];
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++) {
                result[j][i] = data[i][j];
            }
        }
        return new matrixOperations(result);
    }

    @Override public String toString(){
        StringBuilder matrix = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            matrix.append("[");
            for (int j = 0; j < columns; j++) {
                matrix.append(String.format("%2d", data[i][j]));
                
            }
            matrix.append(" ]\n");
        }
        return matrix.toString();
    }





    public static void main(String[] args) {
        int[][] a = { {1, 2, 3}, {4, 5, 6} };
        int[][] b = { {7, 8, 9}, {10, 11, 12} };
        int[][] c = { {1, 2}, {3, 4}, {5, 6} };

        matrixOperations A = new matrixOperations(a);
        matrixOperations B = new matrixOperations(b);
        matrixOperations C = new matrixOperations(c);

        System.out.println("A:\n" + A);
        System.out.println("B:\n" + B);
        System.out.println("C:\n" + C);

        System.out.println("A + B:\n" + A.addition(B));      // samme dimensions
        System.out.println("A * C:\n" + A.multiply(C));      // 2x3 * 3x2 = 2x2
        System.out.println("A^T:\n" + A.transpose());        // transposed

        System.out.println("invalid A + C (expected null): " + A.addition(C));
        System.out.println("invalid B * A (expected null): " + B.multiply(A));
        System.out.println("Done!");        
    }
}