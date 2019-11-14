# Q1
- Write a **generic ADT Matrix** which defines an **n x m matrix** of **type T**.
> - In addition to constructors *(if needed)*
> - create a method named **find_max()** within ADT
> > - that finds the **first occurrence of the “largest” element** in a matrix

> - For example, in the following 3x4 matrix of integers
> > [1,2,4,4] [5,5,4,2] [3,1,1,5]
> - the first occurrence of the largest element is 5 at position/indices (1,0).
> - In the following 5x2 matrix of strings
> > [“David”, “Kelin”, “Peter”, “Zag”, “Diana”], [“Elin”, “Adam”, “Young”, “Peter”, “Zag”]
> - the first occurrence of the largest element is “Zag” at position/indices (0,3)

> Write a **main()** method
> - that creates the above **two matrices**
> - calls the **find_max()** method to find the first occurrence of the **largest element** as well as the **corresponding indices**

# Q2
1. Write a **parent class Rectangle** with an 
    - **area calculation method in dynamic binding**
    - **area calculation method in static binding**
2. Write a 
    - **child class Square** with an area calculation method that **overrides the Rectangle class’s area method**. *(note: in C++ use virtual for dynamic binding, in Java use static or final for static binding.)*
3. Write a **main program** that 
    - calls both the **dynamically bound method** and the **statically bound method** a large number of times **(say 1000 times)**
    - **timing the calls** to static binding method as well as to the dynamic binding method respectively
4. Compare the results and explain the difference