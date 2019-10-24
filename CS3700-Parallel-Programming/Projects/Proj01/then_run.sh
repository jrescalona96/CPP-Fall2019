#!/bin/bash 
module load openmpi/2.1.2
echo "loaded open-mpi module....."
chmod +x then_run.sh
echo "chmod then_run"
echo "compiling now...."
g++ -o pi_mpi  pi_mpi.cpp -I /opt/openmpi-2.1.2/include  -L /opt/openmpi-2.1.2/lib -l mpi