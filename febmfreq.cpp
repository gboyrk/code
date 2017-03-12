#include<iostream>
using namespace std;
main()
{
int n,m;
scanf("%d %d",&n,&m);
int arr[n],dp[n];
for(int i=0;i<n;i++)
scanf("%d",&arr[i]);
dp[0]=1;
for(int i=1;i<n;i++)
{
if(arr[i]==arr[i-1])
dp[i]=dp[i-1]+1;
else
dp[i]=1;
cout<<dp[i]<<" ";
}
cout<<endl;
for(int i=0;i<m;i++)
{
int l,r,k;
bool flag=false;
scanf("%d %d %d",&l,&r,&k);
l=l-1;
r=r-1;
int j=l+k-1;
while(j<=r)
{
if(arr[j]==arr[j-k+1] && dp[j]-dp[j-k+1]>=k-1) 
{flag=true;
cout<<arr[j]<<endl;
break;}
j++;
}
if(!flag)
cout<<"-1"<<endl;
}

}
