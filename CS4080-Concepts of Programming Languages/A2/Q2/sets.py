#!usr/bin/python3
diff = set()  # set to hold intersection items
intersect = set()  # set to hold difference items

s1 = set([1, 5, 3, 6, 7, 8])  # set to hold intersection items
s2 = set([2, 5, 6, 9, 7])  # set to hold intersection items

diff = s1.difference(s2)  # set difference
intersect = s1.intersection(s2)  # set intersection

# log results
print("\n********Python Result*********")
print("Set Difference = " + str(diff))
print("Set Intersection = " + str(intersect) + "\n")
