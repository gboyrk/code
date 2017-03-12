#include<iostream>
#include<vector>
#include<algorithm>
#include<limits.h>
#include<bits/stdc++.h>
using namespace std;
bool check(int u,int v,vector<int>& seq,int ind,int n)
{
if(u>v)
return false;
else if(u<0 || v<0 ||u>=n || v>=n)
return false;
else if(v-u+1>seq[ind])
return false;
return true;
}
int dp(int u,int v,vector<int>& arr,vector<int>& seq,vector<int> & sum,int** mat,int ind)
{
if(ind>seq.size())
return 0;
int length=seq[ind];
int n=arr.size();
int maxm=INT_MIN;
for(int i=u;i<=v-length+1;i++)
{
if(check(i+1,i+length-2,seq,ind+1,n)){
int tt;
if(mat[i+1][i+length-2]!=-1)
tt=mat[i+1][i+length-2];
else
tt=dp(i+1,i+length-2,arr,seq,sum,mat,ind+1);
int temp=sum[i+length]-sum[i]-tt;
if(temp>maxm)
maxm=temp;
}
}
cout<<"sdasddasf";
mat[u][v]=maxm;
return maxm;
}

main()
{
int test;
cin>>test;
int n;int m;
cin>>n>>m;
vector<int> arr(n);
vector<int> sum(n+1);
int temp=0;
sum[0]=0;
for(int i=0;i<n;i++)
{cin>>arr[i];
temp+=arr[i];
sum[i+1]=temp;
}
vector<int> seq(m);
for(int i=0;i<m;i++)
cin>>seq[i];
int** mat=(int**)malloc(sizeof(int*)*n);
for(int i=0;i<n;i++)
mat[i]= (int*)malloc(sizeof(int)*n);
memset(mat,-1,sizeof(mat));
cout<<dp(0,seq[0],arr,seq,sum,mat,0);
}

