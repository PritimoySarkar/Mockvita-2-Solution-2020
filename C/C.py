def picc(m,l,w):
    if(m[l-1][w-1]!=-1): return m[l-1][w-1]
    d=l//w
    nl=l%w
    if(nl==0): return d
    m[l-1][w-1]=d+picc(m,w,nl)
    return m[l-1][w-1]
l1=5
l2=7
w1=3
w2=4
count=0
m=[ [-1]*w2 for i in range(l2)]
#print(m)
for i in range(l1,l2+1):
    for j in range(w1,w2+1):
        count+=picc(m,i,j)
print(count)