#include<iostream>
using namespace std;
long long int dp[4000001];
bool arr[2001][2001];
int main()
{
int m=4000001;
dp[0]=1;
dp[1]=1;
dp[2]=2;
dp[3]=3;
for(int i=4;i<=13;i++){
dp[i]=dp[i-1]+(2*dp[i-2])+(3*dp[i-3]);
//cout<<i<<"  "<<dp[i]<<endl;
}
long long int n,q;
cin>>n>>q;
m=n+1;
//bool** arr=(bool**)malloc(sizeof(bool*)*m);
//for(int a=0;a<m;a++)
  //  arr[a]=(bool*)malloc(sizeof(bool)*m);
for(int i=1;i<m;i++)
{
for(int j=i;j<m;j++)
{
long long int c=i*j;
c=c*c;
c=c%14;
if(dp[c]%2==0)
{arr[i][j]=true;
arr[j][i]=true;
//cout<<i<<" "<<j<<"hghj"<<endl;
}
else{
arr[i][j]=false;
arr[j][i]=false;
//cout<<i<<" "<<j<<"ppp"<<endl;
}
}
}
int pp[4];
pp[4]=0;
int count=0;
for(int i=1;i<m;i++)
{
for(int j=1;j<m;j++)
{//cout<<i<<" "<<j<<" "<<arr[i][j]<<" "<<arr[j][m-i]<<endl;
if(arr[j][m-i]!=arr[i][j])
count++;
}
}
pp[0]=count;
count=0;
for(int i=1;i<m;i++)
{
for(int j=1;j<m;j++)
{
bool val=arr[m-i][m-j];
if(val!=arr[i][j])
count++;
}
}
pp[1]=count;
count=0;
for(int i=1;i<m;i++)
{
for(int j=1;j<m;j++)
{
bool val=arr[m-j][i];
if(val!=arr[i][j])
count++;
}
}
pp[2]=count;
for(int i=0;i<q;i++)
{
int val;
cin>>val;
val=val%360;
if(val==90)
cout<<pp[0]<<endl;
else if(val==180)
cout<<pp[1]<<endl;
else if(val==270)
cout<<pp[2]<<endl;
else
cout<<"0"<<endl;
}
return 0;

}

