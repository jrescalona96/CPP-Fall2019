import java.util.Comparator;
import java.lang.Comparable;

public class FindMax {

    // METHODS //
    // helper function
    public static <T> void print(T[][] arr) {
        for (T[] row : arr) {
            System.out.print("[ ");
            for (T element : row) {
                System.out.printf("%s ", element);
            }
            System.out.print("]\n");
        }
    }

    // 2d array
    public static <T extends Comparable<T>> void findMaxValue(T[][] arr) {
        int row = 0, col = 0;
        T max = arr[row][col];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (max.compareTo(arr[i][j]) < 0) {
                    max = arr[i][j];
                    row = i;
                    col = j;
                }
            }
        }
        System.out.println("Max Element is " + max + " at index [" + row + ":" + col + "]\n");
    }

    // MAIN //
    public static void main(String[] args) {
        // DECLARATIONS //
        // Init data
        String[][] strTest = { { "David", "Kelin", "Peter", "Zag", "Diana" },
                { "Elin", "Adam", "Young", "Peter", "Zag" } };
        Integer[][] intTest = { { 1, 2, 4, 4 }, { 5, 5, 4, 2 }, { 3, 1, 1, 5 } };

        // find max values
        System.out.println("Max of String Values:\nGiven: ");
        print(strTest);
        findMaxValue(strTest);

        System.out.println("Max of Integer Values:\nGiven:");
        print(intTest);
        findMaxValue(intTest);
    }
}