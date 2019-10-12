#include "/opt/openmpi-2.1.2/mpi.h"
#include <stdio.h>
#include <cstdlib>
#include <cmath>

int main(int argc, char *argv[])
{
    // initialize
    int myId, numprocs, namelength, myTrials;
    const int TRIALS = 50000000;
    char processor_name[MPI_MAX_PROCESSOR_NAME];

    MPI_Init(&argc, &argv);                   //start
    MPI_Comm_size(MPI_COMM_WORLD, &numprocs); // get number of processes in group
    MPI_Comm_rank(MPI_COMM_WORLD, &myId);     // get process id
    MPI_Get_processor_name(processor_name, &namelength);

    printf("Process %d on %s\n", myId, processor_name); //print current machine info

    double startwtime; // Start Time
    if (myId == 0)
    {
        startwtime = MPI_Wtime();
    }

    myTrials = TRIALS / numprocs; //devide total number of points

    double x, y;
    int inside;
    srand((unsigned)myid);
    for (int i = 0; i <= myTrials; i++)
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