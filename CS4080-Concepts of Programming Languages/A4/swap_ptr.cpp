#include <iostream> 
#include <iomanip> 
using namespace std;

//headers
void swap (int *px, int *py);

int main(int argc, char *argv[])
{
    int a = 10, b = 20;
    swap(a, b);
    printf("swap() using values: a = %d, b = %d\n",a,b);
    return 0;
}

//swap using pointers
void swap (int *px, int *py) {
    int t = *px;
    *px = *py;
    *py = t;
}
