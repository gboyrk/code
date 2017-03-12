#include<iostream>
using namespace std;
main()
{
int l,a,b;
cin>>l>>a>>b;
int first[l],second[l];
for(int i=0;i<l;i++)
cin>>first[i];
for(int j=0;j<l;j++)
cin>>second[j];
int last[l];

for(int i=0;i<l;i++)
{last[i]=first[i]+second[i];
}
int sm=last[0];
for(int i=1;i<l;i++)
{//cout<<last[i]<<" ";
if(sm>last[i])
sm=last[i];
}
sm=sm-a;
bool flag=false;
for(int i=0;i<l;i++)
{last[i]-=sm;
if(last[i]>b)
flag=true;
}
if(flag)
cout<<"-1";
else
{
for(int i=0;i<l;i++)
cout<<last[i]<<" ";
}
}

