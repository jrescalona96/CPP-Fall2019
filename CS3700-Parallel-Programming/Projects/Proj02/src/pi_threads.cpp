#include <cmath>
#include <chrono>
#include <iostream>
#include <mutex>
#include <random>
#include <utility>
#include <thread>
#include <string>

using namespace std;

const double size = 1000000000.0;
mutex lock_mutex;

// FUNTIONS //
void runSimulation(double &totalHits, int id, unsigned long long start, unsigned long long end)
{
    double localHits;
    double x, y, c;
    long long localSlice = end - start;
    srand((unsigned)id);
    for (int i = 0; i <= localSlice; i++)
    {
        x = ((double)rand() / (double)RAND_MAX); // generate random x coordinate
        y = ((double)rand() / (double)RAND_MAX); // generate random y coordinate
        c = sqrt((x * x) + (y * y));
        if (c <= 1.0)
        {
            localHits++;
        }
    }
    // set lock automatically will be unlocked after

    lock_guard<mutex> local_lock(lock_mutex);
    totalHits += localHits;
}

// MAIN //
int main(int argc, char **argv)
{
    if (strcmp("0", argv[1]))
    {
        // DECLARATIONS
        int threads = stoi(argv[1]);
        thread td[threads];
        double totalHits = 0.0;
        int threadID;

        auto start = chrono::system_clock::now();
        unsigned long long slice = size / threads;
        unsigned long long startIndex = 0, endIndex = slice - 1;
        printf("\nSlice = %lld\n\n", slice);
        for (int i = 0; i < threads; i++)
        {
            threadID = i;
            printf("Thread %d,  Slice: [%lld:%lld]\n", threadID, startIndex, endIndex);
            td[threadID] = thread(runSimulation, ref(totalHits), threadID, startIndex, endIndex);
            startIndex = endIndex + 1;
            //TODO: Need to account for ONLY up to the given size.
            if (i == (threads - 1))
            {
                unsigned long long endIndex = size - 1;
            }
            else
            {
                endIndex = startIndex + slice - 1;
            }
        }
        printf("Created %d threads\n\n", threads);

        for (int i = 0; i < threads; i++)
        {
            td[i].join();
            printf("Thread %d joined\n", i);
        }

        // print results
        chrono::duration<double> elapseTime = chrono::system_clock::now() - start;
        cout << "\nExecution time: " << elapseTime.count() << " seconds" << endl;
        cout << "Result: " << totalHits << " out of " << size << endl;
        cout << "pi =  " << ((totalHits / size) * 4) << endl;
    }
    else
    {
        cout << "Invalid Input: must input valid number of Threads!" << endl;
    }
}
