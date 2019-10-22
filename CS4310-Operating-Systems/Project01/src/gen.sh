#!/bin/bash

for run in {1..10};
    do
        for file in 5 10 15;
            do java GenerateData $file $run
        done 
done
