import java.util.*;

class Sets {
    public static void main(String[] args) {
        Set<Integer> intersect = new HashSet<Integer>(); // set to hold intersection items
        Set<Integer> diff = new HashSet<Integer>(); // set to hold difference items
        // initialization
        Set<Integer> s1 = new HashSet<Integer>();
        s1.add(Integer.valueOf(1));
        s1.add(Integer.valueOf(5));
        s1.add(Integer.valueOf(3));
        s1.add(Integer.valueOf(6));
        s1.add(Integer.valueOf(7));
        s1.add(Integer.valueOf(8));
        Set<Integer> s2 = new HashSet<Integer>();
        s2.add(Integer.valueOf(2));
        s2.add(Integer.valueOf(5));
        s2.add(Integer.valueOf(6));
        s2.add(Integer.valueOf(9));
        s2.add(Integer.valueOf(7));
        // set difference : loop through s1 to check if s2 does not contain s1 elements
        for (Integer num1 : s1) {
            if (!s2.contains(num1)) {
                diff.add(num1);
            }
        }
        // set intersection : loop through s2 to check if s1 contains s2 elements
        for (Integer num2 : s2) {
            if (s1.contains(num2)) {
                intersect.add(num2);
            }
        }
        // log results
        System.out.println("\n********Java Results***********");
        System.out.println("Set Difference = " + diff);
        System.out.println("Set Intersection = " + intersect);
    }
}