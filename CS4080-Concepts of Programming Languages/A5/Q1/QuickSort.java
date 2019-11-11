
import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Function;

public class QuickSort {

    // calls partition to locate correct location of pivot then uses that as mid
    // to then sort right and left sub arrays
    void sort(ArrayList<Student> slice, int low, int high, Function<String[], Boolean> cmp1,
            Function<String[], Boolean> cmp2) {
        if (low < high) {
            /*
             * pi is partitioning index, arr[pi] is now at right place
             */
            int pi = partition(slice, low, high, cmp1, cmp2);

            // Recursively sort elements before
            // partition and after partition
            sort(slice, low, pi - 1, cmp1, cmp2);
            sort(slice, pi + 1, high, cmp1, cmp2);
        }

        int j = 1;
        for (int i = 0; i < slice.size() - 1; i++) {
            if (slice.get(i).getName().equals(slice.get(j).getName())) {
                String[] grades = { slice.get(i).getGrade(), slice.get(j).getGrade() };
                if (cmp2.apply(grades)) {
                    Student temp = slice.get(i);
                    slice.set(i, slice.get(j));
                    slice.set(j, temp);
                }
            }
            j++;
        }
    }

    // places the pivot at its correct location then returns the its index
    // cmp1 to compare names, cmp2 to compare graded
    int partition(ArrayList<Student> lst, int low, int high, Function<String[], Boolean> cmp1,
            Function<String[], Boolean> cmp2) {
        Student pivot = lst.get(high);
        int i = (low - 1); // index of smaller element
        for (int j = low; j < high; j++) {
            String[] names = { lst.get(j).getName(), pivot.getName() };
            // If current element is smaller than the pivot
            if (!cmp1.apply(names)) {
                i++;
                // swap lst.get(i) and lst.get(j)
                Student temp = lst.get(i);
                lst.set(i, lst.get(j));
                lst.set(j, temp);
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        Student temp = lst.get(i + 1);
        lst.set(i + 1, lst.get(high));
        lst.set(high, temp);

        return i + 1;
    }
}
