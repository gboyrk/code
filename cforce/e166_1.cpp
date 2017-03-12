#include<iostream>
using namespace std;
long long int mod=1000000007;
main()
{
int num;
cin>>num;
long long int d=1,a=0,b=0,c=0;
for(int i=2;i<=num+1;i++)
{
long long int v1=d%mod,v2=a%mod,v3=b%mod,v4=c%mod;
d=a+b+c;
d%=mod;
a=(v1+v3+v4);
a%=mod;
b=(v1+v2+v4);
b%=mod;
c=(v1+v3+v2);
c%=mod;
}
cout<<d;
}

