import java.util.*;

class Matrix<T extends Comparable<T>> {
    // fields
    private T[][] matrix;

    // constructor
    public Matrix(T[][] array) {
        this.matrix = array;
    }

    // methods
    public void findMax() {
        int rowIndex = 0, colIndex = 0;
        T max = this.matrix[0][0];
        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[i].length; j++) {
                if (max.compareTo(this.matrix[i][j]) < 0) {
                    max = matrix[i][j];
                    rowIndex = i;
                    colIndex = j;
                }
            }
        }
        System.out.println("Max Element is " + max.toString() + " at index [" + rowIndex + ":" + colIndex + "]");
    }

    public void printMatrix() {
        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}