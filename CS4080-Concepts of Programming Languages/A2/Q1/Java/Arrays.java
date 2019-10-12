import java.util.*;

class Arrays {
    public static void main(String[] args) {
        // declarations
        Random rand = new Random();
        int SIZE = 8000;
        int[] arr = new int[SIZE];

        long start = System.nanoTime(); // start time

        for (int i = 0; i < SIZE; i++) {
            arr[i] = rand.nextInt(1000);
        }

        long stop = System.nanoTime(); // end time
        long time = (stop - start) / 1000;

        System.out.print(time + " ");
    }
}