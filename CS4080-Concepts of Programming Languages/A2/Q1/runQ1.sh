clear

# compile C++ files
cd C++
sudo g++ -std=c++11 stack.cpp -o stack
sudo g++ -std=c++11 heap.cpp -o heap
printf "\nC++ Results \n"
printf "\nTask 1: Stack (microseconds): "
for run in {1..10}; do ./stack; done
printf "\nTask 2: Heap (microseconds): "
for run in {1..10}; do ./heap; done

# compile java files
cd ../Java
javac Arrays.java ArrayLists.java -Xlint
printf "\n\nJava Results \n"
printf "\nTask 3: Arrays (microseconds): "
for run in {1..10}; do java Arrays; done 
printf "\nTask 4: ArrayList (microseconds): "
for run in {1..10}; do java ArrayLists; done
printf "\n\n"