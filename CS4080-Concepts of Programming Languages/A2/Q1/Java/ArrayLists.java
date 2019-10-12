import java.util.*;

class ArrayLists {
    public static void main(String[] args) {
        // declarations
        Random rand = new Random();
        int SIZE = 8000;
        ArrayList<Integer> arrList = new ArrayList<Integer>();

        long start = System.nanoTime(); // log start time
        for (int i = 0; i < SIZE; i++) {

            arrList.add(Integer.valueOf(rand.nextInt(1000)));
        }
        long stop = System.nanoTime(); // log end time
        long time = (stop - start) / 1000;

        System.out.print(time + " ");
    }
}