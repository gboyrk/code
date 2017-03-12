#include<iostream>
#include<math.h>
using namespace std;
#define PI 3.14159265
double find_angle(double x,double y)
{
if(x==0)
{
if(y>=0)
return (double)0;
else
return (double)(180);
}
else if(y==0)
{
if(x>0)
return (double)90;
else 
return double(270);
}
double ang = atan2 (y,x) * 180 / PI;
if(x>0 && y>0)
{
ang= double(90)-ang;
}
else if(x>0 && y<0)
{
ang= abs(ang) +90;
}
else if(x<0 && y<0)
{
ang= abs(ang) +90;
}
else 
{
double temp = ang -90;
ang = 360-temp;
}
return ang;
}
bool israd(double a,double b)
{
return a*a+b*b-double(50*50)<=0;
}
main()
{
freopen("progress_pie.txt","rt",stdin);
freopen("hcupdemo1_example.out","wt",stdout);
int test;
cin>>test;
for(int t=1;t<=test;t++)
{
int p,x,y;
cin>>p>>x>>y;
p=(double)p;
x=(double)x;
y=double(y);
//cout<<p<<x<<y;
p=(double) p*(double)360;
p=p/100;
x=x-50;
y=y-50;
double ang=find_angle(x,y);
//cout<<p<<endl;
//cout<<" "<<ang<<endl;
if(ang<=p && israd(x,y) && p!=0|| abs(ang-p)<=0.000001)
cout<<"Case #"<<t<<":"<<" "<<"black"<<endl;
else
cout<<"Case #"<<t<<":"<<" "<<"white"<<endl;
}

}
