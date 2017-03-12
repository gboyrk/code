#include<iostream>
#include<vector>
#include<bits/stdc++.h>
using namespace std;
main()
{
	int n,m;
	cin>>n>>m;
	vector<string> vec(n);
	for(int l=0;l<n;l++)
	{
		string str;
		cin>>str;
		vec[l]=str;
	}
	int arr[n][3][3];
        for(int i=0;i<n;i++)
{
for(int j=0;j<3;j++)
for(int k=0;k<3;k++)
arr[i][j][k]=123456;
}
	for(int i=0;i<n;i++)
	{
		for(int j=0;j<m;j++)
		{
			if(vec[i][j]-'0'>=0 && vec[i][j]-'0' <=9)
                         {
for(int k=0;k<3;k++)
{
if(arr[i][1][k]==123456)
{arr[i][1][k]=j;break;}
}
}
			
			else if(vec[i][j]>= 'a' && vec[i][j]<='z')
		{
for(int k=0;k<3;k++)
{
if(arr[i][2][k]==123456)
{arr[i][2][k]=j;break;}
}
}

			else 
		                          {
for(int k=0;k<3;k++)
{
if(arr[i][0][k]==123456)
{arr[i][0][k]=j;break;}
}
}
		}
	}
//for(int i=0;i<3;i++)
//cout<<arr[i][0] <<" "<<arr[i][1]<<" "<<arr[i][2]<<endl; 
	int minm=12345678;
//       int minm=12345678;
        for(int i=0;i<n;i++){
        for(int a=0;a<3;a++){
        for(int j=0;j<n;j++){
        for(int b=0;b<3;b++){
        for(int k=0;k<n;k++){
        for(int c=0;c<3;c++)
{
if(arr[i][0][a]!=123456 && arr[j][1][b]!=123456 && arr[k][2][c]!=123456  && i!=j && j!=k && i!=k)
{
if(arr[i][0][a] + arr[j][1][b] + arr[k][2][c] <minm)
minm=arr[i][0][a] + arr[j][1][b] + arr[k][2][c];
}
}
}
}
}
}
}

cout<<minm;
}
