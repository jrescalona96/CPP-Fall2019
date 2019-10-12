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