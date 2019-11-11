1. Given a list of student names and corresponding quiz scores, we’d sort in a number of different ways:
   - [ ] sort in **ascending order of names**, if same name **ascending order of scores**
   - [ ] sort in **ascending order of names**, if same name **descending order of scores**;
   - [ ] sort in **descending order of names**, if same name **descending order of scores**.

> Use any language (of your choice) to program the above tasks by writing one sort function only but may have a number of auxiliary (help) functions for ordering.
>
> - Write a main function/program that makes **three calls to the sort function** to accomplish the above three different sorting tasks.
> - Test the program using the following data (note: you may store data in an array or a list or whatever data structure you think appropriate.)
> - Initialize the input data in the program instead of entering from keyboard or reading from file.

- Dan 45
- Adam 39
- Fiona 42
- Kathy 44
- Dan 34
- Adam 41
- Kalin 50
- Adam 40
- Zehr 43
- Mona 42
- Kevin 35
- Elma 48

# **Classes**

> # Student
>
> This class will hold information about student
>
> ## Fields
>
> - String name
>
> - Integer grade

> # Sorter
>
> This class defines all sorting using **quick sort** with a modified comparator provided by the calling function
>
> ```java
> sort(ArrayList \<Student> students, Comparator::compareVersion1)
> ```
>
> Parameters:
>
> - ArrayList students
> - Reference to the correct version of compare function from Comparator
>
> Retruns:
>
> - sorted ArrayList students

> # Comparator
>
> This class implements differnent variations for the compare function. Methods are generic to take in either String or Integer
>
> compareA ( \<T> x , \<T> y )
>
> - returns TRUE if x > y, FALSE otherwise

# **Algorithms**

## 1. Ascending names, then Ascending scores

>

## 2. Ascending names, then Descending scores

## 3. Descending names, then Descending scores

# Run Script

> `javac *.java && java Sorter`

2. _(Use a typed language that supports generic subprogram – note: Python not eligible)_ Write a generic function find_max that finds the first occurrence of the “largest” element in a matrix.

> For example:
> in the following 3x4 matrix of integers
>
> `[1,2,4,4]`
>
> `[5,5,4,2]`
>
> `[3,1,1,5]`
>
> the first occurrence of the largest element is 5 at position/indices (1,0).

> In the following 5x2 matrix of strings
>
> `[“David”, “Kelin”]`
>
> `[“Peter”, “Zag”]`
>
> `[“Diana”, “Elin”]`
>
> `[“Adam”, “Young”]`
>
> `[“Peter”, “Zag”]`
>
> the first occurrence of the largest element is “Zag” at position/indices (0,3).

Write a main program to provide at **least two test runs**. You may use input data similar to the above but with larger matrix sizes. Initialize the input data in program code.

# Findings

```java
// import comparable
import java.util.Comparable;

// KEY: must extend Comparable in methods that uses compareTo()
public <T extends Comparable<T>> void findMaxValue(T[][] arr) {... val1.compareTo(val2) ...}
```
