#include<iostream>
#include<bits/stdc++.h>
#include<unordered_map>
using namespace std;
bool flag;
int  finddfs(bool* visited,vector<int> * arr,int ind,int& ans)
{
	visited[ind]=true;
	int length=0;
	if(flag)
		return INT_MAX;
	for(int i=0;i<arr[ind].size();i++)
	{int temp=arr[ind][i];
		if(visited[temp]==false)
		{
            int vr=finddfs(visited,arr,temp,ans);
			if(length==0)
			length=vr;
		    else if(length!=vr && flag==false) 
		    {
              ans = ind;
              flag=true; 
		    }

		}
	}
cout<<"sds";
	return length+1;
}
int resdfs(bool* visited,vector<int>* arr,int ind,int & minm,bool& ans)
{
visited[ind]=true;
int length=0;
for(int i=0;i<arr[ind].size();i++)
{
	int temp=arr[ind][i];
	if(visited[temp]==false)
	{
		int vr=resdfs(visited,arr,temp,minm,ans);
		if(length==0)
			length=vr;
		    else if(length!=vr) 
		    {
              ans = false;

		    }
		    else if(length==vr)
		    {
		    	if(length>minm)
		    		minm=length;
		    }
        
	}
}
return length+1;
}
main()
{
	int v;
	cin>>v;
	flag=false;
	vector<int> arr[v]; 
	int n=v;
    for(int i=0;i<n-1;i++)
    {
    	int a,b;
    	cin>>a>>b;
    	arr[a].push_back(b);
    	arr[b].push_back(a);}
    	bool* visited =(bool*)calloc(sizeof(bool),n);
    	bool* visited2= (bool*)calloc(sizeof(bool),n);
    	int ans=-1;
    	finddfs(visited,arr,0,ans);
    	/*if(ans==-1)
    	ans=0;
    	unordered_map<int,int> has;
    	int minm=INT_MAX;
    	bool check=true;
        for(int i=0;i<arr[ans].size();i++)
        {
           int l=resdfs(visited2,arr,minm,arr[ans][i],check);
           if(check==false)
           {
           	cout<<"-1";
           	break;
           }
           has[l]=1;
        }	
if(has.size()>2)
	cout<<"-1";
else if(check!=false)
	cout<<minm;
*/
}
de