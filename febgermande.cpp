#include<iostream>
using namespace std;
main()
{
int test;
cin>>test;
while(test--)
{
int o1,o2;
scanf("%d %d",&o1,&o2);
int n=o1*o2;
int arr[o1*o2];
for(int i=0;i<n;i++)
{scanf("%d",&arr[i]);
if(arr[i]==0)
arr[i]=-1;
}
bool dp[n];
int temp=0,i=0,k=0;
for(i=0;i<o2;i++)
{
temp+=arr[i];
if(i==o2-1)
{
if(temp>0)
dp[0]=true;
else
dp[0]=false;
k++;
}
}
for(;k<n;k++)
{
temp-=arr[((i%n)-o2+n)%n];
temp+=arr[(i%n)];
if(temp>0)
dp[k]=true;
else
dp[k]=false;
i++;
//cout<<k<<"  "<<dp[k]<<endl;
}
bool flag=false;
for(int i=0;i<o2;i++)
{
int count=0,j=i,num=0;
while(num!=o1)
{
if(dp[j]==true)
count++;
num++;
j=(j+o2)%n;
}
if(count>(o1/2))
{flag=true;
break;}
}
if(flag)
cout<<"1"<<endl;
else
cout<<"0"<<endl;
}
}
