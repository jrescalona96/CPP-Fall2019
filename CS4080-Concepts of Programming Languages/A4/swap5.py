def swap (Lst, indexA, indexB) :
    t = L[indexA]
    L[indexA] = L[indexB]
    L[indexB] = t

L = [1,2,3,4,5,6,7,8,9,10]
i=3
j=7
print(L[i], L[j])
swap(L,i,j)
print(L[i],L[j])
