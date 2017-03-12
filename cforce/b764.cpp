#include<iostream>
using namespace std;
main()
{
int size;
cin>>size;
int arr[size+1];
for(int i=1;i<=size;i++)
cin>>arr[i];
for(int i=1;i<=size/2;i++)
{
if(i%2!=0)
{
int temp=arr[size-i+1];
arr[size-i+1]=arr[i];
arr[i]=temp;
}
}
for(int i=1;i<=size;i++)
cout<<arr[i]<<" ";
}
