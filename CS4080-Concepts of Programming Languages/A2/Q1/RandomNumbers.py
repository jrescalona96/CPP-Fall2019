#!/usr/bin/python3
import random
import collections as col


def random1():
    # using randrange()
    for i in range(1000):
        print(str(i+1) + ":" + str(random.randrange(0, 8000)))


def random2():
    # using choice()
    numbers = []
    for i in range(8000):
        numbers.append(i)
    numbersList = col.UserList(numbers)
    for j in range(1000):
        print(str(j+1) + ":" + str(random.choice(numbersList)))


if __name__ == "__main__":
    random1()
    # random2()
