n=int(input())
f=input()
m=input()
fl=[i for i in f]
ml=[i for i in m]
for i in range(n):
    x=fl[0]
    if(x in ml):
        ind=ml.index(x)
        ml.remove(ml[ind])
        fl.remove(fl[0])
        new=ml[:ind]
        ml=ml[ind:]
        ml=ml+new
    else: break
print(len(fl))