import math
def graph(p):
    count=0
    for i in p:
        ind=i
        while(1):
            if(ind not in p): return count
            if(p[ind]==ind):
                p.pop(ind)
                return count
            count+=1
            temp=p[ind]
            p.pop(ind)
            ind=temp
T=int(input())
for j in range(T):
    n=int(input())
    l=list(map(int,input().split()))
    p={}
    for i in range(n): p[i]=l[i]-1
    bkp=p.copy()
    c=[]
    while(len(p)>0): c.append(graph(p))
    c=list(set(c))
    if (0 in c): c.remove(0)
    cc=1
    for i in c: cc=(cc*i)//math.gcd(cc,i)
    print(cc)