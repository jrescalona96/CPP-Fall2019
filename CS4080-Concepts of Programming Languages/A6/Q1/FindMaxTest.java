import java.util.*;

public class FindMaxTest {
    public static void main(String[] args) {

        String[][] strTest = new String[][] { { "David", "Kelin", "Peter", "Zag", "Diana" },
                { "Elin", "Adam", "Young", "Peter", "Zag" } };
        Integer[][] intTest = new Integer[][] { { 1, 2, 4, 4 }, { 5, 5, 4, 2 }, { 3, 1, 1, 5 } };

        // printArray(strTest);
        // printArray(intTest);

        // TEST
        Matrix matrix1 = new Matrix(strTest);
        Matrix matrix2 = new Matrix(intTest);
        // matrix1.printMatrix();
        // matrix2.printMatrix();
        matrix1.findMax();
        matrix2.findMax();
    }

    public static <T> void printArray(T[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print("[");
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.print("]\n");
        }
    }
}