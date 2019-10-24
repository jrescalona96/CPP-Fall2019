#include <thread>
#include <stdio.h>
#include <cstdlib>
#include <cmath>

int main(int argc, char *argv[])
{
    // initialize
    const int THREADS = argc;
    const int TRIALS = 50000000;

    double startwtime; // Start Time
    // startwtime = MPI_Wtime();

    int localTrials = TRIALS / THREADS; //devide total number of points

    double x, y;
    int inside; 
    srand((unsigned)myid);
    for (int i = 0; i <= localTrials; i++)
    {
        x = ((double)rand() / (double)RAND_MAX); // generate random x coordinate
        y = ((double)rand() / (double)RAND_MAX); // generate random y coordinate
        if (sqrt((x * x) + (y * y)) <= 1.0)
        {
            inside++;
        }
    }
    printf("Process %d caught %d dots with %d trials.\n", myId, inside, myTrials); //print current machine info

    int sumOfInside = 0;
    MPI_Reduce(&inside, &sumOfInside, 1, MPI_INT, MPI_SUM, 0, MPI_COMM_WORLD);

    double halfPi = (double)TRIALS / (double)sumOfInside;

    if (myId == 0)
    {
        double timeElapse = MPI_Wtime() - startwtime;
        printf("\nExecution time  = %fsec.\nPI Value = %f\n", timeElapse, (halfPi * 2));
    }

    //wrap up
    MPI_Finalize();
}