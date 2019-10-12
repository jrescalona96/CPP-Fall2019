#include "mpi.h"
#include <cstdio>
#include <cmath>
#include <cstdlib>

#define ARRAY_SIZE 20

//factorial
double factorial(int num) {
    if(num == 1 || num==0) {
        return 1;
    } else {
         return num*factorial(num-1);
    }
}

int main(int argc, char *argv[])
{

    int myid, numprocs;
    int namelen;
    int *numbers = new int[ARRAY_SIZE];
    char processor_name[MPI_MAX_PROCESSOR_NAME];

    MPI_Init(&argc, &argv);
    MPI_Comm_size(MPI_COMM_WORLD, &numprocs);
    MPI_Comm_rank(MPI_COMM_WORLD, &myid);
    MPI_Get_processor_name(processor_name, &namelen);

    printf("Process %d on %s\n", myid, processor_name); //print computer node name

    for (int i = 0; i < ARRAY_SIZE; i++)
        numbers[i] = i; //could be randomly generated , store to nubers array

    int s = (int)floor(ARRAY_SIZE / numprocs);
    int s0 = s + ARRAY_SIZE % numprocs;

    int startIndex = s0 + (myid - 1) * s;
    int endIndex = startIndex + s;

    double startwtime;
    if (myid == 0)
    {
        startwtime = MPI_Wtime();
    }

    int i;
    double part_sum = 0.0;

    if (myid == 0)
    {
        // master worker - compute the master's numbers
        for (i = 0; i < s0; i++)
        {
            part_sum += 1.0 / factorial(numbers[i]);
        }
        printf("Process %d - startIndex 0 endIndex %d; part_sum %lf\n",
               myid, s0 - 1, part_sum);
    }
    else
    {
        //slave's work
        for (i = startIndex; i < endIndex; i++)
        {
            part_sum += 1.0 / factorial(numbers[i]);
        }
        printf("Process %d - startIndex %d endIndex %d; part_sum %lf\n",
               myid, startIndex, endIndex - 1, part_sum);
    }
    
    double sum = 0;
    MPI_Reduce(&part_sum, &sum, 1, MPI_DOUBLE, MPI_SUM, 0, MPI_COMM_WORLD);

    if (myid == 0)
    {
        double runTime = MPI_Wtime() - startwtime;
        printf("\nExecution time (sec) = %f sum = %lf \n",
               runTime, sum);
    }

    delete[] numbers;

    MPI_Finalize();
}

