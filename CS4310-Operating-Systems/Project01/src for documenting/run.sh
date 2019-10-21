#!/bin/bash

echo "FIRST COME FIRST SERVE***********************************************"
for file in 5 10 15;
    do
        for run in {1..10};
            do java FCFS $file $run
        done 
done
echo "*********************************************************************"

echo "SHOTEST JOB FIRST****************************************************"
for file in 5 10 15;
    do
        for run in {1..10};
            do java SJF $file $run
        done 
done
echo "*********************************************************************"

echo "ROUND ROBIN 2********************************************************"
for file in 5 10 15;
    do
        for run in {1..10};
            do java RR2 $file $run
        done 
done
echo "*********************************************************************"

echo "ROUND ROBIN 5********************************************************"
for file in 5 10 15;
    do
        for run in {1..10};
            do java RR5 $file $run
        done 
done
echo "*********************************************************************"