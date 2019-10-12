def swap (x, y) :
    t = x
    x = y
    y = t

a =10
b =20
print("Original: a="+str(a), "b=" + str(b))
swap(a,b)
print("Swapped: a="+str(a), "b=" + str(b))

# operation can be done with a,b=b,a