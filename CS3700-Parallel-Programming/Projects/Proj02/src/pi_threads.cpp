#include <cmath>
#include <chrono>
#include <iostream>
#include <mutex>
#include <random>
#include <utility>
#include <thread>
#include <string>

using namespace std;

const long long size = 100;
mutex lock_mutex;

// FUNTIONS //
void runSimulation(double &totalHits, int id, long long slice)
{
    double localHits;
    long long x, y;
    long long localSlice;
    srand((unsigned)id);

    printf("Thread %d online\n", id + 1);
    for (int i = 0; i <= localHits; i++)
    {
        x = ((double)rand() / (double)RAND_MAX); // generate random x coordinate
        y = ((double)rand() / (double)RAND_MAX); // generate random y coordinate
        if (sqrt((x * x) + (y * y)) <= 1.0)
        {
            localHits++;
        }
    }
    // set lock automatically will be unlocked after
    lock_guard<mutex> local_lock(lock_mutex);
    totalHits += localHits;
    printf("=> Thread %d finished\n", id);
}

// MAIN //
int main(int argc, char **argv)
{
    if (strcmp("0", argv[1]))
    {
        // DECLARATIONS
        long long threads = stoi(argv[1]);
        thread td[threads];
        double totalHits = 0.0;
        int threadID;

        auto start = chrono::system_clock::now();

        unsigned long long slice = size / threads; // divide trials

        cout << "Creating " << threads << " threads" << endl;
        for (int i = 0; i < threads; i++)
        {
            //TODO: Need to account for ONLY up to the given size.
            threadID = i;
            td[threadID] = thread(runSimulation, ref(totalHits), threadID, slice);
        }

        for (int i = 0; i < threads; i++)
        {
            td[i].join();
            cout << threadID << " joined" << endl;
        }

        // print results
        chrono::duration<double> elapseTime = chrono::system_clock::now() - start;
        cout << "Execution time: " << elapseTime.count() << " seconds" << endl;
        cout << "Result: " << totalHits << "out of" << size << endl;
        cout << "pi =  " << ((totalHits / size) * 4) << endl;
    }
    else
    {
        cout << "Invalid Input: must input valid number of Threads!" << endl;
    }
}
