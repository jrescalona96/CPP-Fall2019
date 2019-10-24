#include <chrono>
#include <iostream>
#include <mutex>
#include <random>
#include <utility>
#include <vector>
#include <thread>

using namespace std;

constexpr long long size = 20;
mutex myMutex;

// Factorial
double factorial(double num)
{
    if (num >= 1.0)
    {
        return num * factorial(num - 1.0);
    }
    return 1.0;
}

// sum 1/factorial()
void sumUp(double &sum, const vector<double> &val,
           unsigned long long beg, unsigned long long end)
{
    double localSum = 0.0;

    for (auto it = beg; it <= end; ++it)
    {
        localSum += 1.0 / (factorial(val[it]));
    }
    lock_guard<mutex> myLock(myMutex);
    sum += localSum;
}

// main
int main()
{
    cout << endl;

    // generate random values
    vector<double> randValues;
    for (int i = 0; i <= size; ++i)
    {
        randValues.push_back((double)(i));
    }

    double sum = 0.0;
    auto start = chrono::system_clock::now();

    int threads = 10;
    thread t[threads];
    unsigned long long slice = size / threads;
    int startIdx = 0;
    for (int i = 0; i < threads; ++i)
    {
        cout << "Thread[" << i << "] - slice ["
             << startIdx << ":" << startIdx + slice - 1 << "]" << endl;

        t[i] = thread(sumUp, ref(sum), ref(randValues), startIdx, startIdx + slice - 1);

        startIdx += slice;
    }

    for (int i = 0; i < threads; ++i)
        t[i].join();

    chrono::duration<double> dur = chrono::system_clock::now() - start;
    cout << "Time for addition " << dur.count() << " seconds" << endl;
    cout << "Result: " << sum << endl;

    cout << endl;
}
