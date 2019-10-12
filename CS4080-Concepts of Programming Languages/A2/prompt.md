John Escalona
CS4080 TTh 10:00am
Assignment #2 (10 points)
 
1. For this problem our task is to store 8000 randomly generated integers in the range of 1 to 1000 inclusively using different languages/methods.
Stack C++ Code:
#include <iostream>
#include <cstdlib>
#include <chrono>

using namespace std;
using namespace std::chrono;

int main(int argc, char *argv[])
{
    const int RANGE = 1000;
    const int SIZE = 8000;

    //Task #1: stack dynamic array
    int stackArray[SIZE];
    auto start = high_resolution_clock::now(); //start time
    for (int i = 0; i < SIZE; i++)
    {
        stackArray[i] = (rand() % RANGE + 1);
    }
    auto stop = high_resolution_clock::now(); //stop time
    auto time = duration_cast<microseconds>(stop - start);

    cout << time.count() << " ";
    return 0;
}

Heap C++ Code:
#include <iostream>
#include <cstdlib>
#include <chrono>

using namespace std;
using namespace std::chrono;

int main(int argc, char *argv[])
{
    const int RANGE = 1000;
    const int SIZE = 8000;

    //Task #2: heap dynamic array
    int *heapArray = new int[SIZE];
    auto start = high_resolution_clock::now(); //start time
    for (int i = 0; i < SIZE; i++){
        heapArray[i] = (rand() % RANGE + 1);
    }
    auto stop = high_resolution_clock::now(); //stop time
    auto time = duration_cast<microseconds>(stop - start);
    cout << time.count() << " ";

    return 0;
}
Arrays Java:
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
ArrayList Java:
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



Averages:
Task 1 Average = 60.4 microseconds
Task 2 Average = 68.6 microseconds
Task 3 Average = 754.7 microseconds
Task 4 Average = 2392.8 microseconds

(1) Task 1 vs. Task 2.
Which one is easier to program? Task 1
Which task runs faster or are they similar in performance? Task 1
Why?
	- Task 1 was easier to program because the syntax to declare an array is simpler than dynamically allocated arrays. Also, Task 1 ran faster because all the memory locations for the array allocated during compilation as oppose the having to ask the OS for the space while running.

(2) Task 3 vs. Task 4.
Which one is easier to program?
	- Task 3
What’s the advantage of using ArrayList?
	- Arraylists can grow and they also include functions to manipulate its content.
Which task runs faster or are they similar in performance? 
	- Task 3
Why? 
	- I notice that ArrayList took almost twice the time to complete the same task compared to when using regular arrays. Because ArrayList needed to be type-casted, the job took a lot longer. In addition, regular arrays in java store the values directly using the address reference as oppose to ArrayLists where the function add() needs to be called for the same purpose which requires more resources.
Output:
 

2.  C++, Java, Python.
Assume we have two sequences of values S1 containing 1, 5, 3, 6, 7, 8 while S2 containing 2, 5, 6, 9, 7. 
We’d store these two sequences as sets and perform set intersection and set difference. Write C++, Java, Python codes to do that respectively. Compare and contrast the readability and writability.

By far the most readable implementation of this program is in python. Since both set intersection and set difference are included in python’s standard library, its abstraction and naming make it really easy to read. Initializing the elements in python is also straight forward. This is also the case in C++. Whereas in Java, each element must be added to the set using it add function. In addition, each element must be type-casted to an Object Type, in this case I used an Integer wrapper. These makes the program much harder to read. In terms of writability, python still does best since it is very short and the syntax is very simple. All comparisons of elements are done under the hood while a for loop is needed to traverse and compare the elements for both C++ and Java.
C++:
#include <iostream>
#include <unordered_set>

using namespace std;

int main() {
    unordered_set<int> intersect; // set to hold intersection items
    unordered_set<int> diff;      // set to hold difference items
    // initialization
    unordered_set<int> s1{1, 5, 3, 6, 7, 8};
    unordered_set<int> s2{2, 5, 6, 9, 7};
    // set difference : loop through s1 to check if s2 does not contain s1 elements
    for (int num1 : s1) {
        if (!s2.count(num1)){
            diff.insert(num1);
        }
    }
    // set intersection : loop through s2 to check if s1 contains s2 elements
    for (int num2 : s2){
        if (s1.count(num2)){
            intersect.insert(num2);
        }
    }
    // log result
    cout << "\n*********C++ Results***********" << endl;
    cout << "Set Difference = "
         << "[";
    for (int i : diff) {
        cout << i << " ";
    }
    cout << "]" << endl;
    cout << "Set Intersection = "
         << "[";
    for (int i : intersect){
        cout << i << " ";
    }
    cout << "]" << endl;
}
Java:
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
 #!usr/bin/python3
diff = set()  # set to hold intersection items
intersect = set()  # set to hold difference items
s1 = set([1, 5, 3, 6, 7, 8])  # set to hold intersection items
s2 = set([2, 5, 6, 9, 7])  # set to hold intersection items
diff = s1.difference(s2)  # set difference
intersect = s1.intersection(s2)  # set intersection
# log results
print("\n********Python Result*********")
print("Set Difference = " + str(diff))
print("Set Intersection = " + str(intersect) + "\n")

 

Python:
#!usr/bin/python3
diff = set()  # set to hold intersection items
intersect = set()  # set to hold difference items
s1 = set([1, 5, 3, 6, 7, 8])  # set to hold intersection items
s2 = set([2, 5, 6, 9, 7])  # set to hold intersection items
diff = s1.difference(s2)  # set difference
intersect = s1.intersection(s2)  # set intersection
# log results
print("\n********Python Result*********")
print("Set Difference = " + str(diff))
print("Set Intersection = " + str(intersect) + "\n")


Output:
