#!/bin/bash

echo "FIRST COME FIRST SERVE-----------------------------------------------"
for run in {1..10};
    do
        for file in 5 10 15;
            do java FCFS $file
        done 
done
echo "---------------------------------------------------------------------"

echo "SHOTEST JOB FIRST-----------------------------------------------"
for run in {1..10};
    do
        for file in 5 10 15;
            do java SJF $file
        done 
done
echo "---------------------------------------------------------------------"

echo "ROUND ROBIN 2-----------------------------------------------"
for run in {1..10};
    do
        for file in 5 10 15;
            do java RR2 $file
        done 
done
echo "---------------------------------------------------------------------"

echo "ROUND ROBIN 5-----------------------------------------------"
for run in {1..10};
    do
        for file in 5 10 15;
            do java RR5 $file
        done 
done
echo "---------------------------------------------------------------------"