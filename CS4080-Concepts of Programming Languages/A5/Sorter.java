import java.util.ArrayList;
import java.util.function.Function;

public class Sorter {

    public static void main(String[] args) {
        // DECLARATIONS
        ArrayList<Student> students = new ArrayList<Student>();
        QuickSort sorter = new QuickSort();

        // DATA (12 students)//
        students.add(new Student("Dan", "45"));
        students.add(new Student("Adam", "39"));
        students.add(new Student("Fiona", "42"));
        students.add(new Student("Kathy", "44"));
        students.add(new Student("Dan", "34"));
        students.add(new Student("Adam", "41"));
        students.add(new Student("Kalin", "50"));
        students.add(new Student("Adam", "40"));
        students.add(new Student("Zehr", "43"));
        students.add(new Student("Mona", "42"));
        students.add(new Student("Kevin", "35"));
        students.add(new Student("Elma", "48"));

        // FUNCTION DEFINITIONS //
        Function<String[], Boolean> cmpGt = stud -> {
            Boolean res;
            if (stud[0].compareTo(stud[1]) > 0) {
                res = true;
            } else {
                res = false;
            }
            return res;
        };

        Function<String[], Boolean> cmpLt = (stud) -> {
            Boolean res;
            if (stud[0].compareTo(stud[1]) < 0) {
                res = true;
            } else {
                res = false;
            }
            return res;
        };

        // SORT CALLS //
        /**
         * First function parameter compares the names, Second function parameter
         * compares grades if equal
         **/

        // Ascending name, Ascending grade
        ArrayList<Student> sortedList1 = new ArrayList<Student>(students);
        sorter.sort(sortedList1, 0, sortedList1.size() - 1, cmpGt, cmpGt);

        // Ascending name, Descending grade
        ArrayList<Student> sortedList2 = new ArrayList<Student>(students);
        sorter.sort(sortedList2, 0, students.size() - 1, cmpGt, cmpLt);

        ArrayList<Student> sortedList3 = new ArrayList<Student>(students);
        sorter.sort(sortedList3, 0, students.size() - 1, cmpLt, cmpLt);

        // PRINT RESULTS //
        System.out.print("\nSorted List 1: [");
        for (Student x : sortedList1) {
            System.out.print(x.getName() + ":" + x.getGrade() + " ");
        }
        System.out.println("]");

        System.out.print("\nSorted List 2: [");
        for (Student x : sortedList2) {
            System.out.print(x.getName() + ":" + x.getGrade() + " ");
        }
        System.out.println("]");

        System.out.print("\nSorted List 3: [");
        for (Student x : sortedList3) {
            System.out.print(x.getName() + ":" + x.getGrade() + " ");
        }
        System.out.println("]");
    };
}