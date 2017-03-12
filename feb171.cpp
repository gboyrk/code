#include<iostream>
using namespace std;
main()
{
int test;
cin>>test;
while(test--)
{
int n;
cin>>n;
int arr[n];
for(int i=0;i<n;i++)
cin>>arr[i];
int j=0;
while(j<n && arr[j]==1 )
j++;
int fine=n-j;
int count=0;
for(;j<n;j++)
{
if(arr[j]==0)
count++;
}
int total=fine*100+count*1000;
cout<<total<<endl;
}
}
