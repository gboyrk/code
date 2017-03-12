#include<iostream>
#include<vector>
#include<algorithm>
#include<limits.h>
#include<bits/stdc++.h>
using namespace std;
bool check(long long int u,long long int v,vector<long long int>& seq,long long int ind,long long int n)
{
if(u>v)
return false;
else if(u<0 || v<0 ||u>=n || v>=n)
return false;
else if(v-u+1<seq[ind])
return false;
return true;
}
long long int dp(long long int u,long long int v,vector<long long int>& arr,vector<long long int>& seq,vector<long long int>& sum,long long int** mat,long long int ind)
{
if(ind>=seq.size())
return 0;
//cout<<"sds";
long long int length=seq[ind];
long long int n=arr.size();
long long int maxm=INT_MIN;
for(long long int i=u;i<=v-length+1;i++)
{
long long int temp=INT_MIN;
if(ind+1>=seq.size() )
temp=sum[i+length]-sum[i];
else if(check(i+1,i+length-2,seq,ind+1,n)){
long long int tt;
if(mat[i+1][i+length-2]!=-1)
tt=mat[i+1][i+length-2];
else
tt=dp(i+1,i+length-2,arr,seq,sum,mat,ind+1);
temp=sum[i+length]-sum[i]-tt;
}
if(temp>maxm)
maxm=temp;
}
mat[u][v]=maxm;
return maxm;
}

main()
{
long long int test;
cin>>test;
while(test--){
long long int n;long long int m;
cin>>n>>m;
vector<long long int> arr(n);
vector<long long int> sum(n+1);
long long int temp=0;
sum[0]=0;
for(long long int i=0;i<n;i++)
{cin>>arr[i];
temp+=arr[i];
sum[i+1]=temp;
}
vector<long long int> seq(m);
for(long long int i=0;i<m;i++)
cin>>seq[i];
//cout<<"rgrfg";
long long int** mat=(long long int**)malloc(sizeof(long long int*)*n);
for(long long int i=0;i<n;i++)
mat[i]= (long long int*)malloc(sizeof(long long int)*n);
for(long long int i=0;i<n;i++)
{for(long long int j=0;j<n;j++)
{
	mat[i][j]=-1;
}
}
long long int x=dp(0,n-1,arr,seq,sum,mat,0);
cout<<x;
cout<<endl;

}
}
