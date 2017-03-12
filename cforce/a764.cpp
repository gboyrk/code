#include<iostream>
using namespace std;
int gcd(int a,int b)
{
if(a==b)
return a;
if(a>b)
return gcd(a-b,b);
return gcd(a,b-a);
}
int lcm(int a,int b)
{
int result= (a*b)/(gcd(a,b));
return result;
}
main()
{
int a,b,z;
cin>>a>>b>>z;
int x=lcm(a,b);
cout<<z/x;
}
