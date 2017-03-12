#include<iostream>
#include<string>
using namespace std;
bool rec(string* arr,int ind)
{
	if(ind==0)
	return true;
    cout<<ind<<" "<<arr[ind]<<endl;
	if(ind-1>=0 && (arr[ind-1][0]==arr[ind][0] || arr[ind-1][1]==arr[ind][1]))
	{
	string temp = arr[ind-1];
	arr[ind-1]=arr[ind];
	if(rec(arr,ind-1))
	return true;
	arr[ind-1]=temp; 
	}

	if(ind-3>=0 && (arr[ind-3][0]==arr[ind][0] || arr[ind-3][1]==arr[ind][1]))
	{
	string temp = arr[ind-3];
	arr[ind-3]=arr[ind];
	if(rec(arr,ind-1))
	return true;
	arr[ind-3]=temp; 
	}
	return false;

}
main()
{
int num;
cin>>num;
string arr[num];
for(int i=0;i<num;i++)
{
cin>>arr[i];	
}
if(rec(arr,num-1))
cout<<"YES";
else
cout<<"NO"; 
}