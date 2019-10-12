1.	C++
Given three pieces of C++ code, run and observe output, then answer the questions below. Note: in order to run the code, you may need to edit the code such as including libraries, adding main functions etc. Also, if any syntax error spotted in the code please let instructor know or make correct based on your best judgement.

(1)	void swap (int x, int y) {
         int t = x;
	x = y;
	y = t;
	return;
}
int a = 10, b = 20;
swap(a,b);
//now print a and b

(2)	void swap (int *px, int *py) {
int t = *px;
*px = *py;
*py = t;
return;
}
int  a = 10, b = 20;
swap (&a, &b);
//print a and b

(3)	void swap (int& x, int& y) {
int t = x; 
x = y;
y = t;
return;
}
int a = 10, b = 20;
swap(a,b);
//now print a and b

Question (a): what is the parameter passing method for each of the above code?
-	(1) Pass-by-Value
-	(2) Pass-by-Reference
-	(3) Pass-by-Reference

Question (b): Run the code and observe the results. Which code(s) swap two values? Which code(s) don’t? Why – briefly explain.
-	Only (2) and (3) swapped the values for a and b. Since we are printing the values of a and b from main(), we are printing the values of a and b from that context. Because (1) only passed the actual value of a and b, they are being copied and this there is no reference to the original memory locations. a and b in swap are totally different memory locations, while (2) and (3) actually passed the address of a and b therefore the correct memory locations were used inside swap(). 


2.	Python 
def swap (x, y) :
    t = x
    x = y
    y = t

a =10
b =20
swap(a,b)
print(a,b)

(a)	What parameter passing method used in the above example?
-	Pass-by-Value

(b)	Run the above program. Based on the output please state whether the function swaps two values or not.
-	The function does not swap a and b

(c)	If the above function doesn’t swap two values, write one line of Python code that would be able to swap two values.
-	a,b = b,a

3.	Java: Write a Java function to swap two integers.

class Swap {
    static int a = 10;
    static int b = 20;

    public static void swap() {
        int t  = a;
        a = b;
        b = t;
    }

    public static void main(String[] args) {
        swap(); 
    }
}

4.	Examine the C++, Python, and Java codes that do swap two values, which one you think is the best, which one you think is the worse – Note: identify the language evaluation criteria you used, but no need to justify.
-	Python is best. Java is worst. Writability.
5.	Looking at the following Python code that attempt to swap L[i]’s value with L[j]’s value.

def swap (Lst, indexA, indexB) :
    t = L[indexA]
    L[indexA] = L[indexB]
    L[indexB] = t

L = [1,2,3,4,5,6,7,8,9,10]
i=3
j=7
print(L[i], L[j])
swap(L,i,j)
print(L[i],L[j])

Question (a): what parameter passing methods are used in each method? (note: multiple parameter passing methods may be used, in this case indicate the parameter name and its corresponding parameter passing method respectively.)
-	Lst : Pass-by-Reference
-	i : Pass-by-Value
-	j : Pass-by-Value

Question (b): will this code swap L[i]’s value with L[j]’s value? Run the code and observe the result.
-	Yes. Since L is being passed as an object, only its reference is being passed.

6.	Write a C++ or Java code that does similar swap action as that in Problem 5.

class Swap {
    public static void main(String[] args ) {
        int[] L = {1,2,3,4,5,6,7,8,9,10};
        int i = 3, j = 7;
        System.out.printf("Original:L[i] = %d, L[j] = %d\n",L[i],L[j]);
        swap(L,i,j);
        System.out.printf("Swapped: L[i] = %d, L[j] = %d\n",L[i],L[j]);
    }
    public static void swap(int[] Lst, int indexA, int indexB) {
        int t = Lst[indexA];
        Lst[indexA] = Lst[indexB];
        Lst[indexB] = t;
    }
}



