#include<iostream>
#include<math.h>
using namespace std;
#define PI 3.14159265
double degrad( double degrees )
{ 
    return degrees * PI / 180; 
} 
bool fun(double q,double r,double a,double b)
{
 return -a*r+b*q>0;
}
bool inra(double a,double b,double rad)
{
return a*a+b*b-rad*rad<=0;
}
main()
{
int test;
cin>>test;
while(test--)
{
double p,q,r;
cin>>p>>q>>r;
int lx=50,ly=50;
q=q-50;
r=r-50;
p=double(p);
double angle=(p*360)/100;
double a=50*cos(degrad(angle - 90.00000000));
double b=50*sin(degrad(angle - 90.00000000));
cout<<a<<" "<<b;
if(fun(q,r,0,50) && !fun(q,r,-a,-b) && inra(q,r,50))
cout<<"black";
else
cout<<"white";
}
}
