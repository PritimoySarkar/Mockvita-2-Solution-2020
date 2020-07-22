l=list(map(int,input().split()))
sm=sum(l)
col=sm+1
row=len(l)+1
dp=[[-1]*col for i in range(row)]
for i in range(col): dp[0][i]=False
for i in range(row): dp[i][0]=True
for i in range(1,row):
    for j in range(1,col):
        dp[i][j]=dp[i-1][j]
        temp=l[i-1]
        if(temp<=j): dp[i][j]=(dp[i][j]) or (dp[i-1][j-temp])
idle=sm//2+sm%2
for i in range(idle,sm+1):
    if((dp[len(l)][i])==True):
        print(i)
        break