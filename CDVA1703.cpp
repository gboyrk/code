#include<iostream>
using namespace std;
main()
{
int test;
cin>>test;
while(test--)
{
long long int l,r;
cin>>l>>r;
long long int v=l%r;
if(v==0)
v=r;
cout<<v<<endl;
}
}
