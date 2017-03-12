#include<iostream>
using namespace std;
main()

{
int a,b;
cin>>a>>b;
if(a==0 && b==0)
cout<<"NO";
else if(a==b || a==b+1 || a+1==b)
cout<<"YES";
else
cout<<"NO";
}

