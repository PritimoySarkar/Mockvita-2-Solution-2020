from collections import Counter
n=int(input())
l=list(map(str,input().split()))
b=[]
for j in l:
    temp=[int(i) for i in j]
    v=11*max(temp)+7*min(temp)
    v=str(v)
    v=v[-2:-1]
    v=int(v)
    b.append(v)
b1=[]
b2=[]
for i in range(1,n+1):
    if(i%2==0): b2.append(b[i-1])
    else: b1.append(b[i-1])
b1c=Counter(b1)
b2c=Counter(b2)
pair=0
for i in range(10):
    if(b1c[i] == 2):
        pair+=1
        if(b2c[i] > 1):
            pair+=1
    elif(b1c[i] > 2): pair+=2
    elif(b2c[i] == 2): pair+=1
    elif(b2c[i] > 2): pair+=2
print(pair)